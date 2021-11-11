import edu.princeton.cs.algs4.*;

public class Dag {
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph d = new Digraph(in);
        // StdOut.println("Here is tinyG.txt\n"+d);
        // StdOut.println("Here is the reverse: \n"+d.reverse());
        /* Here is how to see which nodes are reachable from vertice(s). You have to put the source in command line
        like src/main/resources/tinyG.txt 1 2 3  */
        Bag<Integer> sources = new Bag<>();
        for (int i = 1; i < args.length; i++) {
            sources.add(Integer.parseInt(args[i]));
        }
        DirectedDFS dD = new DirectedDFS(d, sources);
        StdOut.println("Here are all the sources: ");
        for (int j : sources) {
            StdOut.println(j);
        }
        StdOut.println("Here are the nodes reachable from the above sources: ");
        for (int i = 0; i < d.V(); i++) {
            if (dD.marked(i)) StdOut.println(i + " ");
        }
    }
}
