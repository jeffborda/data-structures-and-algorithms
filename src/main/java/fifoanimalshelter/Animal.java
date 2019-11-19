package fifoanimalshelter;

import java.util.Calendar;
import java.util.Date;

public class Animal {

    String name;
    Date intakeDate;

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    protected void setIntakeDate() {
        this.intakeDate = Calendar.getInstance().getTime();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
