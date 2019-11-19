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

    // Returns the dog that has been at the shelter the longest.
    public Dog getNextDog() throws IllegalStateException {
        if(dogs.isEmpty()) {
            throw new IllegalStateException("There are no dogs in the shelter.");
        }
        return dogs.dequeue();
    }

    // Returns the cat that has been at the shelter the longest.
    public Cat getNextCat() throws IllegalStateException {
        if(cats.isEmpty()) {
            throw new IllegalStateException("There are no cats in the shelter.");
        }
        return cats.dequeue();
    }

    // Returns the animal, either cat or dog, which has been at the shelter the longest.
    public Animal getNextAnimal() throws IllegalStateException {
        // Logic handling if one or both of the queues is empty
        if(cats.isEmpty() && dogs.isEmpty()) {
            throw new IllegalStateException("The shelter is empty");
        } else if(cats.isEmpty()) {
            return dogs.dequeue();
        } else if(dogs.isEmpty()) {
            return cats.dequeue();
        }
        if(cats.peek().intakeDate.before(dogs.peek().intakeDate)) {
            return cats.dequeue();
        }
        else {
            return dogs.dequeue();
        }
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
