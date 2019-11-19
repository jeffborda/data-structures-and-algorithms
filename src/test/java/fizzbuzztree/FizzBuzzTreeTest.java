package fizzbuzztree;

import org.junit.Test;
import tree.BinaryTree;
import tree.Node;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FizzBuzzTreeTest {

    @Test
    public void testFizzBuzzTree_emptyTree() {
        BinaryTree<String> testTree = new BinaryTree<>();
        assertTrue("Should get back empty array list if tree is empty.", FizzBuzzTree.fizzBuzzTree(testTree).inOrder().isEmpty());
    }

    @Test
    public void testFizzBuzzTree_oneNodeTree() {
        Node<String> root = new Node<>("1");
        BinaryTree<String> testTree = new BinaryTree<>(root);
        FizzBuzzTree.fizzBuzzTree(testTree);
        assertEquals("Should give back array list with one value.", "1", testTree.root.value);
    }

    @Test
    public void testFizzBuzzTree_balancedHeight3Tree() {
        Node<String> root = new Node<>("5", new Node<>("50", new Node<>("1", null, null), new Node<>("15", null, null)), new Node<>("6", new Node<>("21", null, null), new Node<>("30", null, null)));
        //       5
        //   50      6
        // 1  15   21 30
        BinaryTree<String> testTree = new BinaryTree<>(root);
        ArrayList<String> expected = new ArrayList<>();
        //IN-ORDER: 1, 50, 15, 5, 21, 6, 30
        expected.add("1");
        expected.add("Buzz"); //50
        expected.add("FizzBuzz"); //15
        expected.add("Buzz"); //5
        expected.add("Fizz"); //21
        expected.add("Fizz"); //6
        expected.add("FizzBuzz"); //30
        FizzBuzzTree.fizzBuzzTree(testTree);
        assertArrayEquals("Should match with the expected array when doing in-order traversal.", testTree.inOrder().toArray(), expected.toArray());
    }

    @Test
    public void testFizzBuzzTree_unbalancedHeight5Tree() {
        Node<String> root = new Node<>("10", new Node<>("4", new Node<>("33", null, null), null), new Node<>("9", new Node<>("45", null, null), new Node<>("8", null, new Node<>("44", null, new Node<>("15", null, null)))));
        //       10
        //   4      9
        // 33     45  8
        //              44
        //                15
        BinaryTree<String> testTree = new BinaryTree<>(root);

        ArrayList<String> expected = new ArrayList<>();
        //IN-ORDER: 33, 4, 10, 45, 9, 8
        expected.add("Fizz"); //33
        expected.add("4"); //4
        expected.add("Buzz"); //10
        expected.add("FizzBuzz"); //45
        expected.add("Fizz"); //9
        expected.add("8"); //8
        expected.add("44");
        expected.add("FizzBuzz");

        FizzBuzzTree.fizzBuzzTree(testTree);
        assertArrayEquals("Should match the expected array when doing in-order traversal.", testTree.inOrder().toArray(), expected.toArray());
    }

}
