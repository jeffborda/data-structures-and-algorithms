 ## LinkedList
 In this code challenge I created a singly linked list, with methods:
 *insert() : Inserts value to the first position.
 *includes() : Returns true/false depending on if a value is found inside the list.
 *print() : Prints all values being stored in the linked list.
 
 ### Approach & Efficiency
 The approach I took was to create the LinkedList class which has fields: Node head, and Node current.  The default constructor creates an empty list.  The Node class is used by the LinkedList class, and has a String value for the value being stored and a Node next, to point to the next Node in the list.    
 
 insert()
 Time: O(1)
 Space: O(n)
 
 includes()
 Time: O(n)
 Space: O(n)
 
 print()
 Time: O(n)
 Space: O(1)
 