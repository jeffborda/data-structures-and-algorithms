# Graph - Breadth First Traversal
* [Code](../src/main/java/graph)

## Description
This code challenge was to do a breadth first traversal on a Graph, and return a list of nodes in that order.  The list takes a node as an input, so it will first contain a list of the "first neighbors", then the "second neighbors", and so on.

## Approach

In the end, I used a similar approach as I had done with a linked linked breadth first traversal by using a Queue.  To do this I first added all the neighbors to Queue.  Then I dequeued the first item (adding its node to the results list) and enqueued all of its neighbors to the back.  This way I spread out by the nth neighbor.

To make this work with a graph, I also had to keep track of a list of nodes that I had already visited -since a Graph can have any number of connection and in any direction.  I also checked to make sure I never added the same node that was input to the function.

# Methods and Big-O

| Method           | Description                                                                                                | Big-O Time  | Big-O Space  |
|------------------|------------------------------------------------------------------------------------------------------------|-------------|--------------|
| `breadthFirst()` | This is the public function which returns a list of Nodes in order of the breadth-first traversal.         | O(n^2)      | O(n)       |

Since I iterating through the list of neighbors in a node and also using `.contains()` to check the list of Nodes I have already visited, the time is Big-o squared.  The space is linear because I am making a return list which is as large as the graph itself.

# Solution

  <img src="../assets/graph-breadth-first.jpg"
       alt="White Board Picture"
       style="float: left; margin-right: 10px; width: 200px;" />



