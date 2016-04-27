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
		private int level;           // is the node on an odd level of the tree
		private Point2D p;           // Associated key
		private Value val;           // Associate value
		
		public KdNode(Point2D p, Value val){
			this.p = p;
			this.val = val;
			this.level = 0;
			this.leftChild = null;
			this.rightChild = null;
		}

		// if the level is odd, compare x values
		// if the level is even, compare y values
		public int compareTo(KdNode node) {
			if(node.p.x() == this.p.x() && node.p.y() == this.p.y()){
				return 0;
			}
			
			// if the level is odd we compare x coords
			if(node.level % 2 == 1){
				if(this.p.x() >= node.p.x()){
					return 1;
				}
				else {
					return -1;
				}
			}
			// if the level is even we compare y coords
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
		if (p == null) throw new NullPointerException("first argument to put() is null");
//        if (val == null) {
//            delete(p);
//            return;
//        }
		KdNode node = new KdNode(p, val);
        root = put(root, node);
        this.size++;
}
	
	private KdNode put(KdNode x, KdNode node){
		node.level++;
		
		//if no node here, then place the node here
		if( x == null){
			return node;
		}
		
		int cmp = node.compareTo(x);
		
		//move the node down the left or right subtree depending on compareTo()
		if(cmp > 0){
			x.leftChild = put(x.leftChild, node);
		}
		else if(cmp < 0){
			x.rightChild = put(x.rightChild, node);
		}
		else{
			x.val = node.val;
		}
		return x;

	}
	
	// value associated with point p
	public Value get(Point2D p) {
		return get(root, p);
	}
	
	private Value get(KdNode x, Point2D p){
		if(x == null){
			return null;
		}
		double cmp;
		
		// if the level is odd, compare x coords
		if(x.level % 2 == 1){
			cmp = p.x() - x.p.x();
		}
		// if the level is even, compare y coords
		else{
			cmp = p.y() - x.p.y();
		}
		
		// if p is greater than or equal to x.p then go right
		if (cmp <= 0){
			// if p is equal to x.p then return the value
			if(p.x() - x.p.x() == 0 && p.y() - x.p.y() == 0){
				return x.val;
			}
			return get(x.leftChild, p);
		}
		// if p is less than x.p then go left
		else {
			return get(x.leftChild, p);
		}
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