import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFS {
    /* This code finds out if a vertex is connected / reachable */
    private boolean[] marked;

    // s is the vertex we are trying to find out if is reachable
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) dfs(G, s);
        }
    }


    public void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(new In(args[0]));
        DirectedDFS directedDFS = new DirectedDFS(digraph, 2);
        for (int i = 0; i < digraph.V(); i++) {
            if (directedDFS.marked(i)) StdOut.println(i+" ");
        }
    }
}
