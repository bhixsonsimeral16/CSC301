
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Stopwatch;

/**
 *
 * @author nticknor19
 */
public class ReadMeTester {
    public static void main(String[] args) {
        
        String[] fargs = {"input100k","input1M"}; //all input files to check
        int secs=5; //accuracy vs time to complete
        int numK = 1;
        
        for(String file : fargs)
        {
            String filename = file+".txt";
            In in = new In(filename);
            PointST<Integer> brute = new PointST<>();
            KdTreeST<Integer> kdtree = new KdTreeST<>();
            System.out.println("Reading "+filename+"...");
            for (int i = 0; !in.isEmpty(); i++) {
                double x = in.readDouble();
                double y = in.readDouble();
                Point2D p = new Point2D(x, y);
                kdtree.put(p, i);
                brute.put(p, i);
            }
            System.out.println("Complete.\nStarting tests...\n-----------------------");
            Stopwatch sw = new Stopwatch();
            int times = 0;
            while(sw.elapsedTime()<secs)
            {
                kdtree.nearest(new Point2D(Math.random(),Math.random()));
                times++;
            }
            System.out.println("KdTree("+file+"): "+(times/secs));
            sw = new Stopwatch();
            times = 0;
            while(sw.elapsedTime()<secs)
            {
                kdtree.nearest(new Point2D(Math.random(),Math.random()),numK);
                times++;
            }
            System.out.println("KdTree-K("+numK+")("+file+"): "+(times/secs));
            sw = new Stopwatch();
            times = 0;
            while(sw.elapsedTime()<secs)
            {
                brute.nearest(new Point2D(Math.random(),Math.random()));
                times++;
            }
            System.out.println("Brute("+file+"): "+(times/secs));
            System.out.println("-----------------------------------");
        }
    }
}
