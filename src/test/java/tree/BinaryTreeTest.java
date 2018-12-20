package tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testInOrder() {
        // IN-ORDER: Left, Root, Right
        Node n4 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)), new Node(6, new Node(5, null, null), new Node(7, null, null)));
        //     4
        //   2    6
        // 1   3  5   7
        BinaryTree testTree = new BinaryTree(n4);
        ArrayList<Integer> inOrderExpected = new ArrayList<>();
        inOrderExpected.add(1);
        inOrderExpected.add(2);
        inOrderExpected.add(3);
        inOrderExpected.add(4);
        inOrderExpected.add(5);
        inOrderExpected.add(6);
        inOrderExpected.add(7);
        assertTrue(testTree.inOrder().equals(inOrderExpected));

        Node n1 = new Node(1, new Node(3, new Node(5, null, null), new Node(7, null, null)), new Node(2, new Node(6, null, null), new Node(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4
        BinaryTree testTree2 = new BinaryTree(n1);
        ArrayList<Integer> inOrderExpected2 = new ArrayList<>();
        inOrderExpected2.add(5);
        inOrderExpected2.add(3);
        inOrderExpected2.add(7);
        inOrderExpected2.add(1);
        inOrderExpected2.add(6);
        inOrderExpected2.add(2);
        inOrderExpected2.add(4);
        assertTrue(testTree2.inOrder().equals(inOrderExpected2));

        Node n7 = new Node(7, null, null);
        BinaryTree testTree3 = new BinaryTree(n7);
        ArrayList<Integer> inOrderExpected3 = new ArrayList<>();
        inOrderExpected3.add(7);
        assertTrue("Check on one node tree.", testTree3.inOrder().equals(inOrderExpected3));

    }

    @Test
    public void testPreOrder() {
        // PRE-ORDER: Root, Left, Right

        Node n4 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)), new Node(6, new Node(5, null, null), new Node(7, null, null)));
        //     4
        //   2    6
        // 1   3  5   7
        BinaryTree testTree = new BinaryTree(n4);
        //Expect: 4, 2, 1, 3, 6, 5, 7
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(2);
        expected.add(1);
        expected.add(3);
        expected.add(6);
        expected.add(5);
        expected.add(7);
        assertTrue(testTree.preOrder().equals(expected));

        Node n1 = new Node(1, new Node(3, new Node(5, null, null), new Node(7, null, null)), new Node(2, new Node(6, null, null), new Node(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4
        BinaryTree testTree2 = new BinaryTree(n1);
        ArrayList<Integer> expected2 = new ArrayList<>();
        //Expect: 1, 3, 5, 7, 2, 6, 4
        expected2.add(1);
        expected2.add(3);
        expected2.add(5);
        expected2.add(7);
        expected2.add(2);
        expected2.add(6);
        expected2.add(4);
        assertTrue(testTree2.preOrder().equals(expected2));

        Node n7 = new Node(7, null, null);
        BinaryTree testTree3 = new BinaryTree(n7);
        ArrayList<Integer> expected3 = new ArrayList<>();
        expected3.add(7);
        assertTrue("Check on one node tree.", testTree3.preOrder().equals(expected3));
    }

    @Test
    public void testPostOrder() {
        // POST-ORDER: Left, Right, Root

        Node n4 = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)), new Node(6, new Node(5, null, null), new Node(7, null, null)));
        //     4
        //   2    6
        // 1   3  5   7
        BinaryTree testTree = new BinaryTree(n4);
        //Expect: 1, 3, 2, 5, 7, 6, 4
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        expected.add(6);
        expected.add(4);
        assertTrue(testTree.postOrder().equals(expected));

        Node n1 = new Node(1, new Node(3, new Node(5, null, null), new Node(7, null, null)), new Node(2, new Node(6, null, null), new Node(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4
        BinaryTree testTree2 = new BinaryTree(n1);
        ArrayList<Integer> expected2 = new ArrayList<>();
        //Expect: 5, 7, 3, 6, 4, 2, 1
        expected2.add(5);
        expected2.add(7);
        expected2.add(3);
        expected2.add(6);
        expected2.add(4);
        expected2.add(2);
        expected2.add(1);

        assertTrue(testTree2.postOrder().equals(expected2));

        Node n7 = new Node(7, null, null);
        BinaryTree testTree3 = new BinaryTree(n7);
        ArrayList<Integer> expected3 = new ArrayList<>();
        expected3.add(7);
        assertTrue("Check on one node tree.", testTree3.postOrder().equals(expected3));

    }

    @Test
    public void testBreadthFirst() {
        Node n1 = new Node(1, new Node(3, new Node(5, null, null), new Node(7, null, null)), new Node(2, new Node(6, null, null), new Node(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4

        BinaryTree testTree1 = new BinaryTree(n1);
        String newLine = System.lineSeparator();
        BinaryTree.breadthFirst(testTree1);
        assertEquals("Should get values separated by comma and one space, but no comma or space after last value.", "1, 3, 2, 5, 7, 6, 4", outContent.toString());

        outContent.reset();
        BinaryTree testTree2 = new BinaryTree();
        BinaryTree.breadthFirst(testTree2);
        assertEquals("Should get empty string with an empty tree.", "", outContent.toString());

        outContent.reset();
        Node n3 = new Node(1, null, null);
        BinaryTree testTree3 = new BinaryTree(n3);
        BinaryTree.breadthFirst(testTree3);
        assertEquals("Should get one value printed with no commas in a one node tree.", "1", outContent.toString());

        outContent.reset();
        Node n4 = new Node(4, new Node(2, new Node(1, null, new Node(99, null, null)), new Node(3, null, null)), new Node(6, new Node(5, null, null), new Node(7, new Node(66, null, null), null)));
        //      4
        //    2    6
        //  1   3  5   7
        //   99       66
        BinaryTree testTree4 = new BinaryTree(n4);
        BinaryTree.breadthFirst(testTree4);
        assertEquals("Check output on an uneven tree with many values.", "4, 2, 6, 1, 3, 5, 7, 99, 66", outContent.toString());


    }




    @Test
    public void testFindMaxValue() {

        Node n1 = new Node(1, new Node(3, new Node(5, null, null), new Node(7, null, null)), new Node(2, new Node(6, null, null), new Node(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4

        BinaryTree testTree1 = new BinaryTree(n1);
        assertEquals(7, BinaryTree.findMaxValue(testTree1));

        Node n2 = new Node(4, new Node(2, new Node(1, null, new Node(99, null, null)), new Node(3, null, null)), new Node(6, new Node(5, null, null), new Node(7, new Node(66, null, null), null)));
        //      4
        //    2    6
        //  1   3  5   7
        //   99       66
        BinaryTree testTree2 = new BinaryTree(n2);
        assertEquals(99, BinaryTree.findMaxValue(testTree2));

        Node n3 = new Node(1, null, null);
        BinaryTree testTree3 = new BinaryTree(n3);
        assertEquals(1, BinaryTree.findMaxValue(testTree3));
    }

    @Test(expected = IllegalStateException.class)
    public void testFindMaxValueEmptyTree() {
        BinaryTree emptyTree = new BinaryTree();
        BinaryTree.findMaxValue(emptyTree);
    }

}