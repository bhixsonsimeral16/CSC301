import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;

public class PointST<Value> {
	private RedBlackBST<Point2D, Value> BST;
	private int size;
	
	// construct an empty symbol table of points
	public PointST() {
		BST = new RedBlackBST<Point2D, Value>();
		this.size = 0;
	}

	// is the symbol table empty?
	public boolean isEmpty() {
		return BST.isEmpty();
	}

	// number of points
	public int size() {
		return this.size;
	}

	// associate the value val with point p
	public void put(Point2D p, Value val) {
		BST.put(p, val);
		this.size++;
	}

	// value associated with point p
	public Value get(Point2D p) {
		return BST.get(p);
	}

	// does the symbol table contain point p?
	public boolean contains(Point2D p) {
		return BST.contains(p);
	}

	// all points in the symbol table
	public Iterable<Point2D> points() {
		return BST.keys();
	}

	// all points that are inside the rectangle
	public Iterable<Point2D> range(RectHV rect) {
		Queue<Point2D> q = new Queue<Point2D>();
		for(Point2D p : this.points()){
			if(rect.contains(p)){
				q.enqueue(p);
			}
		}
		return q;
	}

	// a nearest neighbor to point p; null if the symbol table is empty
	public Point2D nearest(Point2D p) {
		if(size == 0){
			return null;
		}

		Point2D minPoint = BST.max();
		for(Point2D po : this.points()){
			if (p.distanceSquaredTo(po) < p.distanceSquaredTo(minPoint)){
				minPoint = po;
			}
		}
		return minPoint;
	}

	// unit testing (required)
	public static void main(String[] args) {

	}
	   
}
