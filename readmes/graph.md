# Graph
* [Code](../src/main/java/graph)

For this challenge I implemented a Graph class, which is represented by an adjacency list.  It contains a set of Nodes, and Nodes have a value and a list of neighboring Node edges.  In this class, there are two edges between Nodes.  

## Functions

* `addNode()` Takes in a Node and adds it to the Graph.  Returns true if added, else false.
* `addEdge()` Takes in two Nodes that will become neighbors, and the integer representing the weight of the edge between them.
* `getNodes()` Returns a HashSet of all Nodes inside of a Graph.
* `getNeighbors()` Returns a list of all neighboring Nodes of an input Node.
* `size()` Returns the number of Nodes contained in the Graph.

## Big-O

| Function       | Big-O Time | Big-O Space |
|----------------|------------|-------------|
|`addNode()`     |O(1)        | O(1)        |
|`addEdge()`     |O(1)        | O(1)        |
|`getNodes()`    |O(1)        | O(1)        |
|`getNeighbors()`|O(1)        | O(1)        |
|`size()`        |O(n)        | O(1)        |

## Testing

I utilized JUnit testing for all the main functions, which also tests the helper functions I wrote for the class.
