package puzzle;

public class Board {
	private final int[][] boardStart;
	private final int SIZE;
	private final int hamming;
	private final int manhattan;
	private int row0;
	private int col0;
	
	// construct a board from an N-by-N array of tiles
	// (where tiles[i][j] = tile at row i, column j)
	public Board(int[][] tiles) {
		this.boardStart = new int[tiles.length][tiles[0].length];
		this.SIZE = boardStart.length;
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles.length; j++){
				boardStart[i][j] = tiles[i][j];
				if(boardStart[i][j] == 0){
					this.row0 = i;
					this.col0 = j;
				}
			}
		}
		this.hamming = hamming();
		this.manhattan = manhattan();
	}

	// return tile at row i, column j (or 0 if blank)
	public int tileAt(int i, int j) {
		return boardStart[i][j];
	}

	// board size N
	public int size() {
		return SIZE;
	}

	// number of tiles out of place
	public int hamming() {
		int hamming = 0;
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				if(!(i == SIZE -1 && j == SIZE -1)){
//					System.out.println(boardStart[i][j]);
					if(boardStart[i][j] != 1 + (SIZE * i) + j){
//						System.out.println(boardStart[i][j]);
						hamming++;
					}
				}
			}
		}
		return hamming;
	}

	// sum of Manhattan distances between tiles and goal
	public int manhattan() {
		int manhattan = 0;
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				if(boardStart[i][j] != 0){
					
					//subtract one to make the value line up with the int[][] better
					int num = boardStart[i][j] - 1;
					
					//calculate target row and column
					int col = num % SIZE;
					int row = (int) Math.floor(num / SIZE);
					
					int colDiff = Math.abs(col - j);
					int rowDiff = Math.abs(row - i);
					
					manhattan += (colDiff + rowDiff);
				}
			}
		}
		return manhattan;
	}

	// is this board the goal board?
	public boolean isGoal() {
		return hamming == 0;
	}

	// is this board solvable?
	public boolean isSolvable() {
		if(isGoal()) return true;
		
		int inversions = 0;
		int[] arr = new int[SIZE * SIZE -1];
		
		// create 2d array to make checks easier
		int count = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(boardStart[i][j] != 0){
					arr[count] = boardStart[i][j];
					count++;
				}
			}
		}
		
		// check for any smaller number appearing afterwards in the array
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					inversions++;
				}
			}
		}
		// if odd
		if (SIZE % 2 == 1) {
			return (inversions % 2 == 0);
		}

		// if even
		else {
			int sum = inversions;
			sum += row0;
			return (sum % 2 == 0);
		}
	}

	// does this board equal y?
	public boolean equals(Object y) {
		if (y.getClass() == this.getClass()) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (this.boardStart[i][j] != ((Board) y).boardStart[i][j]) {
						return false;
					}
				}
			}
			return true;
		}
		else return false;
	}

	// all neighboring boards
	public Iterable<Board> neighbors() {
	}

	// string representation of this board (in the output format specified below)
	public String toString() {
		StringBuilder s = new StringBuilder();
	    s.append(SIZE + "\n");
	    for (int i = 0; i < SIZE; i++) {
	        for (int j = 0; j < SIZE; j++) {
	            s.append(String.format("%2d ", tileAt(i, j)));
	        }
	        s.append("\n");
	    }
	    return s.toString();
	}

	// unit testing (required)
	public static void main(String[] args) {
		int[][] testArr = {{1,2,3},{7,8,0},{4,5,6}};
		int[][] testArr2 = {{2,1,3},{7,8,0},{4,5,6}};
		int[][] testArr3 = {{1,2,3},{0,7,6},{5,4,8}};
		
		Board b = new Board(testArr);
		Board c = new Board(testArr2);
		Board d = new Board(testArr3);
		
		
		System.out.println(d.toString());
//		System.out.println(b.manhattan + "  " + b.hamming);
//		System.out.println(c.manhattan + "  " + c.hamming);
		System.out.println(d.manhattan + "  " + d.hamming);
		System.out.println(d.isSolvable());
		
	}
}
