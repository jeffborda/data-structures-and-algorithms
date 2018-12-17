# Trees
* [Code](../src/main/java/tree)

For this challenge I created two types data structures, ```BinaryTree``` and the child class ```BinarySearchTree```.  A Binary Tree is used for the three methods used to do traversals, which the Binary Search Tree can actually insert values into the tree in a proper order.  

## Binary Tree

```BinaryTree``` has only one field, ```Node root;```, which points to the root Node of the tree or to null if the tree is empty.  Both tree classes are made up of Nodes, which contain a value, and pointers to the left and right Nodes in the tree.

I used recursion to write the traversal methods in this class.  All of which must use a helper function since they are returning an ArrayList of the node values of the traversal.  


| Method           | Description                                                                            | Big-O Time  | Big-O Space  |
|------------------|----------------------------------------------------------------------------------------|-------------|--------------|
| ```inOrder()```  | Returns an ArrayList of the Node values or an in order traversal. (left, root, right)  | O(n)        | O(n)         |
| ```preOrder()``` | Returns an ArrayList of the Node values or a pre-order traversal. (root, left, right)  | O(n)        | O(n)         |
| ```postOrder()```| Returns an ArrayList of the Node values or a post-order traversal. (left, right, root) | O(n)        | O(n)         |


## Binary Search Tree

The `BinarySearchTree` class extends `BinaryTree`, and adds methods for adding values to the tree and for finding Nodes in the tree which match the input value.

| Method               | Description                                                                                        | Big-O Time  | Big-O Space  |
|----------------------|----------------------------------------------------------------------------------------------------|-------------|--------------|
| ```add()```         | Iterative solution, which adds a Node with input value to correct location in tree.                 | O(n)        | O(1)         |
| ```search()```      | Iterative solution, which searches the BST for a value. Returns Node if found, or null if not found.| O(n)        | O(1)         |


### Testing

I utilized jUnit testing on both classes to ensure methods were working properly.  I included tests for edge cases and empty trees as well.