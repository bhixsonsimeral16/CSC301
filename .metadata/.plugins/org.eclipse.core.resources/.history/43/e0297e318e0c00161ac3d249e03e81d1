import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTreeST<Value> {
	private int size;
	private KdNode root;
	
	// construct an empty symbol table of points
	public KdTreeST() {
		this.size = 0;
		this.root = null;
	}
	
	private class KdNode implements Comparable<KdNode>{
		private KdNode leftChild;    // left subtree
		private KdNode rightChild;   // right subtree
		private boolean oddLevel;    // is the node on an odd level of the tree
		private Point2D p;           // Associated key
		private Value val;           // Associate value
		
		public KdNode(Point2D p, Value val){
			this.p = p;
			this.val = val;
			this.oddLevel = false;
			this.leftChild = null;
			this.rightChild = null;
		}

		// if the level is odd, compare x values
		// if the level is even, compare y values
		public int compareTo(KdNode node) {
			if(node.oddLevel){
				if(this.p.x() >= node.p.x()){
					return 1;
				}
				else {
					return -1;
				}
			}
			
			else{
				if(this.p.y() >= node.p.y()){
					return 1;
				}
				else {
					return -1;
				}
			}
		}
	}

	// is the symbol table empty?
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	// number of points
	public int size() {
		return this.size;
	}
	
	// associate the value val with point p
	public void put(Point2D p, Value val) {
		KdNode node = new KdNode(p);
		if(size == 0){
			this.root = node;
		}
		else{
			
		}
		
		this.size++;
	}
	
	// value associated with point p
	public Value get(Point2D p) {
		
	}
	
	// does the symbol table contain point p?
	public boolean contains(Point2D p) {
		
	}
	
	// all points in the symbol table
	public Iterable<Point2D> points() {
		
	}
	
	// all points that are inside the rectangle
	public Iterable<Point2D> range(RectHV rect) {
		
	}
	
	// a nearest neighbor to point p; null if the symbol table is empty
	public Point2D nearest(Point2D p) {
		
	}
	
	// unit testing (required)
	public static void main(String[] args) {

	}
}
