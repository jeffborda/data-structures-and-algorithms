##Array Shift

### Approach & Efficiency
The approach I took was to make a result array which one element longer than the input array.  To find the middle I took the length of the input array and divided by two, added 0.5 for rounding, and then truncated the decimal off.  This gives the correct middle position for even, odd, and edge case length arrays like 0 and 1.

Once I knew the middle I entered a loop, where i starts at 0.  Inside the loop I checked if i was less than the middle position, where the array is copied 1:1.  Then I checked if i was equal to the middle position, in which case I copy in the number passed into the method.  Else the result array gets i -1 from input array, since this is where they are shifted.

Big-O is linear, O(n).  It will grow linearly based on the size of the input.

### Solution
<img src="../assets/ArrayShift.jpg"
     alt="White Board Picture"
     style="float: left; margin-right: 10px; width: 200px;" />

     