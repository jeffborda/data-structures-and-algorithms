package fizzbuzztree;

import org.junit.Test;
import tree.BinaryTree;
import tree.Node;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FizzBuzzTreeTest {

    @Test
    public void testFizzBuzzTree() {

        Node<String> n1 = new Node<>("5", new Node<>("50", new Node<>("1", null, null), new Node<>("15", null, null)), new Node<>("6", new Node<>("21", null, null), new Node<>("30", null, null)));
        //       5
        //   50      6
        // 1  15   21 30

        BinaryTree<String> test = new BinaryTree<>(n1);
        ArrayList<String> inOrderExpected = new ArrayList<>();
        //IN-ORDER: 1, 50, 15, 5, 21, 6, 30
        inOrderExpected.add("1");
        inOrderExpected.add("Buzz"); //50
        inOrderExpected.add("FizzBuzz"); //15
        inOrderExpected.add("Buzz"); //5
        inOrderExpected.add("Fizz"); //21
        inOrderExpected.add("Fizz"); //6
        inOrderExpected.add("FizzBuzz"); //30
        FizzBuzzTree.fizzBuzzTree(test);
        assertArrayEquals("Should match with the expected array when doing in-order traversal.", test.inOrder().toArray(), inOrderExpected.toArray());

        BinaryTree<String> test2 = new BinaryTree<>();

        assertTrue("Should get back empty array list if tree is empty.", FizzBuzzTree.fizzBuzzTree(test2).inOrder().isEmpty());


        Node<String> n3 = new Node<>("10", new Node<>("4", new Node<>("33", null, null), null), new Node<>("9", new Node<>("45", null, null), new Node<>("8", null, null)));
        BinaryTree<String> unevenTree = new BinaryTree<>(n3);
        //       10
        //   4      9
        // 33     45  8

        ArrayList<String> unevenTreeExpected = new ArrayList<>();
        //IN-ORDER: 33, 4, 10, 45, 9, 8
        unevenTreeExpected.add("Fizz"); //33
        unevenTreeExpected.add("4"); //4
        unevenTreeExpected.add("Buzz"); //10
        unevenTreeExpected.add("FizzBuzz"); //45
        unevenTreeExpected.add("Fizz"); //9
        unevenTreeExpected.add("8"); //8

        FizzBuzzTree.fizzBuzzTree(unevenTree);
        assertArrayEquals("Should match the expected array when doing in-order traversal.", unevenTree.inOrder().toArray(), unevenTreeExpected.toArray());
    }

}