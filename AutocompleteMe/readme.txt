/******************************************************************************
 *  Name: Brian Hixson-Simeral
 *
 *  Operating system: Windows 10
 *  Compiler:
 *  Text editor / IDE: Gedit / Eclpise
 *  Hours to complete assignment (optional): 6
 ******************************************************************************/


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
It starts as a regular binary search function, but it includes a reference to the
left most index that contains the desired item.  This reference is instantiated
at -1, but every time the search finds a match it changes the index to the index 
of the match.  As I was saying, it acts as a normal binary search as it halves the
search area each time, but it is different because it takes the same number of 
compares every time.  To be absolutely sure that we have the right index it will
continue to seach until its search area is 0.  Each time we find a match we save it
and move left.  If the item that we found was less than the one we seek we move
right and if it is greater then we move left.

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms N and the
 *  number of matching terms M?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower order terms, e.g., M^2 + M log N.
 *****************************************************************************/

constructor: ~N (It iterates through a list of terms to copy them to make the data
immutable)

allMatches(): ~MlgM  (2lgN + M + MlgM: 2lgM as firstIndexOf and lastIndexOf takes lgN, M as we copy each of the matches to a new array, MlgM as merge sort with M
items takes MlgM time)

numberOfMatches(): 2lgN (firstIndexOf and lastIndexOf)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/




/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and exercises, but do
 *  include any help from people (including classmates and friends) and
 *  attribute them by name.
 *****************************************************************************/
Nigel and Paul helped me optimize my programs and helped me understand what the 
assignment was asking during certain parts.

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/
The biggest problem that I ran into was that I needed to add 1 to the last-first
in AutoComplete to get the last index in the array and I for got to in one spot.



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/
