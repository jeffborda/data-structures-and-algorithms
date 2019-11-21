package hashtable;

import java.util.Random;

public class Hashtable<V> {

    protected Node<V>[] table;
    protected final double RANDOM_DOUBLE;
    protected static final int PRIME_NUMBER = 17; // TODO: Add to hash function?
    protected int load; // This is really just the size, and have not implemented a way for the table to grow.

    public Hashtable() {
        // Generic array creation not allowed in Java
        //   RE: https://www.ibm.com/developerworks/java/library/j-jtp01255/index.html
        //   RE: https://stackoverflow.com/questions/7131652/generic-array-creation-error
        this.table = (Node<V>[])new Node<?>[16];
        Random r = new Random();
        this.RANDOM_DOUBLE = r.nextDouble();
        this.load = 0;
    }


    /**
     * Takes in both the key and value. This method should getHash the key and add the key and value pair to the table.
     */
    public void add(String insertKey, V insertValue) {
        // Hash the search key to get the index
        int index = getHash(insertKey);
        // Check if that element of the array has not been used yet, and add it there if possible.
        if(this.table[index] == null) {
            this.table[index] = new Node<>(insertKey, insertValue, null);
            load++;
            return;
        }
        // If that element is already full, start creating a list of Nodes
        Node<V> current = this.table[index];
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(insertKey, insertValue, null);
        load++;
    }

    /**
     * Takes in the key and returns if the key exists in the table already.
     */
    public boolean contains(String searchKey) {

        // Hash the search key to get the index
        int index = getHash(searchKey);
        // First check that part of the array assuming there are no  collisions
        if(this.table[index] != null) {
            if(this.table[index].key.equals(searchKey)) {
                return true;
            }
        }
        // Then check for key if there are collisions there



        Node<V> current = this.table[index];
        while(current != null) {
            if(current.key.equals(searchKey)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Takes in the key and returns the value from key/value pair
     */
    public Node<V> find(String key) {
        int index = getHash(key);

        // First check location if there are no collisions.
        if(this.table[index].key.equals(key)) {
            return this.table[index];
        }

        // If there were collisions, iterate through the list
        Node<V> current = this.table[index];
        while(current != null) {
            if(current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        // key not found
        return null;
    }

    /**
     * Takes in a key and returns the index in the array the key is stored.
     */
    protected int getHash(String keyToHash) {

        int resultHash = 1;
        for(int i = 0; i < keyToHash.length(); i++) {
            resultHash += resultHash * keyToHash.charAt(i) * RANDOM_DOUBLE;
        }
        resultHash *= keyToHash.length();
        resultHash %= this.table.length;
        return Math.abs(resultHash);
    }

    /**
     * Returns how many items are being stored in the Hashtable.
     */
    public int size() {
        return this.load;
    }

}
