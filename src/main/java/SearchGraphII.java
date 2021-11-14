import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.io.File;

public class SearchGraphII {
    WeightedQuickUnionUF weightedQuickUnionUF;
    int s = 0;

    SearchGraphII(Graph graph, int s) {
        this.s = s;
        weightedQuickUnionUF = new WeightedQuickUnionUF(graph.V());
        for (int v = 0; v < graph.V(); v++) {
            for (int w : graph.adj(v)) weightedQuickUnionUF.union(v, w);
        }
    }

    public boolean marked(int v) {
        return weightedQuickUnionUF.connected(s, v);
    }

    public int count(int v) {
        return weightedQuickUnionUF.find(s);

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
        StdOut.println(searchGraphII.count(s));
    }
}
