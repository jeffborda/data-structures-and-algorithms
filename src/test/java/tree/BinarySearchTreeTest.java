package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void testAdd() {
        BinarySearchTree testTree = new BinarySearchTree();
        assertTrue("Should return 'true' when adding a value that is not in the tree already.", testTree.add(4));
        assertTrue("Should return 'true' when adding a value that is not in the tree already.", testTree.add(2));
        assertTrue("Should return 'true' when adding a value that is not in the tree already.", testTree.add(1));
        assertTrue("Should return 'true' when adding a value that is not in the tree already.", testTree.add(3));
        assertTrue("Should return 'true' when adding a value that is not in the tree already.", testTree.add(6));
        assertTrue("Should return 'true' when adding a value that is not in the tree already.", testTree.add(5));
        assertTrue("Should return 'true' when adding a value that is not in the tree already.", testTree.add(7));
        //       4
        //   2       6
        // 1   3    5  7
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(arr));
        assertTrue("Confirm that values were inserted in correct order.", testTree.inOrder().equals(expected));

        assertTrue("Should return 'true' when adding a value that is not in the tree already.", testTree.add(9));
        assertTrue("Should return 'true' when adding a value that is not in the tree already.", testTree.add(0));

        //       4
        //   2       6
        // 1   3    5  7
        //0              9
        Integer[] arr2 = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(arr2));
        assertTrue("Confirm that values were inserted in correct order.", testTree.inOrder().equals(expected2));
        assertFalse("Should return 'false' if trying to add a number already in BST.", testTree.add(0));
    }

    @Test
    public void testFind() {

        BinarySearchTree testTree = new BinarySearchTree();
        assertEquals("Should return 'null' when trying to find a value in an empty tree.", null, testTree.find(1));
        assertEquals("Should return 'null' when trying to find a value in an empty tree.", null, testTree.find(2));

        testTree.add(10);
        testTree.add(5);
        testTree.add(15);
        testTree.add(0);
        testTree.add(7);
        testTree.add(12);
        testTree.add(20);
        //              10
        //          5        15
        //        0   7     12  20

        assertEquals("Make sure the value of the Entry found matches input.", 7, testTree.find(7).value);
        assertEquals("Make sure the value of the Entry found matches input.", 15, testTree.find(15).value);
        assertEquals("The right of '15' should contain the value of '20'.", 20, testTree.find(15).right.value);
        assertEquals("Should return null if value not in the tree.", null, testTree.find(99));

    }

    @Test
    public void testSortedArrayToBST_evenLengthArr() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // Should make a tree like this:
        //         4
        //       /   \
        //      2     6
        //     / \   / \
        //    1  3  5   7
        BinarySearchTree<Integer> testTree = BinarySearchTree.sortedArrayToBST(arr);
        assertEquals(4, testTree.root.value);
        assertEquals(2, testTree.root.left.value);
        assertEquals(6, testTree.root.right.value);
        assertEquals(1, testTree.root.left.left.value);
        assertEquals(3, testTree.root.left.right.value);
        assertEquals(5, testTree.root.right.left.value);
        assertEquals(7, testTree.root.right.right.value);
        assertNull(testTree.root.left.left.left);
        assertNull(testTree.root.left.left.right);
        assertNull(testTree.root.left.right.left);
        assertNull(testTree.root.left.right.right);
        assertNull(testTree.root.right.right.left);
        assertNull(testTree.root.right.right.right);
    }

    @Test
    public void testSortedArrayToBST_oddLengthArr() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        // Should make a tree like this:
        //         3
        //       /   \
        //      2     5
        //       \   / \
        //       1  4  6
        BinarySearchTree<Integer> testTree = BinarySearchTree.sortedArrayToBST(arr);
        assertEquals(3, testTree.root.value);
        assertEquals(1, testTree.root.left.value);
        assertEquals(2, testTree.root.left.right.value);
        assertEquals(5, testTree.root.right.value);
        assertEquals(4, testTree.root.right.left.value);
        assertEquals(6, testTree.root.right.right.value);
    }
}
