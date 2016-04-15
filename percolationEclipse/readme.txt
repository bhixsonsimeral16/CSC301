/******************************************************************************
 *  Name: Brian Hixson-Simeral
 *
 *  Operating system: Windows 10
 *  Compiler:
 *  Text editor / IDE: Sublime 2 & gedit/Eclipse
 *  Hours to complete assignment (optional): 8.5 hours
 ******************************************************************************/


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/
Percolation() initializes the number of open sites at 0, saves the dimensions of 
the grid, creates a boolean[][] that is initialzed to false in all spaces, and 
also creates two WeightedQuickUnionUF, one that is connected to a top and bottom
virtual node and one that is only connected to the top. This second UF is used to 
handle backwash, as the bottom row is never connected to a virtual node. This 
means that when one bottom node is full, it will not make the others full without 
a direct connection through real nodes. open() will check to see if the position 
is closed, if it is then it will open it.  Afterwards, it checks the positions 
adjacent to the newly opened spot and does a union() with that position if it is 
open.  This step is completed for both WeightedQuickUnionUF objects.  isOpen() 
returns the value of the boolean[][] at the position of the arguments.  isFull() 
returns true if the position in question is both open and connected to the virtual 
top node in the WeightedQuickUnionUF object that does not contain a bottom virtual 
node. numberOfSites() returns the value of a counter that is incremented in open().  
percolates() checks to see if the top node is connected to the bottom node. I 
implemented two recomended methods, xyTo1D() which takes a row, column and converts 
it to a single number, and validateIndex(), which checks to see if the row and 
column are in bounds.


/******************************************************************************
 *  Using Percolation with QuickFindUF.java,  fill in the table below such that
 *  the N values are multiples of each other.

 *  Give a formula (using tilde notation) for the running time (in seconds) of
 *  PercolationStats.java as a function of both N and T. Be sure to give both
 *  the coefficient and exponent of the leading term. Your coefficients should
 *  be based on empirical data and rounded to two significant digits, such as
 *  5.3*10^-8 * N^5.0 T^1.5.
 *****************************************************************************/

(keep T constant)
T = 100
 N          time (seconds)
------------------------------
100 		0.166
200			0.865
400			5.627
800			49.032
1600		426.712


(keep N constant)
N = 100
 T          time (seconds)
------------------------------
100 		0.148
200			0.286
400			0.554
800			1.111
1600		2.208


running time as a function of N and T:  ~ 4.2E-9 * N^2.8 T^0.97


/******************************************************************************
 *  Repeat the previous question, but use WeightedQuickUnionUF.java.
 *****************************************************************************/


(keep T constant)
T = 100
 N          time (seconds)
------------------------------
100			0.11
200			0.474
400			2.274
800			13.51
1600		74.69


(keep N constant)
N = 100
 T          time (seconds)
------------------------------
100 		0.11
200			0.22
400			0.433
800			0.873
1600		1.741


running time as a function of N and T:  ~ 2.7E-8 * N^2.3 T^1.0


/**********************************************************************
 *  How much memory (in bytes) does a Percolation object use to store
 *  an N-by-N grid? Use the 64-bit memory cost model from Section 1.4
 *  of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/
boolean[][] is ~N^2 bytes (24 + 17N + N^2 bytes: 24 for overhead, 16N for 
array object overhead, N for boolean type, N^2 for the amount of booleans 
in the array)
int is 4 * ~4 bytes (by definition and I initialize 4 of them)
WeightedQuickUnionUF is 2 * ~8 bytes (each object reference is 8 bytes and 
I initialize two of them)

WeightedQuickUnionUF is 2 * ~ 8n bytes (8N + 88 bytes: 16 for overhead, 
8 + (4N + 24) bytes for each int[], there are 2, 4 bytes for int, and 4 
bytes of padding)

Total: 24 + 17N + N^2 + 16 + 16 + 16N + 172
228 + 33N + N^2
~ N^2

/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
It has a slightly higher memory requirement as I initialize two WeightedQuickUnionUF.



/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and exercises, but do
 *  include any help from people (including classmates and friends) and
 *  attribute them by name.
 *****************************************************************************/
Emily Andrulis helped me talk through my process to fix the backsplash problem.

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/
Fixing the backsplash problem had me stuck for about an hour and a half just 
thinking about possible solutions.



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/
Calculating the running time function is much easier if you have Excel graph the 
points and draw a linear trendline for you. It may be that I didn't create enough 
data points to get a reliable ratio, but while doubling N, it did not seem to 
converge anywhere in particular, but the Excel graph of the lg vs lg gave me an 
extremely reliable slope.
