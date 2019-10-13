package queuewithstacks;

import stacksandqueues.Stack;

public class PseudoQueue<T> {

    protected Stack<T> stackOne;
    protected Stack<T> stackTwo;

    public PseudoQueue() {
        stackOne = new Stack<>(); //dequeue stack
        stackTwo = new Stack<>(); //enqueue stack
    }

    public void enqueue(T value){
        while(!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        stackTwo.push(value);
    }

    public T dequeue() {
        if(stackOne.isEmpty() && stackTwo.isEmpty()) {
            return null;
        }
        while(!stackTwo.isEmpty()) {
            stackOne.push(stackTwo.pop());
        }
        return stackOne.pop();
    }

    public boolean isEmpty() {
        if(stackOne.isEmpty() && stackTwo.isEmpty()) {
            return true;
        }
        return false;
    }

}
