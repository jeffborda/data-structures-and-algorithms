package fizzbuzztree;

import tree.BinaryTree;
import tree.Node;

public class FizzBuzzTree {

    public static BinaryTree<Object> fizzBuzzTree(BinaryTree<Object> input) {

        fizzBuzzHelper(input.root);
        return input; //need to turn it to strings

    }


    private static void fizzBuzzHelper(Node<Object> current) {

        if(current == null) {
            return;
        }
        if((Integer) current.value % 3 == 0 && (Integer)current.value % 5 == 0) {
            current.value = "FizzBuzz";
            //current.value = 666999; //FizzBuzz
        }
        else if((Integer)current.value % 3 == 0) {
            current.value = "Fizz"; //Fizz
        }
        else if((Integer)current.value % 5 == 0) {
            current.value = "Buzz"; //Buzz
        }

        fizzBuzzHelper(current.left);
        fizzBuzzHelper(current.right);
    }




}
