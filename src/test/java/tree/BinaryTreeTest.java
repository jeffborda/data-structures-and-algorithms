package tree;

import linkedlist.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

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
    public void testInOrder_manyNodes_testOne() {
        // IN-ORDER: Left, Root, Right
        Node<Integer> root = new Node<>(4, new Node<>(2, new Node<>(1, null, null), new Node<>(3, null, null)), new Node<>(6, new Node<>(5, null, null), new Node<>(7, null, null)));
        //     4
        //   2    6
        // 1   3  5   7
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        ArrayList<Integer> inOrderExpected = new ArrayList<>();
        inOrderExpected.add(1);
        inOrderExpected.add(2);
        inOrderExpected.add(3);
        inOrderExpected.add(4);
        inOrderExpected.add(5);
        inOrderExpected.add(6);
        inOrderExpected.add(7);
        assertArrayEquals("Should return an ArrayList with values In-Order (left, root, right).", testTree.inOrder().toArray(), inOrderExpected.toArray());
    }

    @Test
    public void testInOrder_manyNodes_testTwo() {
        Node<Integer> root = new Node<>(1, new Node<>(3, new Node<>(5, null, null), new Node<>(7, null, null)), new Node<>(2, new Node<>(6, null, null), new Node<>(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        ArrayList<Integer> inOrderExpected = new ArrayList<>();
        inOrderExpected.add(5);
        inOrderExpected.add(3);
        inOrderExpected.add(7);
        inOrderExpected.add(1);
        inOrderExpected.add(6);
        inOrderExpected.add(2);
        inOrderExpected.add(4);
        assertArrayEquals(testTree.inOrder().toArray(), inOrderExpected.toArray());
    }

    @Test
    public void testInOrder_oneNodeTree() {
        Node<Integer> root = new Node<>(7, null, null);
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        ArrayList<Integer> inOrderExpected = new ArrayList<>();
        inOrderExpected.add(7);
        assertArrayEquals("Check inOrder() on one node tree.", testTree.inOrder().toArray(), inOrderExpected.toArray());
    }

    @Test
    public void testPreOrder_manyNodes_testOne() {
        // PRE-ORDER: Root, Left, Right
        Node<Integer> root = new Node<>(4, new Node<>(2, new Node<>(1, null, null), new Node<>(3, null, null)), new Node<>(6, new Node<>(5, null, null), new Node<>(7, null, null)));
        //     4
        //   2    6
        // 1   3  5   7
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        //Expect: 4, 2, 1, 3, 6, 5, 7
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(2);
        expected.add(1);
        expected.add(3);
        expected.add(6);
        expected.add(5);
        expected.add(7);
        assertArrayEquals("Should return an ArrayList in Pre-Order (root, left, right).", expected.toArray(), testTree.preOrder().toArray());
    }

    @Test
    public void testPreOrder_manyNodes_testTwo() {
        Node<Integer> root = new Node<>(1, new Node<>(3, new Node<>(5, null, null), new Node<>(7, null, null)), new Node<>(2, new Node<>(6, null, null), new Node<>(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        ArrayList<Integer> expected = new ArrayList<>();
        //Expect: 1, 3, 5, 7, 2, 6, 4
        expected.add(1);
        expected.add(3);
        expected.add(5);
        expected.add(7);
        expected.add(2);
        expected.add(6);
        expected.add(4);
        assertArrayEquals("Should return an ArrayList in Pre-Order (root, left, right).", expected.toArray(), testTree.preOrder().toArray());
    }

    @Test
    public void testPreOrder_oneNodeTree() {
        Node<Integer> root = new Node<>(7, null, null);
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(7);
        assertArrayEquals("Check preOrder() on one node tree.", expected.toArray(), testTree.preOrder().toArray());
    }

    @Test
    public void testPostOrder_manyNodes_testOne() {
        // POST-ORDER: Left, Right, Root

        Node<Integer> root = new Node<>(4, new Node<>(2, new Node<>(1, null, null), new Node<>(3, null, null)), new Node<>(6, new Node<>(5, null, null), new Node<>(7, null, null)));
        //     4
        //   2    6
        // 1   3  5   7
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        //Expect: 1, 3, 2, 5, 7, 6, 4
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(2);
        expected.add(5);
        expected.add(7);
        expected.add(6);
        expected.add(4);
        assertArrayEquals("Should return an ArrayList in Post-Order (left, right, root).", testTree.postOrder().toArray(), expected.toArray());
    }

    @Test
    public void testPostOrder_manyNodes_testTwo() {
        Node<Integer> root = new Node<>(1, new Node<>(3, new Node<>(5, null, null), new Node<>(7, null, null)), new Node<>(2, new Node<>(6, null, null), new Node<>(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        ArrayList<Integer> expected = new ArrayList<>();
        //Expect: 5, 7, 3, 6, 4, 2, 1
        expected.add(5);
        expected.add(7);
        expected.add(3);
        expected.add(6);
        expected.add(4);
        expected.add(2);
        expected.add(1);
        assertArrayEquals("Should return an ArrayList in Post-Order (left, right, root).", testTree.postOrder().toArray(), expected.toArray());
    }

    @Test
    public void testPostOrder_oneNodeTree() {
        Node<Integer> root = new Node<>(7, null, null);
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(7);
        assertArrayEquals("Check postOrder() on one node tree.", testTree.postOrder().toArray(), expected.toArray());

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

    @Test
    public void testSumOfOdds() {

        Node n1 = new Node(1, new Node(3, new Node(5, null, null), new Node(7, null, null)), new Node(2, new Node(6, null, null), new Node(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4
        BinaryTree testTree1 = new BinaryTree(n1);
        assertEquals("Sum of odds in this tree is '16'.", 16, BinaryTree.sumOfOdds(testTree1.root));

        Node n2 = new Node(4, new Node(2, new Node(1, null, new Node(99, null, null)), new Node(3, null, null)), new Node(6, new Node(5, null, null), new Node(7, new Node(66, null, null), null)));
        //      4
        //    2    6
        //  1   3  5   7
        //   99       66
        BinaryTree testTree2 = new BinaryTree(n2);
        assertEquals("Sum an odds in uneven tree, should be '115'.", 115, BinaryTree.sumOfOdds(testTree2.root));

        Node n3 = new Node(1, null, null);
        BinaryTree testTree3 = new BinaryTree(n3);
        assertEquals("Sum a tree of one node with odd value, should be '1'.", 1, BinaryTree.sumOfOdds(testTree3.root));

        Node n4 = new Node(2, null, null);
        BinaryTree testTree4 = new BinaryTree(n4);
        assertEquals("Sum a tree of one node with even value, should be '0'.", 0, BinaryTree.sumOfOdds(testTree4.root));

        BinaryTree testTree5 = new BinaryTree();
        assertEquals("Sum of empty tree, should be '0'.", 0, BinaryTree.sumOfOdds(testTree5.root));
    }

    @Test
    public void testTreeIntersection() {
        Node n1 = new Node(1, new Node(3, new Node(5, null, null), new Node(7, null, null)), new Node(2, new Node(6, null, null), new Node(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4
        BinaryTree testTree1 = new BinaryTree(n1);
        assertEquals("Sum of odds in this tree is '16'.", 16, BinaryTree.sumOfOdds(testTree1.root));

        Node n2 = new Node(4, new Node(2, new Node(1, null, new Node(99, null, null)), new Node(3, null, null)), new Node(6, new Node(5, null, null), new Node(7, new Node(66, null, null), null)));
        //      4
        //    2    6
        //  1   3  5   7
        //   99       66
        BinaryTree testTree2 = new BinaryTree(n2);
        // Shared values: 1, 2, 3, 4, 5, 6, 7
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertEquals("Should return a Set of all the values the two tree have in common.", expected, BinaryTree.treeIntersection(testTree1, testTree2));


        Node n3 = new Node(1, new Node(2, null, null), new Node(3, null, null));
        Node n4 = new Node(5, new Node(6, null, null), new Node(7, null, null));
        BinaryTree testTree3 = new BinaryTree(n3);
        BinaryTree testTree4 = new BinaryTree(n4);
        // No shared values
        Set<Integer> expected2 = new HashSet<>();
        assertEquals("If no shared values between two trees, than it should return an empty Set.", expected2, BinaryTree.treeIntersection(testTree3, testTree4));

        BinaryTree testTree5 = new BinaryTree();
        BinaryTree testTree6 = new BinaryTree();
        assertEquals("If given one or two empty trees, it should return an empty Set (and not break in the process).", expected2, BinaryTree.treeIntersection(testTree5, testTree6));

    }

    @Test
    public void testIsBinaryTree_notBST() {
        Node<Integer> root = new Node<>(1, new Node<>(3, new Node<>(5, null, null), new Node<>(7, null, null)), new Node<>(2, new Node<>(6, null, null), new Node<>(4, null, null)));
        //     1
        //  3     2
        //5   7  6   4
        BinaryTree<Integer> testTree1 = new BinaryTree<>(root);
        assertFalse("A Binary Tree that is NOT a BST should return 'false'.", BinaryTree.isBinarySearchTree(testTree1));
    }

    @Test
    public void testIstBinaryTree_isBST() {
        Node<Integer> root = new Node<>(10, new Node<>(3, new Node<>(1, null, null), new Node<>(7, null, null)), new Node<>(20, new Node<>(15, null, null), new Node<>(30, null, null)));
        //     10
        //  3     20
        //1   7  15   30
        BinaryTree<Integer> testTree2 = new BinaryTree<>(root);
        assertTrue("A Binary Search Tree should return 'true'.", BinaryTree.isBinarySearchTree(testTree2));
    }


    @Test
    public void testBinaryTreeToLinkedListByDepth() {
        // Test tree structure:
        //                   1
        //         10                 20
        //    100     200         300    400
        //1000           2000  3000 4000    5000

        Node<Integer> root = new Node<>(1, new Node<>(10, new Node<>(100, new Node<>(1000), null), new Node<>(200, null, new Node<>(2000))), new Node<Integer>(20, new Node<>(300, new Node<>(3000), new Node<>(4000)), new Node<>(400, null, new Node<>(5000))));
        BinaryTree<Integer> testTree = new BinaryTree<>(root);
        Integer[][] expected = new Integer[][]{{1}, {10, 20}, {100, 200, 300, 400}, {1000, 2000, 3000, 4000, 5000}};
        ArrayList<linkedlist.LinkedList<Integer>> result = testTree.binaryTreeToLinkedListByDepth();

        for(int i = 0; i < result.size(); i++) {
            linkedlist.Node<Integer> curr = result.get(i).getHead();
            for(int j = 0; j < expected[i].length; j++) {
                assertEquals("Check all LinkedList values from each level of the tree, left to right: " +
                                "[1],[10->20], [100->200->300->400], [1000->2000->3000->4000->5000]"
                                , expected[i][j], curr.value);
                curr = curr.next;
            }
        }
    }

    @Test
    public void testBinaryTreeToLinkedListByDepth_emptyTree() {
        BinaryTree<String> testTree = new BinaryTree<>();
        ArrayList<LinkedList<String>> result = testTree.binaryTreeToLinkedListByDepth();
        assertTrue("If BinaryTree is empty, should return an empty ArrayList.", result.isEmpty());
    }

}
