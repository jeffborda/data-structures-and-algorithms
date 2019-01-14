# Graph
* [Code](../src/main/java/hashtable)

For this challenge I implemented a Hashtable class, which is represented by an array and nodes.  The main advantage to the Hashtable is O(1) lookup and insertion times when there are no collisions.  

## Methods

* `add()` Takes in a key/value pair and adds it to the Hashtable.
* `contains()` Takes in a key and returns true/false depending on if it's in the Hashtable.
* `find()` Takes in a key, and returns the node containing that key. If not found, it returns null.
* `getHash()` Takes in a key, returns an int representing an index in the array.
* `size()` Returns the number of Nodes contained in the Hashtable.

## Big-O

NOTE: These times assume there have been no collisions, which will require further implementation.

| Function       | Big-O Time | Big-O Space |
|----------------|------------|-------------|
|`add()`         |O(1)        | O(n)        |
|`contains()`    |O(1)        | O(1)        |
|`find()`        |O(1)        | O(1)        |
|`getHash()`     |O(1)        | O(1)        |
|`size()`        |O(1)        | O(1)        |

## Testing

I utilized JUnit testing for all the methods in the class.  I test assuming there are no collisions and also for the event there are collisions.
