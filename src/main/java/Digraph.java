import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    int V;
    int E;
    Bag<Integer>[] adj;
    int[] indegree;

    public int V() {
        return V;
    }

    public Digraph(In in) {
        V = in.readInt();
        indegree = new int[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int v = 0; v < V; v++) {
            stringBuilder.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                stringBuilder.append(String.format("%d ", w));
            }
            //stringBuilder.append("\n");
            stringBuilder.append(NEWLINE);
        }
        return stringBuilder.toString();
    }

    public int E() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    public Digraph(int v) {
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        StdOut.println(G);
    }
}
