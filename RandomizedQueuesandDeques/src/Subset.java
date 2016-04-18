import edu.princeton.cs.algs4.StdIn;


public class Subset {
	public static void main(String[] args){
		int print = Integer.parseInt(args[0]);
		RandomizedQueue rq = new RandomizedQueue();
		
		while(!StdIn.isEmpty()){
			rq.enqueue(StdIn.readString());
		}
		for(int i = 0; i < print; i++){
			System.out.println(rq.dequeue());
		}
	}
}
