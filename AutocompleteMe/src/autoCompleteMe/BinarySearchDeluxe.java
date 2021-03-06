package autoCompleteMe;
import java.util.Comparator;


public class BinarySearchDeluxe {
	// Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	int lo = 0;
    	int hi = a.length - 1;
    	int leftMostIndex = -1;
    	
    	// key is within [lo..hi] or not present
    	while(lo <= hi){
    		
    		// array midpoint
    		int mid = lo + (hi - lo) / 2;
    		
    		// if the key is less than or equal to the mid then the new mid is on the left
    		// if the key is equal to the mid then set the leftMostIndex to that index
    		if(comparator.compare(key, a[mid]) <= 0){
    			if(comparator.compare(key, a[mid]) == 0){
    				leftMostIndex = mid;
//    				System.out.println("LMI " + leftMostIndex);
    			}
    			hi = mid - 1;
    		}
    		
    		// if the key is greater than the mid then the new mid is on the right
    		else if(comparator.compare(key, a[mid]) > 0){
    			lo = mid + 1;
    		}
    	}
    	return leftMostIndex;
    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	int lo = 0;
    	int hi = a.length - 1;
    	int rightMostIndex = -1;
    	
    	// key is within [lo..hi] or not present
    	while(lo <= hi){
    		int mid = lo + (hi - lo) / 2;
    		
    		// if the key is greater than or equal to the mid then the new mid is on the right
    		// if the key is equal to the mid then set the rightMostIndex to that index
    		if(comparator.compare(key, a[mid]) >= 0){
    			if(comparator.compare(key, a[mid]) == 0){
    				rightMostIndex = mid;
//    				System.out.println("RMI " + rightMostIndex);
    			}
    			lo = mid + 1;
    		}
    		
    		// if the key is less than the mid then the new mid is on the left
    		else if(comparator.compare(key, a[mid]) < 0){
    			hi = mid - 1;
    		}
    	}
    	return rightMostIndex;
    }

    // unit testing (required)
    public static void main(String[] args){
    	Term a = new Term("And", 1);
    	Term b = new Term("And", 1);
    	Term c = new Term("And", 1);
    	Term d = new Term("And", 1);
    	Term e = new Term("Carl", 5);
    	Term f = new Term("And", 1);
    	Term g = new Term("And", 1);
    	Term h = new Term("And", 1);
    	Term i = new Term("An", 1);
    	Term j = new Term("An", 1);
    	Term k = new Term("Andy", 1);
    	Term l = new Term("Andy", 1);
    	Term[] t = {i, j, a, b, c, d, f, g, h, k, l, e};
    	
    	System.out.println(lastIndexOf(t, c, Term.byPrefixOrder(3)));
    }
}
