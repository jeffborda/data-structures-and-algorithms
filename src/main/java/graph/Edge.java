package graph;

public class Edge {

    protected Node vertex1;
    protected Node vertex2;
    protected Integer weight;

    public Edge(Node start, Node end, Integer weight) {
        this.vertex1 = start;
        this.vertex2 = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Start: " + this.vertex1 + " | End: " + this.vertex2 + " | Weight: " + this.weight;
    }


}
