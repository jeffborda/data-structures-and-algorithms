package fifoanimalshelter;

import stacksandqueues.Queue;

public class FIFOAnimalShelter {

    private Queue<Cat> cats;
    private Queue<Dog> dogs;

    public FIFOAnimalShelter() {
        this.cats = new Queue<>();
        this.dogs = new Queue<>();
    }

    public void enqueue(Cat cat) {
        cat.setIntakeDate();
        cats.enqueue(cat);
    }

    public void enqueue(Dog dog) {
        dog.setIntakeDate();
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

    // Returns whether there are any animals in the shelter
    public boolean isEmpty() {
        return cats.isEmpty() && dogs.isEmpty();
    }

    protected Queue<Cat> getCats() {
        return cats;
    }

    protected Queue<Dog> getDogs() {
        return dogs;
    }
}
