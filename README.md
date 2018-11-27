#Data Structures and Algorithms - Code Challenges


# Reverse an Array
Write a method that takes an array as an argument and returns that array in reverse order.

## Challenge
<!-- Description of the challenge -->

## Approach & Efficiency
The approach I took was to create a result array the same size as the input.  Then I looped through based on the size of
 the input, with the iteration starting at 0.  Since this is the first element of the result array, I needed to set it 
 to the last element of the input array.  To find the last element, then the next to last and so on.. I used the 
 formula: inputArray.length - 1 - i.

Big-O is linear, O(n).  It will grow linearly based on the size of the input.

## Solution
<img src="src/main/resources/ReverseArray.jpg"
     alt="White Board Picture"
     style="float: left; margin-right: 10px; width: 200px;" />