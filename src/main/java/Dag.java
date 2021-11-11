import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Dag {
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph d = new Digraph(in);
        StdOut.println("Here is tinyG.txt\n"+d);
        StdOut.println("Here is the reverse: \n"+d.reverse());
    }
}
