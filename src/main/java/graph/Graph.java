package graph;

import stacksandqueues.Queue;
import stacksandqueues.Stack;

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
        if(!graph.contains(node1) || !graph.contains(node2)) {
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
        return this.graph;
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

    public List<Node> breadthFirst(Node start) {
        // Create the result list
        List<Node> result = new LinkedList<>();

        // **Make this a HashSet
        // Create list of visited Nodes
        List<Node> haveVisited = new LinkedList<>();
        // Put all first neighbors in a list, no risk of dupes yet.
        List<Edge> firstNeighbors = start.neighbors;

        // Check if there are no neighbors, if so return empty list
        if(firstNeighbors.isEmpty()) {
            return result;
        }

        // Create a Queue
        Queue<Node> neighbors = new Queue<>();

        // Put all the first neighbors in the queue and haveVisited
        for(Edge e : firstNeighbors) {
            neighbors.enqueue(e.neighbor);
            haveVisited.add(e.neighbor);
        }

        // Enter loop until the Queue is empty
        while(!neighbors.isEmpty()) {

            // Peek at the Queue, enqueue all of it's neighbors
            List<Edge> temp = neighbors.peek().neighbors;
            for(Edge e : temp) {
                if(e.neighbor != start && !haveVisited.contains(e.neighbor)) {
                    neighbors.enqueue(e.neighbor);
                    haveVisited.add(e.neighbor);
                }
            }
            // Dequeue and add Node to results
            result.add(neighbors.dequeue());

        }
        return result;
    }

    /*
    Write a function which takes in a graph, and an array of city names.
     Without utilizing any of the built-in methods available to your language,
     return whether the full trip is possible with direct flights, and how
     much it would cost.
     */
    public Connection getEdge(String[] cities) {

        int price = 0;
        boolean followupFound = false;

        // Length is -1 because we need to check cities in the array: i to the i+1 position.
        for(int i = 0; i < cities.length - 1; i++) {
            followupFound = false;
            for(Node<T> n : graph) {
                if(n.value.equals(cities[i])) {
                    // Found the node that matches the primary city

                    for(Edge e : n.neighbors) {
                        // Follow-up city found in neighbors list, get the weight of the edge.
                        if(e.neighbor.value.equals(cities[i + 1])) {
                            price += e.weight;
                            followupFound = true;
                        }
                    }
                    // Follow-up city not found
                    if(!followupFound) {
                        return new Connection(false, 0);
                    }
                }
            }
        }
        // If given an array with just one city, return false Connection
        if(!followupFound) {
            return new Connection(false, 0);
        }
        return new Connection(true, price);
    }

    private boolean hasCity(String city) {
        for(Node<String> n: graph) {
            if(n.value.equals(city)) {
                return true;
            }
        }
        return false;
    }


    /*
    Perform a depth first, pre-order traversal of the input graph, starting with the input node.
     */
    public static List<Node> depthFirst(Graph inputGraph, String startValue) {

        // Put all Nodes into array - in case there are any "island" Nodes
        List<Node> graph = new ArrayList<Node>(inputGraph.graph);
        List<Node> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        if(graph.isEmpty()) {
            return result;
        }
        // Push target node on stack and into visited HashSet
        for(Node n : graph) {
            if(n.value.equals(startValue)) {
                stack.push(n);
                visited.add(n);
            }
        }

        while(!stack.isEmpty()) {
            Node temp = stack.pop();
            result.add(temp);
            for(Edge e : (List<Edge>) temp.neighbors) {
                if(!visited.contains(e.neighbor)) {
                    stack.push(e.neighbor);
                    visited.add(e.neighbor);
                }
            }
        }

        return result;
    }


}
