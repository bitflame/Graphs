import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("unchecked")
public class CopyGraph {
    Bag<Integer>[] adj;
    private final int V;
    private int E;

    public CopyGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int w = 0; w < E; w++) {
            int v = in.readInt();
            int vv = in.readInt();
            /* exercise 4.1.5 - In order to prevent self loops and parallel edges do the following: */
            if (!hasEdge(v, vv))
                addEdge(v, vv);
            else {
                StdOut.println("self loops are not allowed");
            }
        }
    }

    public void addEdge(int v, int w) {
        if (v == w)
            throw new IllegalArgumentException("You can not add a self loop " + v + " and " + w + " vertices are the same" +
                    " and they are not allowed.");
        else if (hasEdge(v, w) == true)
            throw new IllegalArgumentException("You can not add a parallel loop " + v + " " + w + " edge " +
                    "is already in the adjacency table.");
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public CopyGraph(Integer V) {
        this.V = V;

        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public CopyGraph(CopyGraph g) {
        this(g.V());
        for (int v = 0; v < g.V(); v++) {
            this.adj[v] = new Bag<>();
            for (int w : g.adj[v]) {
                //gg.addEdge(v,w);
                this.adj[v].add(w);
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int v = 0; v < V; v++) {
            stringBuilder.append(v + ": ");
            for (int w : adj[v]) {
                stringBuilder.append(w + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // exercise 4.1.4
    public boolean hasEdge(int v, int w) {
        for (int ww : adj[v]) {
            if (ww == w) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // this test client is the answer to equestion 7
        In in = new In(args[0]);
        CopyGraph originalGraph = new CopyGraph(in);
        StdOut.println("Here is the original graph: \n" + originalGraph);
        CopyGraph newGraph = new CopyGraph(originalGraph);
        StdOut.println("Here is the copy: \n" + newGraph);
        originalGraph.addEdge(0, 12);
        StdOut.println("Here is the modified version of the original graph: \n" + originalGraph);
        StdOut.println();
        StdOut.println("Here is the copy: \n" + newGraph);
        StdOut.println("Is 0,5 an edge? " + originalGraph.hasEdge(0, 5));
        StdOut.println("Is 0,7 an edge? " + originalGraph.hasEdge(0, 7));
        StdOut.println("exer 4.1.5: Here is what happens when we try to add a parallel edge: ");
        // originalGraph.addEdge(0, 5);
        StdOut.println("or self loops");
        originalGraph.addEdge(0, 0);
    }
}
