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

    public Animal dequeue(String preference) {
        if(preference.toLowerCase().equals("cat")) {
            return cats.dequeue();
        }
        if(preference.toLowerCase().equals("dog")) {
            return dogs.dequeue();
        }
        return null;
    }

    public boolean isEmpty() {
        if(cats.isEmpty() && dogs.isEmpty()) {
            return true;
        }
        return false;
    }

    protected Queue<Cat> getCats() {
        return cats;
    }

    protected Queue<Dog> getDogs() {
        return dogs;
    }
}
