# Stacks and Queues
For this challenge I created a library for a Stack and a Queue.  They both utilize a Node class, and so they are structured in a similar way to lists, but behave differently.  I created both of these data structures to be able to hold generic types, so they can hold any data type other than primitives.

## Stack

Stack is constructed with only one field, ```Node<T> top```, which points to the top of the stack or to null if the stack is empty.  The Stack class is made up of Nodes, which contain a value and pointer to the next Node in the sequence.  For example, the top Node in a Stack with many Nodes will point to the next Node.  The bottom Node's next will point to null.


| Method           | Description                                                                    | Big-O Time  | Big-O Space  |
|------------------|--------------------------------------------------------------------------------|-------------|--------------|
| ```size()```     | Returns the size of the stack.  How many values/Nodes it contains.                                                 | O(n)        | O(1)         |
| ```isEmpty()```  | Returns true or false depending on if stack is empty or not empty.             | O(1)        | O(1)         |
| ```peek()```     | Returns the value of the top node in the stack and keeps that node on the top. | O(1)        | O(1)         |
| ```pop()```      | Removes the top node of the stack and returns its value.                       | O(1)        | O(1)         |
| ```push()```     | Adds a new value to the top of the stack.                                      | O(1)        | O(1)         |


## Queue

The Queue class is constructed with the same idea as a normal line.  It contains two pointers, ```Node<T> front``` and ```Node<T> rear```, to help with time efficiency.  When a Node is added to the Queue, it is always added to the back with ```enqueue()```.  When an item is removed from the Queue, it is always removed from the front with ```dequeue()```.

| Method               | Description                                                                      | Big-O Time  | Big-O Space  |
|----------------------|----------------------------------------------------------------------------------|-------------|--------------|
| ```size()```         | Returns the size of the queue.  How many values/Nodes it contains.               | O(n)        | O(1)         |
| ```isEmpty()```      | Returns true or false depending on if queue is empty or not empty.               | O(1)        | O(1)         |
| ```peek()```         | Returns the value of the front node in the queue and keeps that node on the top. | O(1)        | O(1)         |
| ```enqueue()```      | Removes the front node of the queue and returns its value.                       | O(1)        | O(1)         |
| ```dequeue()```      | Adds a new value to the back of the queue.                                       | O(1)        | O(1)         |