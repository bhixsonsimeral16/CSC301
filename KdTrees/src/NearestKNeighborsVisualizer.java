
/******************************************************************************
 *  Compilation:  javac NearestKNeighbosrVisualizer.java
 *  Execution:    java NearestKNeighborsVisualizer
 *  Dependencies: PointST.java KdTreeST.java
 *
 *  Read points from a file (specified as a command-line argument) and
 *  draw to standard draw. Highlight the closest point to the mouse.
 *
 *  The nearest neighbor according to the brute-force algorithm is drawn
 *  in red; the nearest neighbor using the kd-tree algorithm is drawn in blue.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

public class NearestKNeighborsVisualizer {

    public static void main(String[] args) {
        
        ///INPUTS//////
        String filename = "input10k.txt"; //text file
        int K = 1000;                          //number of elements
        ///////////////
        
        
        In in = new In(filename);
        StdDraw.show(0);
        // initialize the two data structures with point from standard input
        KdTreeST<Integer> kdtree = new KdTreeST<Integer>();
        for (int i = 0; !in.isEmpty(); i++) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.put(p, i);
        }
        while (true) {
            // the location (x, y) of the mouse
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            Point2D query = new Point2D(x, y);
            // draw all of the points
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(.01);
            for (Point2D p : kdtree.points())
                p.draw();
            // draw in blue the nearest neighbor according to the kd-tree algorithm
            StdDraw.setPenColor(StdDraw.BLUE);
            for (Point2D p : kdtree.nearest(query,K))
                p.draw();
            StdDraw.show(0);
            StdDraw.show(40);
        }
    }
}
