import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
	private int T;                 //number of times the test is run
	private double[] percThresh;   //array holding the Percolation threshold for each trial
	
	// perform T independent experiments on an N-by-N grid
	public PercolationStats(int N, int T) throws IllegalArgumentException{
		if(N <= 0 || T <= 0){
			throw new IllegalArgumentException("Neither N or T may be less than or equal to 0");
		}
		this.T = T;
		this.percThresh = new double[T];
		for(int i = 0; i < T; i++){
			Percolation p = new Percolation(N);
			while(true){
				//randomly select a number between 0 and N-1 for both row and column
				int row = (int) StdRandom.uniform(N);
				int col = (int) StdRandom.uniform(N);
				
				if(!p.isOpen(row, col)){
					p.open(row, col);
				}
				if(p.percolates()){
					//Percolation threshold is the percentage of open spaces when percolation occurs
					this.percThresh[i] = ((double) p.numberOfOpenSites() / (double) (N * N));
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
