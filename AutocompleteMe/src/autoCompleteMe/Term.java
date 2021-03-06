package autoCompleteMe;
import java.util.Comparator;


public class Term implements Comparable<Term> {
	private final String query;
	private final long weight;
	
	// Initializes a term with the given query string and weight.
    public Term(String query, long weight) throws NullPointerException, IllegalArgumentException{
    	if(query == null){
    		throw new NullPointerException("query can not be null");
    	}
    	if(weight < 0){
    		throw new IllegalArgumentException("weight can not be negative");
    	}
    	this.query = query;
    	this.weight = weight;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
		return new ByReverseWeightOrder();
    	
    }
    
    // Comparator that sorts by reverse weight
    private static class ByReverseWeightOrder implements Comparator<Term>{
    	public int compare(Term t, Term v){
    		long reverseWeight = -(t.weight-v.weight);
    		if(reverseWeight > 0){
    			return 1;
    		}
    		else if(reverseWeight < 0){
    			return -1;
    		}
    		else{
    			return 0;
    		}
    	}
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) throws IllegalArgumentException{
    	if(r < 0){
    		throw new IllegalArgumentException("prefix length can not be negative");
    	}
    	ByPrefixOrder c = new ByPrefixOrder();
    	c.prefixLength = r;
    	return c;
    	
    }
    
    // Comparator that sorts by prefix
    private static class ByPrefixOrder implements Comparator<Term>{
    	private int prefixLength;
    	public int compare(Term t, Term v){
    		
    		// Create a substring of the minimum length between prefixLength and the string length 
    		String tShort = t.query.substring(0, Math.min(t.query.length(), prefixLength));
    		String vShort = v.query.substring(0, Math.min(v.query.length(), prefixLength));
    		
    		return tShort.compareTo(vShort);
    	}
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that){
    	return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString(){
    	return (weight + "	" + query);
    }

    // unit testing (required)
    public static void main(String[] args) {
    	Term t =  new Term("That", 5);
    	Term v = new Term("This", 4);
    	System.out.println(Term.byReverseWeightOrder().compare(v, t));
    	System.out.println(Term.byPrefixOrder(3).compare(v, t));
    	System.out.println(t.compareTo(v));
    }
}
