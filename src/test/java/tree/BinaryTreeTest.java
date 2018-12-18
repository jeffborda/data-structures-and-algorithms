package tree;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BinaryTreeTest {

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

    }


}