 ## LinkedList Insertions
In this code challenge I wrote the code for kFromEnd(int k).  This method takes in an int and returns the value of the Node that is k elements from the end of the list.  If the input, k, is too big or negative, then the method returns 'null' since the nodes hold String values.
 
 ### Approach & Efficiency
The approach I took in this problem was to create another Node pointer, which I called follower.  The current Node pointer will iterate through the list as normal until it reaches the last Node, at which point it stops.  The follower Node pointer, will also iterate through the list but will stay k Nodes behind current.  When current reaches the end of the list, follower will be at the correct Node.  There is also some logic to make sure k isn't negative, and that it wasn't bigger than the size of the list.  In those cases, it is impossible to return a value.
 
 kFromEnd()
 Time: O(n)
 Space: O(1)

 
 ### Solution
  <img src="../assets/kth-from-end.jpg"
       alt="White Board Picture"
       style="float: left; margin-right: 10px; width: 200px;" />