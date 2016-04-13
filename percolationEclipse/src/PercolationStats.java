import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
	private int N;
	private int T;
	private Percolation p;
	private double[] percThresh;
	
	// perform T independent experiments on an N-by-N grid
	public PercolationStats(int N, int T) throws IllegalArgumentException{
		if(N <= 0 || T <= 0){
			throw new IllegalArgumentException("Neither N or T may be less than or equal to 0");
		}
		this.N = N;
		this.T = T;
		this.p = new Percolation(N);
		this.percThresh = new double[T];
		for(int i = 0; i < T; i++){
			while(true){
				//uniformly create a number between 0 and N*N - 1
				double open = StdRandom.uniform(N*N);
				//the row number is the whole number in the division
				int row = (int) Math.floor(open/N);
				//the column is the modulus of N
				int col = (int) open % N;
				
				if(!p.isOpen(row, col)){
					p.open(row, col);
				}
				if(p.percolates()){
					this.percThresh[i] = (p.numberOfOpenSites() / (double) (N * N));
					break;
				}
			}
		}
	}
	// sample mean of percolation threshold
	public double mean(){
		double mean = StdStats.mean(percThresh);
		return mean;
	}
	// sample standard deviation of percolation threshold
	public double stddev(){
		double stddev = StdStats.stddev(percThresh);
		return stddev;
	}
	// low  endpoint of 95% confidence interval
	public double confidenceLow(){
		double mean = mean();
		double temp = ((1.96 * stddev()) / Math.sqrt(T));
		double confidenceLow = mean - temp;
		return confidenceLow;
	}
	// high endpoint of 95% confidence interval
	public double confidenceHigh(){
		double mean = mean();
		double temp = ((1.96 * stddev()) / Math.sqrt(T));
		double confidenceHigh = mean + temp;
		return confidenceHigh;
	}
}
