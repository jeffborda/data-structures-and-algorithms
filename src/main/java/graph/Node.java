package graph;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {

    protected T value;
    protected List<Edge<T>> neighbors;

    public Node() {
        this.neighbors = new LinkedList<>();
    }

    public Node(T value) {
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    // Adds edge between Nodes.
    protected boolean addEdge(Node<T> neighbor, Integer weight) {
        Edge<T> edge = new Edge(neighbor, weight);
        return neighbors.add(edge);
    }

    // Helper function to determine if a Node is neighbors with the input Node.
    public boolean hasNeighbor(Node checkNode) {
        for(Edge edge : neighbors) {
            if(edge.neighbor == checkNode) {
                return true;
            }
        }
        return false;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public String toString() {

        return (String)this.value;
    }


}
