package autoCompleteMe;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Autocomplete {
	private final int N;
	private final Term[] autoComplete;
	
	// Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms){
    	this.N = terms.length;
    	this.autoComplete = new Term[N];
//    	MergeX.sort(terms, Term.byReverseWeightOrder());
    	MergeX.sort(terms);
    	for(int i = 0; i < N; i++){
    		this.autoComplete[i] = terms[i];
    	}
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix){
    	Term term = new Term(prefix, 0);
    	int first = BinarySearchDeluxe.firstIndexOf(this.autoComplete, term, Term.byPrefixOrder(prefix.length()));
    	int last = BinarySearchDeluxe.lastIndexOf(this.autoComplete, term, Term.byPrefixOrder(prefix.length()));
    	
    	Term[] terms = new Term[last - first + 1];
    	for(int i = 0; i < last-first+1; i++){
    		terms[i] = this.autoComplete[first+i];
    	}
    	MergeX.sort(terms, Term.byReverseWeightOrder());
    	return terms;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
    	Term term = new Term(prefix, 0);
    	int first = BinarySearchDeluxe.firstIndexOf(this.autoComplete, term, Term.byPrefixOrder(prefix.length()));
    	int last = BinarySearchDeluxe.lastIndexOf(this.autoComplete, term, Term.byPrefixOrder(prefix.length()));
    	return last-first + 1;
    }
    
    public static void main(String[] args) {
        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}
