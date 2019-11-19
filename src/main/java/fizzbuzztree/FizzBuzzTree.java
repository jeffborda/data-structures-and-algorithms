package fizzbuzztree;

import tree.BinaryTree;
import tree.Node;

public class FizzBuzzTree {

    public static BinaryTree<String> fizzBuzzTree(BinaryTree<String> input) {

        fizzBuzzHelper(input.root);
        return input;
    }


    private static void fizzBuzzHelper(Node<String> current) {

        if(current == null) {
            return;
        }
        if(Integer.parseInt(current.value) % 3 == 0 && Integer.parseInt(current.value) % 5 == 0) {
            current.value = "FizzBuzz";
        }
        else if(Integer.parseInt(current.value) % 3 == 0) {
            current.value = "Fizz";
        }
        else if(Integer.parseInt(current.value) % 5 == 0) {
            current.value = "Buzz";
        }

        fizzBuzzHelper(current.left);
        fizzBuzzHelper(current.right);
    }

}
