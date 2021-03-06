import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int size;
	
	// construct an empty deque
	public Deque() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	// is the deque empty?
	public boolean isEmpty() {
		return (this.size == 0);
	}

	// return the number of items on the deque
	public int size() {
		return this.size;
	}

	// add the item to the front
	public void addFirst(Item item) throws NullPointerException {
		if(item == null){
			throw new NullPointerException("Can not add a null Item");
		}
		Node n = new Node(item, first, null);
		size++;
		
		//if the Deque has nodes
		if(first != null){
			first.prev = n;
			n.next = first;
		}
		
		//set first and last to the same point when there is only one node
		first = n;
		if(size == 1){
			last = n;
		}
	}

	// add the item to the end
	public void addLast(Item item) throws NullPointerException {
		if(item == null){
			throw new NullPointerException("Can not add a null Item");
		}
		Node n = new Node(item, null, last);
		size++;
		
		//if the Deque has nodes
		if(last != null){
			last.next = n;
			n.prev = last;
		}
		last = n;
		
		//set first and last to the same point when there is only one node
		if(size == 1){
			first = n;
		}
	}

	// remove and return the item from the front
	public Item removeFirst() throws NoSuchElementException {
		if(first == null){
			throw new NoSuchElementException("The Deque is empty");
		}
		Item removeItem = first.item;
		if(size == 1){
			first = null;
			last = null;
		}
		else{
			first = first.next;
			first.prev = null;
		}
		size--;
		return removeItem;
	}

	// remove and return the item from the end
	public Item removeLast() throws NoSuchElementException {
		if(last == null){
			throw new NoSuchElementException("The Deque is empty");
		}
		Item removeItem = last.item;
		if(size == 1){
			first = null;
			last = null;
		}
		else{
			last = last.prev;
			last.next = null;
		}
		size--;
		return removeItem;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	//Node object used to store the links between Items
	private class Node{
		private Item item;
		private Node next;
		private Node prev;
		
		public Node(Item item, Node next, Node prev){
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
	
	// the iterator object for Deque
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		
		public boolean hasNext(){
			return current != null;
		}
		
		public Item next() throws NoSuchElementException{
			if(!hasNext()){
				throw new NoSuchElementException("There are no more elements");
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException("The remove() method is not supported");
		}
	}

	// unit testing (required)
	public static void main(String[] args) {
		Deque<Integer> d = new Deque<Integer>();
		for(int i = 0; i < 10; i++){
			d.addLast(i);
//			System.out.println(d.first.item);
		}
		
	}
}
