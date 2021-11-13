import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

public class SearchGraph {
    /* We have already seen one way to implement the Search API: the union-find algo-
rithms of Chapter 1. The constructor can build a UF object, do a union() operation
for each of the graph’s edges, and implement marked(v) by calling connected(s, v).
Implementing count() requires using a weighted UF implementation and extending
its API to use a count() method that returns wt[find(v)] (see Exercise 4.1.8). But it looks like
count is working without implementing the weighted UF. If I wanted to identify each component with
its root, then I believe I have to use Weighted Union Find. todo: See if you can print out the nodes in
each component */

    int s = 0;
    UF uf;
    int vertices;
    int edges;
    int[] id;
    int components;

    public SearchGraph(In in) {
        vertices = in.readInt();
        components=vertices;
        id = new int[vertices];
        edges = in.readInt();
        uf = new UF(edges);
        // after reading in number of vertices, and edges set the source variable to the very next input
        s = in.readInt();

        int v = s;
        id[v] = v;
        int w = in.readInt();
        id[w] = w;
        for (int i = 1; i < edges; i++) {
            // uf should update the ids
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                components--;
            }
            v = in.readInt();
            w = in.readInt();
            // set the ids as soon you read them in
            id[v] = v;
            id[w] = w;
        }
    }

    public boolean marked(int v) {
        return uf.connected(v, s);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // finish this code
        sb.append("The number of components according to uf.count(): "+uf.count());
        return sb.toString();
    }

    public int componentCount() {
        return components;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        SearchGraph searchGraph = new SearchGraph(in);
        StdOut.println("Is 0 connected to 0 ? " + searchGraph.marked(0));
        StdOut.println("Is 1 connected to 0 ? " + searchGraph.marked(1));
        StdOut.println("Is 2 connected to 0 ? " + searchGraph.marked(2));
        StdOut.println("Is 3 connected to 0 ? " + searchGraph.marked(3));
        StdOut.println("Is 4 connected to 0 ? " + searchGraph.marked(4));
        StdOut.println("Is 5 connected to 0 ? " + searchGraph.marked(5));
        StdOut.println("Is 6 connected to 0 ? " + searchGraph.marked(6));
        StdOut.println("Is 7 connected to 0 ? " + searchGraph.marked(7));
        StdOut.println("Is 8 connected to 0 ? " + searchGraph.marked(8));
        StdOut.println("Is 9 connected to 0 ? " + searchGraph.marked(9));
        StdOut.println("Is 10 connected to 0 ? " + searchGraph.marked(10));
        StdOut.println("Is 11 connected to 0 ? " + searchGraph.marked(11));
        StdOut.println("Is 12 connected to 0 ? " + searchGraph.marked(12));
        StdOut.println("There are " + searchGraph.componentCount() + " components in this graph");
        StdOut.println(searchGraph);
    }
}
