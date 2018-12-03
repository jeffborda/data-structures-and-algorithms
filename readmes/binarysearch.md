 ##Binary Search
 Write a function called BinarySearch which takes in 2 parameters: a sorted array and the search key. Without utilizing any of the built-in methods available to your language, return the index of the array’s element that is equal to the search key, or -1 if the element does not exist.
 
 ### Approach & Efficiency
 The approach I took was to first read about this algorithm on Wikipedia.  We whiteboarded our solution, and had to adjust some of our boolean expressions to make sure we were following the algorithm and not going out of bounds.
 
 The algorithm works efficiently by effectively cutting the array in half each time it searches and fails to find the target number.  This is done by adjusting the variables left, right, and middle.  
 
 Time: O(log n)
 Space: O(1)
 
 ### Solution
 <img src="assets/BinarySearch.jpg"
      alt="White Board Picture"
      style="float: left; margin-right: 10px; width: 200px;" />