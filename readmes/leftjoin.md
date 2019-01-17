# Left Join
* [Code](../src/main/java/leftjoin)

In this challenge, the inputs are two HashMaps with String key/value pairs. The method is required to perform a LEFT JOIN and return a data structure containing the results.  I chose to return another HashMap which has String keys, and a list of String values.

A LEFT JOIN will return all key/values in the left table, and for any key in the right table that also appears in the left table, that right table's value will also be put into the HashMap. 

## Example

<img src="../assets/left-join-example.png"
       alt="White Board Picture"
       style="float: left; margin-right: 10px; width: 200px;" />

## Approach

I chose to return a HashMap since HashMaps will contains unique keys and will perform lookups in constant time.  The steps of the algorithm are:

1. Iterate through the left HashMap.  
2. Make a list which will contain the String values. 
3. Add the left HashMap value to the list always.
4. Check if the right table has the same key.
5. If so, add it's value to the list.
6. If not, add a 'null' to the list.
7. Put the Key/Value(list) pair into the result HashMap.
8. Return the result HashMap.



## Methods and Big-O

There is only loop in the method, and lookups are constant time with HashMaps.  I make a copy HashMap to return which could be size n.

| Method                    | Description                                                                                                                        | Big-O Time  | Big-O Space  |
|---------------------------|------------------------------------------------------------------------------------------------------------------------------------|-------------|--------------|
| `leftJoin()`              | Public static method that takes in two HashMaps, and will return a HashMap with the result of the LEFT JOIN.                       | O(n)        | O(n)         |


## Testing

I used JUnit testing on the following cases:
* HashMaps with size > 1 and many shared keys.
* HashMaps with size > 1 and no shared keys.
* Empty HashMaps.
* The fact that the result should always be the same size as the left input HashMap.
* The fact that the list of values for each key in the result is size 2.

## Solution

  <img src="../assets/left-join-example.jpg"
       alt="White Board Picture"
       style="float: left; margin-right: 10px; width: 200px;" />



