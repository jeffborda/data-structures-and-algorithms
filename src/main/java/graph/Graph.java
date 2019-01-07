package graph;

import java.util.*;

public class Graph<T> {

    protected Set<Node> graph;

    public Graph() {
        this.graph = new HashSet<>();
    }

    public boolean addNode(Node node) {
        return graph.add(node);
    }

    public void addEdge(Node<T> node1, Node<T> node2, Integer weight) {
        Edge edge1 = new Edge(node1, node2, weight);
        Edge edge2 = new Edge(node2, node1, weight);
        node1.addEdge(edge1);
        node2.addEdge(edge2);
    }

    /**
     *
     * @return the graph, represented by a Set of Nodes
     */
    public Set getNodes() {
        return graph;
    }

    public List getNeighbors(Node input) {
        List<Edge> result = new LinkedList<>();
        for(Node node : graph) {
            if(node == input) {
                return node.neighbors;
            }
        }

        return null;
    }

    public int size() {
        return graph.size();
    }
}
