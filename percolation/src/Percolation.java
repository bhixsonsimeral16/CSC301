import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
	private boolean[][] openArray;
	private int dim;
	private WeightedQuickUnionUF uf;
	private int openSites;
	
	// create N-by-N grid, with all sites initially blocked
	// array elements will be id'd by number, 
	//but they will likely be referenced using mod of some kind
	public Percolation(int N) throws IllegalArgumentException{
		if (N <= 0){
			throw new IllegalArgumentException("cannot initialize a Percolation with an N of 0 or less");
		}
		this.openSites = 0;
		this.dim = N;
		this.openArray = new boolean[N][N];
		this.uf = new WeightedQuickUnionUF(N*N);
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				this.openArray[i][j] = false;
			}
		}
		
	}
	// open the site (row, col) if it is not open already
	public void open(int row, int col) throws IndexOutOfBoundsException{
		if(row < 0 || row > dim - 1 ){
			throw new IndexOutOfBoundsException("row value is out of bounds");
		}
		if(col < 0 || col > dim - 1 ){
			throw new IndexOutOfBoundsException("column value is out of bounds");
		}
		int p = (row * dim) + col; 
		if (openArray[row][col] == false){
			openArray[row][col] = true;
			this.openSites++;
			if( col != 0 && isOpen(row, col - 1)){
				uf.union(p, p-1);
			}
			if( col != dim-1 && isOpen(row, col + 1)){
				uf.union(p, p+1);
				
			}
			if( row != 0 && isOpen(row - 1, col)){
				uf.union(p, p - dim);
				
			}
			if( row != dim-1 && isOpen(row + 1, col)){
				uf.union(p, p + dim);
				
			}
		}
	}
	// is the site (row, col) open?
	public boolean isOpen(int row, int col) throws IndexOutOfBoundsException{
		if(row < 0 || row > dim - 1 ){
			throw new IndexOutOfBoundsException("row value is out of bounds");
		}
		if(col < 0 || col > dim - 1 ){
			throw new IndexOutOfBoundsException("column value is out of bounds");
		}
		return openArray[row][col];
	}
	// is the site (row, col) full?
	public boolean isFull(int row, int col) throws IndexOutOfBoundsException{
		if(row < 0 || row > dim - 1 ){
			throw new IndexOutOfBoundsException("row value is out of bounds");
		}
		if(col < 0 || col > dim - 1 ){
			throw new IndexOutOfBoundsException("column value is out of bounds");
		}
		int p = (dim * row) + col;
		if(isOpen(row, col)){
			for (int i = 0; i < dim; i++) {
				if (uf.connected(i, p)) {
					return true;
				}
			}
		}
		return false;
	}
	// number of open sites
	public int numberOfOpenSites(){
		return this.openSites;
	}
	// does the system percolate?
	public boolean percolates(){
		for(int i = 0; i < dim; i++){
			for(int j = 0; j < dim; j++){
				int p = (dim * (dim - 1)) + j;
				if(uf.connected(i, p)){
					return true;
				}
			}
		}
		return false;
	}
	// unit testing (required)
	public static void main(String[] args){
		Percolation p = new Percolation(5);
		p.open(1, 0);
//		p.open(0, 1);
//		p.open(1, 0);
//		p.open(2, 0);
//		p.open(3, 0);
//		p.open(4, 0);
//		p.open(4, 4);
//		p.open(1, 1);
//		p.open(1, 2);
		System.out.println("Connected? " + p.uf.connected(0, 0));
		System.out.println("percolates? " + p.percolates());
		System.out.println("is it full? " + p.isFull(0, 0));
//		System.out.println("0, 0 is open:" + p.isOpen(0, 0));
		
	}
}
