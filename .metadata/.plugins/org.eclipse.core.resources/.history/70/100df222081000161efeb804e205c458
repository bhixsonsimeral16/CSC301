import java.awt.Color;

import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.Stack;

public class SeamCarver {
	private Picture pic;
	private Color[][] colorArr;
	private double[][] energyArr;
	private int width;
	private int height;
	
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		Picture temp = new Picture(picture);
		this.pic = temp;
		this.height = this.pic.height();
		this.width = this.pic.width();
		this.colorArr = new Color[this.width][this.height];
		this.energyArr = new double[this.width][this.height];
		
		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				this.colorArr[i][j] = this.pic.get(i, j);
			}
		}
		System.out.println("Finished the color array");
		
		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				this.energyArr[i][j] = energy(i, j);
			}
		}
		
		System.out.println("Finished the energy array");
		
	}
	
	// Index class used to store x and y coords together
	private class Index{
		private int row;
		private int col;
		
		public Index(int col, int row){
			this.row = row;
			this.col = col;
		}
		
		public int getRow(){
			return this.row;
		}
		
		public int getCol(){
			return this.col;
		}
	}
	
	//current picture
	public Picture picture() {
		return this.pic;
	}
	
	// width of the current picture
	public int width() {
		return this.width;
	}
	
	// height of the current picture
	public int height() {
		return this.height;
	}
	
	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		Color xNeighbor1;
		Color xNeighbor2;
		Color yNeighbor1;
		Color yNeighbor2;
		
		// If on the leftmost side, take the rightmost pixel
		if(x == 0) {
			xNeighbor1 = this.colorArr[width - 1][y];
		}
		else {
			xNeighbor1 = this.colorArr[x - 1][y];
		}
		
		// If on the rightmost side, take the leftmost pixel
		if(x == this.width-1) {
			xNeighbor2 = this.colorArr[0][y];
		}
		else {
			xNeighbor2 = this.colorArr[x + 1][y];
		}
		
		// If on the top, take the bottom pixel
		if(y == 0) {
			yNeighbor1 = this.colorArr[x][height - 1];
		}
		else {
			yNeighbor1 = this.colorArr[x][y - 1];
		}
		
		// If on the bottom, take the top pixel
		if(y == this.height-1) {
			yNeighbor2 = this.colorArr[x][0];
		}
		else {
			yNeighbor2 = this.colorArr[x][y + 1];
		}
		
		// Calculate the differences between colors in the x pixels
		int xRDiff = xNeighbor1.getRed() - xNeighbor2.getRed();
		int xBDiff = xNeighbor1.getBlue() - xNeighbor2.getBlue();
		int xGDiff = xNeighbor1.getGreen() - xNeighbor2.getGreen();
		
		// Calculate the differences between colors in the y pixels
		int yRDiff = yNeighbor1.getRed() - yNeighbor2.getRed();
		int yBDiff = yNeighbor1.getBlue() - yNeighbor2.getBlue();
		int yGDiff = yNeighbor1.getGreen() - yNeighbor2.getGreen();
		
		// Add the squares of the differences together
		double xSquare = Math.pow(xRDiff, 2) + Math.pow(xBDiff, 2) + Math.pow(xGDiff, 2);
		double ySquare = Math.pow(yRDiff, 2) + Math.pow(yBDiff, 2) + Math.pow(yGDiff, 2);
		
		// Take the sqrt of the sum of the squares
		double sumRoot = Math.sqrt(xSquare + ySquare);
		
		return sumRoot;
	}
	
	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		double[][] hDistTo = new double[this.width][this.height];
		Index[][] hEdgeTo = new Index[this.width][this.height];
		
		int[] horizontalSeam = new int[this.width];
		double minimumEnergy = Double.MAX_VALUE;
		Index minIndex = null;
		
		Stack<Index> s = new Stack<Index>();
		Index nextIndex;
		
		for(int i = 1; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				hDistTo[i][j] = Double.MAX_VALUE;
			}
		}
		
		for(int i = 0; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				
				// If this is the leftmost column then initialize the edge to null and the dist to their energy value
				if(i == 0) {
					hEdgeTo[i][j] = null;
					hDistTo[i][j] = this.energyArr[i][j];
				}
				
				// If the pixel is not in the rightmost column check the distance to the pixels in the next column
				if (i != this.width - 1) {
					
					// If the pixel is not on the top of the picture
					if (j != 0) {

						// If the distance from the current point to the next
						// point is less than the minimum distance
						// Save the distance and index
						if (hDistTo[i][j] + this.energyArr[i + 1][j - 1] < hDistTo[i + 1][j - 1]) {
							hDistTo[i + 1][j - 1] = hDistTo[i][j] + this.energyArr[i + 1][j - 1];
							hEdgeTo[i + 1][j - 1] = new Index(i, j);
						}
					}

					// If the pixel is not on the bottom of the picture
					if (j != this.height - 1) {
						
						// If the distance from the current point to the next
						// point is less than the minimum distance
						// Save the distance and index
						if (hDistTo[i][j] + this.energyArr[i + 1][j + 1] < hDistTo[i + 1][j + 1]) {
							hDistTo[i + 1][j + 1] = hDistTo[i][j] + this.energyArr[i + 1][j + 1];
							hEdgeTo[i + 1][j + 1] = new Index(i, j);
						}
					}

					// If the distance from the current point to the next point
					// is less than the minimum distance
					// Save the distance and index
					if (hDistTo[i][j] + this.energyArr[i + 1][j] < hDistTo[i + 1][j]) {
						hDistTo[i + 1][j] = hDistTo[i][j] + this.energyArr[i + 1][j];
						hEdgeTo[i + 1][j] = new Index(i, j);
					}
				}

				// If the pixel is in the rightmost column, check for the minimum distance
				else{
					if(hDistTo[i][j] < minimumEnergy){
						minimumEnergy = hDistTo[i][j];
						minIndex = new Index(i, j);
					}
				}
			}
		}
		
		// Add each index in the shortest path to a Stack
		s.push(minIndex);
		nextIndex = hEdgeTo[minIndex.getCol()][minIndex.getRow()];
		while(nextIndex != null) {
			s.push(nextIndex);
			nextIndex = hEdgeTo[nextIndex.getCol()][nextIndex.getRow()];
		}
		
		// Pop the index from the stack and add its row to the int[]
		int count = 0;
		while(!s.isEmpty()) {
			horizontalSeam[count] = s.pop().getRow();
			count++;
		}
		
		return horizontalSeam;
	}
	
	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		double[][] vDistTo = new double[this.width][this.height];
		Index[][] vEdgeTo = new Index[this.width][this.height];
		
		int[] verticalSeam = new int[this.height];
		double minimumEnergy = Double.MAX_VALUE;
		Index minIndex = null;
		
		Stack<Index> s = new Stack<Index>();
		Index nextIndex;
		
		for(int i = 1; i < this.width; i++) {
			for(int j = 0; j < this.height; j++) {
				vDistTo[i][j] = Double.MAX_VALUE;
			}
		}
		
		for(int j = 0; j < this.height; j++) {
			for(int i = 0; i < this.width; i++) {
				
				// If this is the top row then initialize the edge to null and the dist to their energy value
				if(j == 0) {
					vEdgeTo[i][j] = null;
					vDistTo[i][j] = this.energyArr[i][j];
				}
				
				// If the pixel is not in the bottom row check the distance to the pixels in the next column
				if (j != this.height - 1) {
					
					// If the pixel is not on the leftmost column of the picture
					if (i != 0) {

						// If the distance from the current point to the next
						// point is less than the minimum distance
						// Save the distance and index
						if (vDistTo[i][j] + this.energyArr[i - 1][j + 1] < vDistTo[i - 1][j + 1]) {
							vDistTo[i - 1][j + 1] = vDistTo[i][j] + this.energyArr[i - 1][j + 1];
							vEdgeTo[i - 1][j + 1] = new Index(i, j);
						}
					}

					// If the pixel is not on the rightmost column of the picture
					if (i != this.width - 1) {
						
						// If the distance from the current point to the next
						// point is less than the minimum distance
						// Save the distance and index
						if (vDistTo[i][j] + this.energyArr[i + 1][j + 1] < vDistTo[i + 1][j + 1]) {
							vDistTo[i + 1][j + 1] = vDistTo[i][j] + this.energyArr[i + 1][j + 1];
							vEdgeTo[i + 1][j + 1] = new Index(i, j);
						}
					}

					// If the distance from the current point to the next point
					// is less than the minimum distance
					// Save the distance and index
					if (vDistTo[i][j] + this.energyArr[i][j + 1] < vDistTo[i][j + 1]) {
						vDistTo[i][j + 1] = vDistTo[i][j] + this.energyArr[i][j + 1];
						vEdgeTo[i][j + 1] = new Index(i, j);
					}
				}

				// If the pixel is on the bottom, check for the minimum distance
				else{
					if(vDistTo[i][j] < minimumEnergy){
						minimumEnergy = vDistTo[i][j];
						minIndex = new Index(i, j);
					}
				}
			}
		}
		
		// Add each index in the shortest path to a Stack
		s.push(minIndex);
		nextIndex = vEdgeTo[minIndex.getCol()][minIndex.getRow()];
		while(nextIndex != null) {
			s.push(nextIndex);
			nextIndex = vEdgeTo[nextIndex.getCol()][nextIndex.getRow()];
		}
		
		// Pop the index from the stack and add its column to the int[]
		int count = 0;
		while(!s.isEmpty()) {
			verticalSeam[count] = s.pop().getCol();
			count++;
		}
		
		return verticalSeam;
	}
	
	// remove horizontal seam from the current picture
	public void removeHorizontalSeam(int[] seam) {
		
	}
	
	// remove vertical seam from the current picture
	public void removeVerticalSeam(int[] seam) {
			
	}
	
	// do unit testing of this class
	public static void main(String[] args) {
		
	}
}
