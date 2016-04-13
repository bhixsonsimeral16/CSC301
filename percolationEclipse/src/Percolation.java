import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;



public class Percolation {
	private boolean[][] openArray;        //array of open positions
	private int dim;                      //dimension size of the grid
	private WeightedQuickUnionUF uf;      //union-find object
	private WeightedQuickUnionUF ufNoBot; //union-find object with no virtual bottom
	private int openSites;                //number of open sites
	private int top;                      //int representing the virtual top node
	private int bot;                      //int representing the virtual bottom node
	
	// create N-by-N grid, with all sites initially blocked
	public Percolation(int N) throws IllegalArgumentException{
		if (N <= 0){
			throw new IllegalArgumentException("cannot initialize a Percolation with an N of 0 or less");
		}
		this.openSites = 0;
		this.dim = N;
		this.openArray = new boolean[dim][dim];
		
		//dim*dim+2 will provide a virtual node for a common root between the top row
		//as well as a virtual node for the bottom and a node for each point in the Percolation
		this.uf = new WeightedQuickUnionUF((dim*dim)+2);
		this.ufNoBot = new WeightedQuickUnionUF((dim*dim)+1);
		
		this.top = dim*dim;
		this.bot = (dim*dim)+1;
		
		//connect the top row to the virtual node
		//connect the bottom row to the virtual node
		for(int i = 0; i < dim; i++){
			this.uf.union( i, top );
			this.ufNoBot.union( i, top );
			this.uf.union( (xyTo1D(dim - 1, 0)) + i, bot );
		}
	}
	
	// open the site (row, col) if it is not open already
	public void open(int row, int col) throws IndexOutOfBoundsException{
		if(!validateIndex(row, col)){
			throw new IndexOutOfBoundsException("index value is out of bounds");
		}
		int p = xyTo1D(row, col); 
		if (openArray[row][col] == false){
			openArray[row][col] = true;
			this.openSites++;
			
			//test to see if the position is on one of the sides of the grid
			//union with open positions accordingly
			if( col != 0 && isOpen(row, col - 1)){
				uf.union(p, p - 1);
				ufNoBot.union(p, p - 1);
			}
			if( col != dim-1 && isOpen(row, col + 1)){
				uf.union(p, p + 1);
				ufNoBot.union(p, p + 1);
			}
			if( row != 0 && isOpen(row - 1, col)){
				uf.union(p, p - dim);
				ufNoBot.union(p, p - dim);
				
			}
			if( row != dim-1 && isOpen(row + 1, col)){
				uf.union(p, p + dim);
				ufNoBot.union(p, p + dim);	
			}
		}
	}
	
	// is the site (row, col) open?
	public boolean isOpen(int row, int col) throws IndexOutOfBoundsException{
		if(!validateIndex(row, col)){
			throw new IndexOutOfBoundsException("index value is out of bounds");
		}
		return openArray[row][col];
	}
	
	// is the site (row, col) full?
	public boolean isFull(int row, int col) throws IndexOutOfBoundsException{
		if(!validateIndex(row, col)){
			throw new IndexOutOfBoundsException("index value is out of bounds");
		}
		int p = xyTo1D(row, col);
		//dim*dim is the virtual top node
		if(isOpen(row, col) && ufNoBot.connected(top, p)){
			return true;
		}
		return false;
	}
	
	// number of open sites
	public int numberOfOpenSites(){
		return this.openSites;
	}
	
	// does the system percolate?
	public boolean percolates(){
		if(uf.connected(top, bot)){
			return true;
		}
		return false;
	}
	
	//convert 2D array coords to 1D coord
	private int xyTo1D(int row, int col){
		int place = (dim * row) + col;
		return place;
	}
	
	//return true if the index is within bounds, false if not
	private boolean validateIndex(int row, int col){
		if(row < 0 || row > dim - 1 || col < 0 || col > dim - 1 ){
			return false;
		}
		return true;
	}
	
	
	
	// unit testing (required)
	public static void main(String[] args){
		int N = 200;
		int T = 100;
		Stopwatch timer  = new Stopwatch();
		PercolationStats p = new PercolationStats(N, T);
		double time = timer.elapsedTime();
		System.out.println("PercolationStats(" + N + ", " + T + ")");
		System.out.println("Mean: " + p.mean());
		System.out.println("Standard Deviation: " + p.stddev());
		System.out.println("Confidence Low: " + p.confidenceLow());
		System.out.println("Confidence High: " + p.confidenceHigh());
		System.out.println("Time elapseed: " + time);
		
//		Percolation p = new Percolation(5);
//		System.out.println(p.uf);
//		p.open(0, 1);
//		p.open(0, 0);
//		System.out.println(p.uf.find(0));
//		p.open(1, 0);
//		p.open(2, 0);
//		System.out.println(p.uf.find(0));
//		System.out.println(p.uf.find(1));
//		System.out.println(p.uf.find(5));
//		System.out.println(p.uf.find(10));
//		p.open(1, 0);
//		p.open(2, 0);
//		p.open(3, 0);
//		p.open(4, 0);
//		p.open(4, 4);
//		p.open(1, 1);
//		p.open(1, 2);
//		System.out.println("Connected? " + p.uf.connected(0, 0));
//		System.out.println("percolates? " + p.percolates());
//		System.out.println("is it full? " + p.isFull(0, 0));
//		System.out.println("0, 0 is open:" + p.isOpen(0, 0));
		
	}
}
