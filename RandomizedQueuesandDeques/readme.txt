/******************************************************************************
 *  Name: Brian Hixson-Simeral
 *
 *  Operating system: Windows 10
 *  Compiler:
 *  Text editor / IDE: Sublime Text 2 / Eclipse
 *  Hours to complete assignment (optional):
 ******************************************************************************/



/******************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?
 *****************************************************************************/
I implemented the deque with a linked list as the linked list allows for access 
to the front and back of the queue in canstant time with relatively small memory 
use.  I created a doubly linked list and maintained a reference to the first and 
last item in the queue to make adding and removing items faster.

I implemented the randomized queue with a resizing array originally because I 
wanted to implement both data structures, but eventually I realized that 
randomizing operations is only really possible in constant time if each of the 
items is indexed in some way.  Therefore I created the resizing array with a 
counter for the number of items contained within. The random functions will 
randomly choose between any of the indexes that contain an item.

/******************************************************************************
 *  How much memory (in bytes) do your data types use to store N items
 *  in the worst case? Use the 64-bit memory cost model from Section
 *  1.4 of the textbook and use tilde notation to simplify your answer.
 *  Briefly justify your answers and show your work.
 *
 *  Do not include the memory for the items themselves (as this
 *  memory is allocated by the client and depends on the item type)
 *  or for any iterators, but do include the memory for the references
 *  to the items (in the underlying array or linked list).
 *****************************************************************************/

Randomized Queue: 16 overhead + 4 int reference + 4 padding + 24 array overhead
+ 6*8N (N object references in the array, potential to only have 1/4 of array full, 
plus and array of 1/2 size is created during the resize operation)             
~  48N  bytes 

Deque: 16 overhead + 8*2 object references + 4 int reference + 4 padding + 48N 
(Node class: 16 overhead + 8 nested class + 8*3 object reference)
40 + 48N bytes
~  48N  bytes




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/




/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and exercises, but do
 *  include any help from people (including classmates and friends) and
 *  attribute them by name.
 *****************************************************************************/
Emily Andrulis helped me organize my Deque.java code so that it made more sense.

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/

 I learned a lot from this assignment. I've never written my own data type before 
 and I've never written nested classes before, so this was a great experience. I 
 really enjoy being able to analyze my algorithms and it's satisfying to write an 
 algoritm that works.