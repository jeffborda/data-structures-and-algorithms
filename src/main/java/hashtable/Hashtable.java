package hashtable;

import javax.lang.model.element.NestingKind;
import java.util.Random;

public class Hashtable<V> {

    protected Node<V>[] table;
    protected static double RANDOM_DOUBLE;
    protected static int PRIME_NUMBER = 17;
    protected int load;

    public Hashtable() {
        this.table = new Node[16];
//         this.table = (Node<T>[]) new Node<?>[16];

        for(int i = 0; i < this.table.length; i++) {
            this.table[i] = new Node<V>();
        }
        Random r = new Random();
        this.RANDOM_DOUBLE = Math.abs(r.nextDouble());
        this.load = 0;
    }


    /**
     * Takes in both the key and value. This method should getHash the key and add the key and value pair to the table.
     */
    public void add(String insertKey, V insertValue) {
        // Hash the search key to get the index
        int index = getHash(insertKey);
        // Check if that element of the array has not been used yet, and add it there if possible.
        if(this.table[index].next == null) {
            this.table[index].next = new Node(insertKey, insertValue, null);
            return;
        }
        // If that element is already full, start creating a list of Nodes
        Node current = this.table[index].next;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(insertKey, insertValue, null);
        return;
    }

    /**
     * Takes in the key and returns if the key exists in the table already.
     */
    public boolean contains(String searchKey) {

        // Hash the search key to get the index
        int index = getHash(searchKey);
        // First check that part of the array assuming there are no  collisions
        if(this.table[index].next != null) {
            if(this.table[index].next.key.equals(searchKey)) {
                return true;
            }
        }
        // Then check for key if there are collisions there
        Node current = this.table[index].next;
        while(current.next != null) {
            current = current.next;
            if(current.key.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Takes in the key and returns the value from key/value pair
     */
    public Node find(String key) {
        int index = getHash(key);

        Node current = this.table[index].next;
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










}
