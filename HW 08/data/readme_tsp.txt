/**********************************************************************
 *  readme template                                                   
 *  Traveling Salesperson Problem
 **********************************************************************/

Name: Hector Herrera
PennKey: hectorh
Recitation: 216

Hours to complete assignment (optional):


/**********************************************************************
 *  Have you entered all help, collaboration, and outside resources
 *  in your help log?  If not, do so now.  (And in future, make sure
 *  you make your help log entries as you go, not at the end!)
 *
 *  If you did not get any help in outside of TA or instructor office hours,
 *  and did not use any materials outside of the standard
 *  course materials and piazza, write the following statement below:
 *  "I did not receive any help outside of TA or instructor office hours.
 *  I did not collaborate with anyone, and I did not use any
 *  resources beyond the standard course materials."
 **********************************************************************/
I did not receive any help outside of TA or instructor office hours.
I did not collaborate with anyone, and I did not use any
resources beyond the standard course materials.
/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.
 **********************************************************************/
I found the distance from all the points to the point to be inserted
and used a for loop to find the minimum distance. Then I used a temp
node to hold the value at that node where the distance is minimized so 
that I can add the inserted point after the temp node.
/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.
 *  It's sufficient to list only the differences between this
 *  heuristic and the nearest insertion heuristic.
 **********************************************************************/
This heuristic used the smallest increment in distance. It used a formula 
that summed the distances of the point to be inserted and the point before 
it and the point after it, minus the total distance of the points around 
the point to be inserted. This was used to calculate the incremental 
distance and used a for loop to find the smallest increment in total distance.
/**********************************************************************
 *  Fill in the distances computed by your heuristics.                
 **********************************************************************/

data file        order     nearest     smallest      extra credit
-----------------------------------------------------------------------
tsp10.txt       2586.7     1566.1       1655.7
tsp100.txt      25547      7389.8       4887.2
tsp1000.txt   3.2769e+05   27869        17266
usa13509.txt  3.9108e+06   77450        45075

 /**********************************************************************
 *  Why is it a good idea to repeat the first Node at the end of the
 *  Tour?
 **********************************************************************/
It will complete the tour and will represent the actual traveling from
point to point because you will end up where you started off. It makes it
easier to implement it as well.
    
/**********************************************************************
 *  If you did the extra credit, explain your heuristic, and how
 *  you went about implementing it.
 **********************************************************************/

/**********************************************************************
 *  If you did the extra credit, give instructions here for 
 *  running it.
 **********************************************************************/
    
/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
