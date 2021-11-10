import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

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
            addEdge(v, vv);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public CopyGraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public CopyGraph CopyGraph(CopyGraph g) {
        CopyGraph gg = new CopyGraph(g.V());
        for (int v = 0; v < g.V(); v++) {
            for (int w:adj[v]) {
                //gg.addEdge(v,w);
                gg.adj[v].add(w);
            }
        }
        return gg;
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

    public static void main(String[] args) {
        In in = new In(args[0]);
        //CopyGraph cG = new CopyGraph(in);
        CopyGraph originalGraph = new CopyGraph(in);
        StdOut.println("Here is the original graph: "+originalGraph);
        CopyGraph newGraph = originalGraph.CopyGraph(originalGraph);
        StdOut.println("Here is the copy: "+newGraph);
        originalGraph.addEdge(0,12);
        StdOut.println("Here is the original graph: "+originalGraph);
        StdOut.println("Here is the copy: "+newGraph);
    }
}
