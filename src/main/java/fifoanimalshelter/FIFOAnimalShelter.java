package fifoanimalshelter;

import stacksandqueues.Queue;

public class FIFOAnimalShelter {

    private Queue<Cat> cats;
    private Queue<Dog> dogs;

    public FIFOAnimalShelter() {
        cats = new Queue<Cat>();
        dogs = new Queue<Dog>();
    }

    public void enqueue(Cat cat) {
        cats.enqueue(cat);
    }

    public void enqueue(Dog dog) {
        dogs.enqueue(dog);
    }

    public Cat dequeue(Cat) {
        return cats.dequeue();
    }

    public Dog dequeue(Dog) {
        return dogs.dequeue();
    }

}
