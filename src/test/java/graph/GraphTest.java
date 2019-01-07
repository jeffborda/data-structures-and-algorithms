package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void testAddNode() {

        Graph<String> testGraph = new Graph<>();
        Node node1 = new Node("Main St.");
        Node node2 = new Node("1st Ave.");
        Node node3 = new Node("2nd Ave.");

//        System.out.println(node1);
        testGraph.addNode(node1);
        testGraph.addNode(node2);
//
        testGraph.addEdge(node1, node2, 5);

        System.out.println(testGraph.getNeighbors(node1));

    }

    @Test
    public void testAddEdge() {
    }

    @Test
    public void testGetNodes() {
    }

    @Test
    public void testGetNeighbors() {
    }

    @Test
    public void testSize() {
    }
}