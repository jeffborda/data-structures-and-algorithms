package graph;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void testAddNode() {

        Graph<String> testGraph = new Graph<>();
        assertTrue("Graph should be empty upon instantiation.", testGraph.isEmpty());
        Node node1 = new Node("Main St.");
        Node node2 = new Node("1st Ave.");
        Node node3 = new Node("2nd Ave.");
        assertTrue("Should return 'true' when Node is added successfully.", testGraph.addNode(node1));
        assertFalse("Graph should not be empty now.", testGraph.isEmpty());
        assertTrue("Should return 'true' when Node is added successfully.", testGraph.addNode(node2));
        assertTrue("Should return 'true' when Node is added successfully.", testGraph.addNode(node3));
        assertEquals("Size of the Graph should now be '3'.", 3, testGraph.size());
        assertTrue("Graph should contain the value 'Main St.'.", testGraph.hasNodeValue("Main St."));
        assertFalse("Graph should NOT contain the value 'Rucker St.'.", testGraph.hasNodeValue("Rucker St."));
    }

    @Test
    public void testAddEdge() {
        Graph<String> testGraph = new Graph<>();
        Node node1 = new Node("Main St.");
        Node node2 = new Node("1st Ave.");
        Node node3 = new Node("2nd Ave.");
        testGraph.addEdge(node1, node2, 10);
        assertTrue("Now node1 and node2 should be neighbors.", node1.hasNeighbor(node2));
        assertTrue("And node1 and node2 should be neighbors.", node2.hasNeighbor(node1));
        testGraph.addEdge(node2, node3, 20);
        assertTrue("Now node2 and node3 should be neighbors.", node2.hasNeighbor(node3));
        assertTrue("And node3 and node2 should be neighbors.", node3.hasNeighbor(node2));
        assertFalse("But node3 and node1 are NOT neighbors.", node1.hasNeighbor(node3));
        assertFalse("So node1 and node3 are also NOT neighbors.", node3.hasNeighbor(node1));
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