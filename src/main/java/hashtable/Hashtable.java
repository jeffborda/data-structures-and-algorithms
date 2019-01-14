package hashtable;

import java.util.Random;

public class Hashtable<String, V> {

    protected Node<String, V>[] table;
    protected static double RANDOM_DOUBLE;
    protected static int PRIME_NUMBER = 17;

    public Hashtable() {
        this.table = new Node[16];
        // Alternate instantiation from: https://stackoverflow.com/questions/19478225/array-of-generic-nodes-java
//         this.table = (Node<T>[]) new Node<?>[16];
        Node<String, V> newNode = new Node<String, V>();
        for(int i = 0; i < this.table.length; i++) {
            this.table[i] = newNode;
        }
        Random r = new Random();
        this.RANDOM_DOUBLE = Math.abs(r.nextDouble());
    }


    /**
     * Takes in both the key and value. This method should getHash the key and add the key and value pair to the table.
     */
    public boolean add(String key, V value) {

        


        return false;
    }

    /**
     * Takes in the key and returns if the key exists in the table already.
     */
    public boolean contains(String searchKey) {

        for(int i = 0; i < this.table.length; i++) {
            if(this.table[i].key == searchKey) {
                return true;
            }
            Node current = this.table[i];
            while(current.next != null) {
                current = current.next;
                if(current.key == searchKey) {
                    return true;
                }
            }
        }

        return false;
    }

    protected int getHash(java.lang.String keyToHash) {

        int resultHash = 1;


        for(int i = 0; i < keyToHash.length(); i++) {
            resultHash += resultHash * keyToHash.charAt(i) * RANDOM_DOUBLE;
        }
        resultHash *= keyToHash.length();
        resultHash %= this.table.length;

        return Math.abs(resultHash);
    }










}
