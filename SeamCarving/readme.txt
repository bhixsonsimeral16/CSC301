/******************************************************************************
 *  Name: Brian Hixson-Simeral
 *
 *  Operating system: Windows 10
 *  Compiler:
 *  Text editor / IDE: Sublime 2 / Eclipse
 *  Hours to complete assignment (optional): 7
 ******************************************************************************/


/******************************************************************************
 *  Describe concisely your algorithm to compute the horizontal and
 *  vertical seam.
 *****************************************************************************/
I iterate through either the entire top row or leftmost column and check the distance
to each of the three adjacent pixels, saving the index of the shortest path as well as the distance so far in double arrays that corresponds to the pixels in the image.
After one row/column is complete I repeate with the next row/column until arriving at
the final where I keep track of which pixel has the minimum energy path. I push the
indecies of the shortest path onto a stack and then pop them into the array, which I
return.
/******************************************************************************
 *  Describe what makes an image ideal for this seamCarving algorithm and what
 *   kind of image would not work well.
 *****************************************************************************/
Having very distinct low and high energy areas makes an ideal pictute. A group picture
where the group takes up the entire frame would not work well, as the algorithm would
oddly remove parts of people that didn't change much.
/******************************************************************************
 *  Give a formula (using tilde notation) for the running time
 *  (in seconds) required to reduce image size by one row and a formula
 *  for the running time required to reduce image size by one column.
 *  Both should be functions of W and H. Removal should involve exactly
 *  one call to the appropriate find method and one call to the
 *  appropriate remove method. The randomPicture() method in SCUtility
 *  may be useful.
 *
 *  Justify your answer with sufficient data using large enough
 *  W and H values. To dampen system effects, you may wish to perform
 *  many trials for a given value of W and H and average the results.
 *
 *  Be sure to give the leading coefficient and the value of the exponents
 *  as a fraction with 2 decimal places .
 *****************************************************************************/

(keep W constant)
 W = 1200
 H           Row removal time (seconds)     Column removal time (seconds)
--------------------------------------------------------------------------
1200              0.06256                           0.11852 Row Ratio  Col Ratio
2400              0.15434                           0.26402   2.46       2.228
4800              0.42178                           0.86592   2.73       3.28
9600              1.19008                           2.16416   2.82       2.49
                                                        avg:  2.67       1.666
                                                        log:  1.42       1.415

(keep H constant)
 H = 1200
 W           Row removal time (seconds)     Column removal time (seconds)
--------------------------------------------------------------------------
1200              0.06256                           0.11852 Row Ratio  Col Ratio
2400              0.16562                           0.2804    2.647      2.366
4800              0.50348                           0.87834   3.04       3.132
9600              1.31708                           2.86822   2.62       3.266
                                                        avg:  2.769      2.921
                                                        log:  1.469      1.546

Running time to remove one row as a function of both W and H:  
~ 4.74E-6 * (H^1.42 + W^1.469)



Running time to remove one column as a function of both W and H:  
~ 3.36E-6 * (H^1.415 + W^1.546)






/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/




/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and exercises, but do
 *  include any help from people (including classmates and friends) and
 *  attribute them by name.
 *****************************************************************************/


/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/
Trying to figure out the runtime function was kind of difficult as the numbers
varied by so much in each run.  Even the average had quite a large varience.



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/
