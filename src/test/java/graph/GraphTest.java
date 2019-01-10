package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
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
        testGraph.addNode(node1);
        testGraph.addNode(node2);
        testGraph.addNode(node3);
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
        Graph<String> testGraph = new Graph<>();
        Node node1 = new Node("Main St.");
        Node node2 = new Node("1st Ave.");
        Node node3 = new Node("2nd Ave.");
        testGraph.addNode(node1);
        testGraph.addNode(node2);
        testGraph.addNode(node3);
        testGraph.addEdge(node1, node2, 10);
        assertTrue("If getNeighbors called on node1, should contain node2.", node1.hasNeighbor(node2));
        assertTrue("If getNeighbors called on node2, should contain node1.", node1.hasNeighbor(node2));
        assertFalse("node3 should not have any neighbors.", node3.hasNeighbor(node1));
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

    @Test
    public void testBreadthFirst() {
        Graph<String> testGraph = new Graph<>();
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        Node node7 = new Node("G");
        Node node8 = new Node("H");
        Node node9 = new Node("I");

        testGraph.addNode(node1);
        testGraph.addNode(node2);
        testGraph.addNode(node3);
        testGraph.addNode(node4);
        testGraph.addNode(node5);
        testGraph.addNode(node6);
        testGraph.addNode(node7);
        testGraph.addNode(node8);
        testGraph.addNode(node9);

        testGraph.addEdge(node1, node2, 10); // A - B
        testGraph.addEdge(node1, node3, 10); // A - C
        testGraph.addEdge(node1, node4, 10); // A - D
        testGraph.addEdge(node1, node5, 10); // A - E
        testGraph.addEdge(node1, node7, 10); // A - G
        testGraph.addEdge(node3, node4, 10); // C - D
        testGraph.addEdge(node6, node7, 10); // F - G
        testGraph.addEdge(node7, node3, 10); // G - C
        testGraph.addEdge(node7, node8, 10); // G - H
        testGraph.addEdge(node8, node9, 10); // H - I

        //                         I
        //                       /
        //                     H
        //                    /
        //            ┌---F--G - C
        //            B      | /  \
        //            └----- A    |
        //                  / \  /
        //                 E   D

        List<Node> testResults = testGraph.breadthFirst(node1);
        assertEquals("Size of list should be '8'", 8, testResults.size());
        assertEquals("First should get surrounding neighbors, in order that edges were added.", "B",testResults.get(0).value);
        assertEquals("First should get surrounding neighbors, in order that edges were added.", "C",testResults.get(1).value);
        assertEquals("First should get surrounding neighbors, in order that edges were added.", "D",testResults.get(2).value);
        assertEquals("First should get surrounding neighbors, in order that edges were added.", "E",testResults.get(3).value);
        assertEquals("First should get surrounding neighbors, in order that edges were added.", "G",testResults.get(4).value);
        assertEquals("First should get surrounding neighbors, in order that edges were added.", "F",testResults.get(5).value);
        assertEquals("First should get surrounding neighbors, in order that edges were added.", "H",testResults.get(6).value);
        assertEquals("First should get surrounding neighbors, in order that edges were added.", "I",testResults.get(7).value);
    }

    @Test
    public void testGetEdge() {
        Graph<String> testGraph = new Graph<>();
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        Node node7 = new Node("G");
        Node node8 = new Node("H");
        Node node9 = new Node("I");

        testGraph.addNode(node1);
        testGraph.addNode(node2);
        testGraph.addNode(node3);
        testGraph.addNode(node4);
        testGraph.addNode(node5);
        testGraph.addNode(node6);
        testGraph.addNode(node7);
        testGraph.addNode(node8);
        testGraph.addNode(node9);

        testGraph.addEdge(node1, node2, 10); // A - B
        testGraph.addEdge(node1, node3, 10); // A - C
        testGraph.addEdge(node1, node4, 10); // A - D
        testGraph.addEdge(node1, node5, 10); // A - E
        testGraph.addEdge(node1, node7, 10); // A - G
        testGraph.addEdge(node3, node4, 10); // C - D
        testGraph.addEdge(node6, node7, 10); // F - G
        testGraph.addEdge(node7, node3, 10); // G - C
        testGraph.addEdge(node7, node8, 10); // G - H
        testGraph.addEdge(node8, node9, 10); // H - I

        //                         I
        //                       /
        //                     H
        //                    /
        //            ┌---F--G - C
        //            B      | /  \
        //            └----- A    |
        //                  / \  /
        //                 E   D


        String[] testCities1 = {"A", "B"};
        assertEquals("Any two cities that are direct neighbors should return a Connection object with values 'true' and price equals to the weight of the edge between them.", new Connection(true, 10), testGraph.getEdge(testCities1));

        String[] testCities2 = {"E", "D"};
        assertEquals("Cities that are NOT direct neighbors should return a Connection object with values 'false' and  price of '0'.", new Connection(false, 0), testGraph.getEdge(testCities2));

        String[] testCities3 = {"G", "H", "I"};
        assertEquals("If given more than two cities that are all direct neighbors from the one before it, should return Connection object with values 'true' and price equals to the sum total of the weight of the edges between them.", new Connection(true, 20), testGraph.getEdge(testCities3));

        String[] testCities4 = {"D", "A", "G", "H", "I"};
        assertEquals("If given more than two cities that are all direct neighbors from the one before it, should return Connection object with values 'true' and price equals to the sum total of the weight of the edges between them.", new Connection(true, 40), testGraph.getEdge(testCities4));

        String[] testCities5 = {"D", "A", "B", "H", "I"};
        assertEquals("If given more than two cities and any one of them can not be reached in one step from the other, than return Connection object with values 'false' and '0.", new Connection(false, 0), testGraph.getEdge(testCities5));

        String[] testCities6 = {"Z", "A", "B", "H", "I"};
        assertEquals("If any city in the input array is not in the graph, the Connection object should return with values 'false' and '0'.", new Connection(false, 0), testGraph.getEdge(testCities6));

        String[] testCities7 = {"I"};
        assertEquals("If only given an array with one city, the Connection object should return with values 'false' and '0'.", new Connection(false, 0), testGraph.getEdge(testCities7));
    }

    @Test
    public void testDepthFirst() {
        Graph<String> testGraph = new Graph<>();
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        Node node7 = new Node("G");
        Node node8 = new Node("H");
        Node node9 = new Node("I");

        testGraph.addNode(node1);
        testGraph.addNode(node2);
        testGraph.addNode(node3);
        testGraph.addNode(node4);
        testGraph.addNode(node5);
        testGraph.addNode(node6);
        testGraph.addNode(node7);
        testGraph.addNode(node8);
        testGraph.addNode(node9);

        testGraph.addEdge(node1, node2, 10); // A - B
        testGraph.addEdge(node1, node3, 10); // A - C
        testGraph.addEdge(node1, node4, 10); // A - D
        testGraph.addEdge(node1, node5, 10); // A - E
        testGraph.addEdge(node1, node7, 10); // A - G
        testGraph.addEdge(node3, node4, 10); // C - D
        testGraph.addEdge(node6, node7, 10); // F - G
        testGraph.addEdge(node7, node3, 10); // G - C
        testGraph.addEdge(node7, node8, 10); // G - H
        testGraph.addEdge(node8, node9, 10); // H - I

        //                         I
        //                       /
        //                     H
        //                    /
        //            ┌---F--G - C
        //            B      | /  \
        //            └----- A    |
        //                  / \  /
        //                 E   D

        List<Node> result = new ArrayList<>(Graph.depthFirst(testGraph, "A"));


        assertEquals("Depth first traversal should return a list, with the following order.", "A", result.get(0).getValue());
        assertEquals("G", result.get(1).getValue());
        assertEquals("H", result.get(2).getValue());
        assertEquals("I", result.get(3).getValue());
        assertEquals("F", result.get(4).getValue());
        assertEquals("E", result.get(5).getValue());
        assertEquals("D", result.get(6).getValue());
        assertEquals("C", result.get(7).getValue());
        assertEquals("B", result.get(8).getValue());
        assertEquals(9, result.size());

        Graph<String> testGraph2 = new Graph();
        assertTrue("An empty graph as input should return an empty list.", Graph.depthFirst(testGraph2, "A").isEmpty());

        Graph<String> testGraph3 = new Graph();
        Node nodeA = new Node("A");
        testGraph3.addNode(nodeA);
        List<Node> result3 = new ArrayList<>(Graph.depthFirst(testGraph3, "A"));
        assertEquals("First position should be the same value as the input.", "A", result3.get(0).getValue());
        assertEquals("Result list should be size '1'.", 1, result3.size());

        Graph<String> testGraph4 = new Graph<>();
        Node linkedA = new Node("A");
        Node linkedB = new Node("B");
        Node islandA = new Node("island-A");
        Node islandB = new Node("island-B");
        testGraph4.addNode(linkedA);
        testGraph4.addNode(linkedB);
        testGraph4.addNode(islandA);
        testGraph4.addNode(islandB);
        testGraph4.addEdge(linkedA, linkedB, 10);
        List<Node> result4 = new ArrayList<>(Graph.depthFirst(testGraph4, "A"));

        assertEquals("First position should be the same value as the input.", "A", result4.get(0).getValue());
        assertEquals("Second position should be 'B'.", "B", result4.get(1).getValue());
        assertEquals("Island nodes should print after all the linked nodes.", "island-B", result4.get(2).getValue());
        assertEquals("Island nodes should print after all the linked nodes.", "island-A", result4.get(3).getValue());
    }

}