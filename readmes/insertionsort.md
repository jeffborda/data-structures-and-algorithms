# Insertion Sort
* [Code](../src/main/java/sort)

This code challenge was to write a function for insertion sort, which takes in an unsorted array and returns the array sorted using an insertion sort algorithm.  

The Insertion Sort algorithm takes an element in the array (starting at the second element and moving right) and puts it into the correct position on the left side of the array.  My algorithm sorts the array that was input to the method.

## Example

* Input: `[7, 5, 10, 1]`
* Output: `[1, 5, 7, 10]`


## Approach

Sorting an array with this algorithm involves two loops.  The outer loop keeps track of what value is being moved into its sorted position, starting with the second element in the array.  It then enters an inner loop which iterates leftwards in order to find the correct position for that element in the "sorted" part of the array.  The inner loop runs until it reaches zero or it finds a value which is less than it.


## Methods and Big-O

There are two loops in this method, each of which could run n times in the worst case.  The worst case is an array with values in reverse order.  Since it sorts the array in place, the space utilized is constant.

| Method                    | Description                                                                                                                        | Big-O Time  | Big-O Space  |
|---------------------------|-----------------------------------------------------------------------------------|-------------|--------------|
| `insertionSort()`         | Takes the input array and sorts it used the insertion sort algorithm.             | O(n²)       | O(1)         |


## Testing

I used JUnit testing on the following cases:
* An array with many elements.
* An empty array.
* An array with one element.
* An array with many elements in reverse order
* An array with many elements which is already in sorted order.




