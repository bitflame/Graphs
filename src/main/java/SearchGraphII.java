import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


import java.io.File;

public class SearchGraphII {
    WeightedQuickUnionFind weightedQuickUnionUF;
    int s = 0;
/* count() returns the size of each component not the entire tree. This only works with the extended WeightedQuickFind
* that is in this project extended as follows Implementing count() requires using a weighted UF implementation and extending
its API to use a count() method that returns wt[find(v)]  */
    SearchGraphII(Graph graph, int s) {
        this.s = s;
        weightedQuickUnionUF = new WeightedQuickUnionFind(graph.V());
        for (int v = 0; v < graph.V(); v++) {
            for (int w : graph.adj(v)) {
                weightedQuickUnionUF.union(v,w);
            }
        }
    }

    public boolean marked(int v) {
        return weightedQuickUnionUF.connected(s, v);
    }

    public int count(int v) {
        return weightedQuickUnionUF.extdCount(v);

    }

    public static void main(String[] args) {
        File file = new File(args[0]);
        String fileName = file.getName();
        In in = new In(args[0]);
        Graph graph = new Graph(in);
        // source vertex number
        int s = Integer.parseInt(args[1]);
        SearchGraphII searchGraphII = new SearchGraphII(graph, 0);
        StdOut.println("For file " + fileName + " " + s + " is reachable from the source 0: " + searchGraphII.marked(s));
        StdOut.println("expecting 4, getting: "+searchGraphII.count(12));
        StdOut.println("expecting 7, getting: "+searchGraphII.count(2));
        StdOut.println("expecting 2, getting: "+searchGraphII.count(8));
    }
}
