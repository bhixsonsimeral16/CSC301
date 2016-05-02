/******************************************************************************
 *  Name: Brian Hixson-Simeral
 *
 *  Operating system: Windows 10
 *  Compiler:
 *  Text editor / IDE: Sublime 2 / Eclipse
 *  Hours to complete assignment (optional): 6
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
 W = 800
 H           Row removal time (seconds)     Column removal time (seconds)
--------------------------------------------------------------------------
300              0.026                             0.037
600              0.037                             0.047
1200             0.08                              0.096
2400             0.31                              0.227


(keep H constant)
 H = 600
 W           Row removal time (seconds)     Column removal time (seconds)
--------------------------------------------------------------------------
400              0.023                             0.034
800              0.037                             0.047
1600             0.081                             0.096
3200             0.311                             0.2


Running time to remove one row as a function of both W and H:  ~ H + W



Running time to remove one column as a function of both W and H:  ~ H + W






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




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/
