package graph;

import java.util.LinkedList;
import java.util.List;

public class Node<T> {

    protected T value;
    protected List<Edge> neighbors;

    public Node(T value) {
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    protected boolean addEdge(Edge edge) {
        return neighbors.add(edge);
    }

    //
//    protected boolean hasNeighbors () {
//
//    }

    public boolean hasNeighbor(Node checkNode) {
        for(Edge edge : neighbors) {
            if(edge.vertex2 == checkNode) {
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
//        String neighborsString = "";
//        for(Edge edge : neighbors) {
//            neighborsString += "Neighbor: " + edge.vertex2 + " | Weight: " + edge.weight;
//        }
//        return "[Node(value: " + this.value + " | Neighbors: " + neighborsString;
        return this.value.toString();
    }


}
