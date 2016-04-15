import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
	private LinkedList<Item> deque;
	
	// construct an empty deque
	public Deque() {
		this.deque = new LinkedList<Item>();
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
		deque.addFirst(item);
		this.size++;
	}

	// add the item to the end
	public void addLast(Item item) throws NullPointerException {
		if(item == null){
			throw new NullPointerException("Can not add a null Item");
		}
		deque.addLast(item);
		this.size++;
	}

	// remove and return the item from the front
	public Item removeFirst() throws NoSuchElementException {
		if(deque.first == null){
			throw new NoSuchElementException("The Deque is empty")
		}
		this.size--;
		return deque.remove();
	}

	// remove and return the item from the end
	public Item removeLast() throws NoSuchElementException {
		if(deque.last == null){
			throw new NoSuchElementException("The Deque is empty")
		}
		this.size--;
		return deque.remove(size-1);
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class LinkedList<Item>{
		private Node first;
		private Node last;
		private Node oldLast;
		private int size;
		
		private class Node{
			private Item item;
			private Node next;
			
			public Node(Item item, Node next){
				this.item = item;
				this.next = next;
			}
			public Item getItem() {
				return item;
			}
			public void setItem(Item item) {
				this.item = item;
			}
			public Node getNext() {
				return next;
			}
			public void setNext(Node next) {
				this.next = next;
			}
			
		}
		
		public LinkedList(){
			size = 0;
		}
		
		public void addFirst(Item item){
			Node n = new Node(item, first);
			size++;
			first = n;
			if(size == 1){
				last = n;
			}
			if(size == 2){
				oldLast = n;
			}
		}
		
		public void addLast(Item item){
			Node n = new Node(item, null);
			size++;
			last.next = n;
			oldLast = last;
			last = n;
			if(size == 1){
				first = n;
			}
		}
		
		public Item removeFirst(){
			Item removeItem = first.item;
			first.next = first;
			return removeItem;
		}
		
		public Item removeLast(){
			Item removeItem = last.item;
			oldLast = last;
			last.next = null;
			return removeItem;
		}
		
		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public Node getFirst() {
			return first;
		}

		public Node getLast() {
			return last;
		}

	}
	
	// the iterator object for Deque
	private class ListIterator implements Iterator<Item>{
		private int index = 0;
		private Item current = deque.get(index);
		
		public boolean hasNext(){
			return current != null;
		}
		
		public Item next() throws NoSuchElementException{
			if(!hasNext){
				throw new NoSuchElementException("There are no more elements");
			}
			Item item = current;
			index++;
			current = deque.get(index);
			return item;
		}
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException("The remove() method is not supported")
		}
	}

	// unit testing (required)
	public static void main(String[] args) {

	}
}
