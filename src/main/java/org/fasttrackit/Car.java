package org.fasttrackit;


import java.time.LocalDate;

// inheritance or "is-a" relationship
public class Car extends AutoVehicle {

    int doorCount;

    public Car(Engine engine) {
        super(engine);
    }

    public Car() {
        // any constructor will try to call the "no-parameter" constructor of the parent class
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }
}