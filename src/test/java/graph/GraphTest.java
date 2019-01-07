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
        Graph<String> testGraph = new Graph<>();
        assertTrue("List of Nodes should be empty before anything added.", testGraph.getNodes().isEmpty());
        Node node1 = new Node("Main St.");
        testGraph.addNode(node1);
        assertTrue("List of Nodes should have a Node with value of 'Main St.' in it.", testGraph.getNodes().contains(node1));
        Node node2 = new Node("1st Ave.");
        Node node3 = new Node("2nd Ave.");
        testGraph.addNode(node2);
        testGraph.addNode(node3);
        assertEquals("List should be size '3' after adding three Nodes.", 3, testGraph.getNodes().size());
        assertTrue("List of Nodes should have a Node with value of '1st Ave.' in it.", testGraph.getNodes().contains(node3));
    }

    @Test
    public void testGetNeighbors() {

    }

    @Test
    public void testSize() {
        Graph<String> testGraph = new Graph<>();
        assertEquals("Size of Graph should be '0' upon instantiation.", 0, testGraph.size());
        assertTrue("The isEmpty() function should also return 'true'.", testGraph.isEmpty());
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        testGraph.addNode(node1);
        assertEquals("Size of Graph should be '1' after one add.", 1, testGraph.size());
        assertFalse("The isEmpty() function should now return 'false'.", testGraph.isEmpty());
        testGraph.addNode(node1);
        assertEquals("Size of Graph should be '1' after attempting to add duplicate node.", 1, testGraph.size());
        testGraph.addNode(node2);
        assertEquals("Size of Graph should be '2' after two adds.", 2, testGraph.size());
        assertFalse("The isEmpty() function should return 'false'.", testGraph.isEmpty());
        testGraph.addNode(node3);
        assertEquals("Size of Graph should be '3' after three adds.", 3, testGraph.size());
        assertFalse("The isEmpty() function should return 'false'.", testGraph.isEmpty());
    }
}