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
}