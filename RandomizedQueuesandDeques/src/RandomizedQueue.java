import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;


public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] resizableArr;
	private int items;
	
	// construct an empty randomized queue
	public RandomizedQueue() {
		this.resizableArr = (Item[]) new Object[2];
		this.items = 0;
	}

	// is the queue empty?
	public boolean isEmpty() {
		return (items <= 0);
	}

	// return the number of items on the queue
	public int size() {
		return items;
	}

	// add the item
	public void enqueue(Item item) throws NullPointerException {
		if (item == null){
			throw new NullPointerException("Can not add null to RandomizedQueue");
		}
		resizableArr[items] = item;
		items++;
		if(items == resizableArr.length){
			resize();
		}
		
	}

	// remove and return a random item
	public Item dequeue() throws NoSuchElementException {
		if(items == 0){
			throw new NoSuchElementException("No more items in RandomizedQueue");
		}
		// index to be removed
		int rand = StdRandom.uniform(items);
		Item item = resizableArr[rand];
		
		// This code makes it so that iterators will not work with dequeue()
		// move the last item to the place of the removed item and set the placement of the last item to null
		resizableArr[rand] = resizableArr[items - 1];
		resizableArr[items - 1] = null;
		
		// Following code has been commented because it is too slow
//		// delete the item from the array and move everything over one space
//		for(int i = rand; i < items; i++){
//			resizableArr[i] = resizableArr[i + 1];
//		}
		items--;
		
		// resize if necessary
		if(items > 0 && items <= resizableArr.length/4){
			resize();
		}
		return item;
	}

	// return a random item (but do not remove it)
	public Item sample() throws NoSuchElementException {
		if(items == 0){
			throw new NoSuchElementException("No more items in RandomizedQueue");
		}
		int rand = StdRandom.uniform(items);
		return resizableArr[rand];
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		ListIterator li = new ListIterator();
		
		// An array of indexes to be shuffled
		for (int i = 0; i < items; i++){
			li.shuffleArr[i] = i;
		}
		
		
		// Shuffle the array indexes which contain items
		// Fisher-Yates shuffle array function
		// modified code taken from: http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
		int index, temp;
		
		for (int i = li.shuffleArr.length - 1; i > 0; i--)
	    {
	        index = StdRandom.uniform(i + 1);
	        temp = li.shuffleArr[index];
	        li.shuffleArr[index] = li.shuffleArr[i];
	        li.shuffleArr[i] = temp;
	    }
		
		
		
		// Array of shuffled items, using the shuffled indexes
		for (int i = 0; i < li.shuffleArr.length; i++){
			li.shuffled[i] = resizableArr[li.shuffleArr[i]];
		}
		
		
		return li;
	}
	
	// Halves array length when number of used spaces is 1/4 the total length
	// Doubles array length when number of used spaces is equal to the total length
	private void resize(){
		if (items == resizableArr.length){
			Item[] newArr = (Item[]) new Object[resizableArr.length * 2];
			for( int i = 0; i < items; i++){
				newArr[i] = resizableArr[i];
			}
			resizableArr = newArr;
		}
		else if (items > 0 && items <= resizableArr.length/4){
			Item[] newArr = (Item[]) new Object[resizableArr.length / 2];
			for( int i = 0; i < items; i++){
				newArr[i] = resizableArr[i];
			}
			resizableArr = newArr;
		}
	}
	
	// Iterator class for the Deque class
	private class ListIterator implements Iterator<Item>{
		private int index = 0;
		int size = items;
		
		// this array is shuffled and provides the order that the Iterator 
		// will go through the resizableArray
		private int[] shuffleArr = new int[size];
		
		private Item[] shuffled = (Item[]) new Object[size];
		
		public boolean hasNext(){
			return (index < size);
		}
		
		public Item next() throws NoSuchElementException{
			if(!hasNext()){
				throw new NoSuchElementException("There are no more elements");
			}
			
			Item item = shuffled[index];
			index++;
			return item;
		}
		
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException("The remove() method is not supported");
		}
	}

	// unit testing (required)
	public static void main(String[] args) {
//		for(int N = 1; true; N = N*2){
			RandomizedQueue<Integer> r = new RandomizedQueue<Integer>();
			for(int i = 0; i < 10; i++){
				
				r.enqueue(i);
				//System.out.println(r.items + "   " + ((Object[])r.resizableArr).length );
			}
			
			for(Integer i : r){
				System.out.println(r.dequeue());
				
			}
//			Stopwatch timer = new Stopwatch();
//			for (int i = 0; i < 10; i++) {
//
//				r.dequeue();
//				//System.out.println(r.items + "   " + ((Object[])r.resizableArr).length );
//			}
			
//			System.out.println();
//			System.out.println("N = " + N);
//			System.out.println("Done in: " + timer.elapsedTime());
//		}
		
//		Iterator<Integer> i1 = r.iterator();
//		Iterator<Integer> i2 = r.iterator();
//		
//		while(i1.hasNext()){
//			Integer i = i1.next();
//			System.out.println(i);
//		}
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		while(i2.hasNext()){
//			Integer i = i2.next();
//			System.out.println(i);
//		}
//		for (int i = 0; i < 10; i++){
//			
//			System.out.println(r.dequeue());
//		}
//		for(int i = 0; i < 10; i++){
//			
//			r.enqueue(i);
//			//System.out.println(r.items );
//		}
//		System.out.println();
//		System.out.println(r.sample());
		
	}
}
