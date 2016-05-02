/******************************************************************************
 *  Name: Brian Hixson-Simeral
 *
 *  Operating system: Windows 10
 *  Compiler:
 *  Text editor / IDE: Sublime 2 / Eclipse
 *  Hours to complete assignment (optional): 7
 ******************************************************************************/



/******************************************************************************
 *  Describe the Node data type you used to implement the
 *  2d-tree data structure.
 *****************************************************************************/
The node that I implemented included a left and right child node, an int 
representing the level of the tree that it is on, the Point2D associated with the
node, the associated value, and the RectHV associated with the node.
/******************************************************************************
 *  Describe your method for range search in a kd-tree.
 *****************************************************************************/
I create a stack for nodes and a queue for the Point2Ds that are contained in the
RectHV.  I iteratively pop the first node off the stack and if the RectHV associated
with this node intersects the the given RectHV push the left and right children and
check to see if the given RectHV contains the node.

/******************************************************************************
 *  Describe your method for nearest neighbor search in a kd-tree.
 *****************************************************************************/
Maintain a champion Point2D and champion distance as well as a stack that conatins
nodes

/******************************************************************************
 *  Using the 64-bit memory cost model from the textbook and lecture,
 *  give the total memory usage in bytes of your 2d-tree data structure
 *  as a function of the number of points N. Use tilde notation to
 *  simplify your answer (i.e., keep the leading coefficient and discard
 *  lower-order terms).
 *
 *  Include the memory for all referenced objects (including
 *  Node, Point2D, and RectHV objects) except for Value objects
 *  (because the type is unknown). Also, include the memory for
 *  all referenced objects.
 *
 *  Justify your answer below.
 *
 *****************************************************************************/

bytes per Point2D: 32 bytes

bytes per RectHV: 48 bytes (4 * 8 bytes for doubles + 16 for overhead)

bytes per KdTree of N points:   ~ 72N

8 (int + padding) + 8 (KdNode) + 16 (overhead) = 32b
16b (2 * 8 KdNode reference) + 4b (int reference) + 4b (padding) + 8b (Point2D
reference) + 8b (value reference) + 8b (rect reference) + 24 (nested class) = 72b 
per KdNode





/******************************************************************************
 *  How many nearest neighbor calculations can your brute-force
 *  implementation perform per second for input100K.txt (100,000 points)
 *  and input1M.txt (1 million points), where the query points are
 *  random points in the unit square? Explain how you determined the
 *  operations per second. (Do not count the time to read in the points
 *  or to build the 2d-tree.)
 *
 *  Repeat the question but with the 2d-tree implementation.
 *****************************************************************************/

                       calls to nearest() per second
                     brute force               2d-tree
                     ---------------------------------
input100K.txt        27.2                      95581.4

input1M.txt          2.2                       57082.6



/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/




/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and exercises, but do
 *  include any help from people (including classmates and friends) and
 *  attribute them by name.
 *****************************************************************************/
Nigel helped me write the testing script for the nearest neighbor calculations

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/
