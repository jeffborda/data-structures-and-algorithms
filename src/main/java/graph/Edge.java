package graph;

public class Edge<T> {

    protected Node<T> neighbor;
    protected Integer weight;

    protected Edge(Node<T> neighbor, Integer weight) {
        this.neighbor = neighbor;
        this.weight = weight;
    }

    public Node<T> getNeighborNode() {
        return this.neighbor;
    }
}
