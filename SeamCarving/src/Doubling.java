import edu.princeton.cs.algs4.Picture;
import edu.princeton.cs.algs4.Stopwatch;

public class Doubling {
	public static void main(String[] args) {
		int width = 256;
    	int height = 256;
    	Picture picture = SCUtility.randomPicture(width, height);

		SeamCarver sc = new SeamCarver(picture);

		Stopwatch sw = new Stopwatch();

		int[] horizontalSeam = sc.findHorizontalSeam();
		sc.removeHorizontalSeam(horizontalSeam);

		double prevRow = sw.elapsedTime();
		
		Stopwatch sw2 = new Stopwatch();

		int[] verticalSeam = sc.findVerticalSeam();
		sc.removeVerticalSeam(verticalSeam);

		double prevCol = sw2.elapsedTime();
		
		
		for (width = 512; true; width *= 2) {
			System.out.println("Width: " + width + " Height: " + height);
			picture = SCUtility.randomPicture(width, height);

			sc = new SeamCarver(picture);

			sw = new Stopwatch();

			horizontalSeam = sc.findHorizontalSeam();
			sc.removeHorizontalSeam(horizontalSeam);
			double temp = sw.elapsedTime();
			System.out.println("Row ratio: " + sw.elapsedTime()/prevRow);
			prevRow = temp;
			
			sw2 = new Stopwatch();

			verticalSeam = sc.findVerticalSeam();
			sc.removeVerticalSeam(verticalSeam);
			temp = sw2.elapsedTime();
			System.out.println("Column ratio: " + sw2.elapsedTime()/prevCol);
			System.out.println();
			prevCol = temp;
		}
	}
}
