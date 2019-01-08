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
        if(!this.graph.contains(node1) || !this.graph.contains(node2)) {
            throw new IllegalArgumentException("Node not in graph.");
        }
        node1.addEdge(node2, weight);
        node2.addEdge(node1, weight);
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
        if(graph.contains(input)) {
            if(input.neighbors != null) {
                return input.neighbors;
            }
        }
        return null;
    }

    // Returns number of Nodes in the Graph
    public int size() {
        return graph.size();
    }
    // Returns true if the Graph has no Nodes added, otherwise false
    public boolean isEmpty() {
        return graph.isEmpty();
    }

    // Returns whether or not value is contained in list.
    public boolean hasNodeValue(T inputValue) {
        for(Node node : graph) {
            if(node.getValue().equals(inputValue)) {
                return true;
            }
        }
        return false;
    }
}
