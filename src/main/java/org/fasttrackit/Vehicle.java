package org.fasttrackit;

import java.time.LocalDate;

public class Vehicle {

    private static int totalCount;

    private String name;
    private double mileage;
    private String color;
    private double maxSpeed;
    private boolean running;
    private double fuelLevel;
    private double traveledDistance;
    private LocalDate createdDate;

    public Vehicle() {
        totalCount++;
    }

    public double accelerate(double speed, double durationInHours) {
        if (fuelLevel <= 0) {
            System.out.println("You don't have enough fuel to accelerate. " +
                    "Fuel level: " + fuelLevel);
            return 0;
        }

        if (speed > maxSpeed) {
            System.out.println("Requested speed is too high. Maximum allowed: " +
                    maxSpeed);
            return 0;
        }

        // concatenation
        System.out.println(name + " is accelerating with "
                + speed + " km/h for " + durationInHours + "h.");

        double distance = speed * durationInHours;
        System.out.println("Traveled " + distance + " km.");

//        traveledDistance = traveledDistance + distance;
        // same result as the above statement
        traveledDistance += distance;
        // logs
        System.out.println("Total traveled distance: " + traveledDistance + " km.");

        double spentFuel = distance / 100 * mileage;
        System.out.println("Spent fuel: " + spentFuel + " l.");

//        fuelLevel = fuelLevel - spentFuel;
        // same as above
        fuelLevel -= spentFuel;
        System.out.println("Remaining fuel: " + fuelLevel + " l.");

        return distance;
    }

    public double accelerate(double speed) {
        return accelerate(speed, 1);
    }

    // Method signature must be the same, except:
    // 1. co-variant return type
    // (returned object must inherit what the overridden method was returning)
    // 2. Overriding method can allow larger access than was allowed in the super-class
    @Override
    public Vehicle clone() throws CloneNotSupportedException {
        return new Vehicle();
    }

    public String getName() {
        return name;
    }

    public double getMileage() {
        return mileage;
    }

    public String getColor() {
        return color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public boolean isRunning() {
        return running;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getTraveledDistance() {
        return traveledDistance;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setTraveledDistance(double traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", running=" + running +
                ", fuelLevel=" + fuelLevel +
                ", traveledDistance=" + traveledDistance +
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (Double.compare(vehicle.mileage, mileage) != 0) return false;
        if (Double.compare(vehicle.maxSpeed, maxSpeed) != 0) return false;
        if (running != vehicle.running) return false;
        if (Double.compare(vehicle.fuelLevel, fuelLevel) != 0) return false;
        if (Double.compare(vehicle.traveledDistance, traveledDistance) != 0) return false;
        if (name != null ? !name.equals(vehicle.name) : vehicle.name != null) return false;
        if (color != null ? !color.equals(vehicle.color) : vehicle.color != null) return false;
        return createdDate != null ? createdDate.equals(vehicle.createdDate) : vehicle.createdDate == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(mileage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(maxSpeed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (running ? 1 : 0);
        temp = Double.doubleToLongBits(fuelLevel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(traveledDistance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
