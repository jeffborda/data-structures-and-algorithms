package hashtable;

public class Entry<V> {

    protected String key;
    protected V value;
    protected Entry<V> next;

    public Entry() {
        this.next = null;
    }

    public Entry(String key, V value, Entry<V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public java.lang.String toString() {
        return " (Key: " + this.key + " | Value: " + this.value + " | Next: " + this.next + ")";
    }

}
