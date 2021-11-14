import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
/*excer 4-2-7*/
public class Degrees {
    Digraph digraph;

    public Degrees(Digraph digraph) {
        this.digraph = digraph;
    }

    public int indegree(int v) {
        int count = 0;
        for (int i = 0; i < digraph.V(); i++) {
            for (int w : digraph.reverse().adj(i))
                if (w == v) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph digraph = new Digraph(in);
        Degrees degrees = new Degrees(digraph);
        StdOut.println(degrees.indegree(8));
    }
}
