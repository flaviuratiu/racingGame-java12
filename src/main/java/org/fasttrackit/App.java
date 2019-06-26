package org.fasttrackit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.manufacturer = "Renault";

        Car car = new Car(engine);
        car.setName("Dacia");
        car.setColor("blue");
        car.doorCount = 4;
        car.setMileage(9.5);
        car.setFuelLevel(50);
        car.setRunning(true);

        System.out.println("Our engine...");
        System.out.println(car.engine.manufacturer);


        Car car2 = new Car(new Engine());
        car2.setName("Lada");
        car2.setColor("black");
        car2.doorCount = 2;
        car2.setMileage(5.1);
        car2.setFuelLevel(60);
        car2.setRunning(false);

        Car car3 = car;

        System.out.println(car.getName());
        System.out.println(car3.getName());

        System.out.println("Changing values...");

        car.setName("Dacia Logan");

        System.out.println(car.getName());
        System.out.println(car3.getName());

        System.out.println(car.getMaxSpeed());
        System.out.println(car.engine);

        double distance = car.accelerate(60, 0.5);
        distance = car.accelerate(60, 0.5);
        System.out.println("Distance in App.main: " + distance);

        // demo for static variables (class variables)
//        System.out.println("Studying static variables...");
//
//        car.totalCount = 1;
//        System.out.println("Total count from car: " + car.totalCount);
//
//        car2.totalCount = 2;
//        System.out.println("Total count from car after setting car2: " + car.totalCount);
//        System.out.println("Total count from car2: " + car2.totalCount);
//        System.out.println("Total count from Vehicle class: " + Vehicle.totalCount);


        System.out.println("Total vehicles: " + Vehicle.getTotalCount());

        car2.accelerate(100);

        new AutoVehicle();

        new Car();

        System.out.println("Today...");

        System.out.println(car.toString());


        BatMobile batMobile = new BatMobile();
        batMobile.setName("Cheating vehicle");

        batMobile.accelerate(60, 1);

        batMobile.accelerate(60);

        car.accelerate(60, 1);
    }

}
