package org.fasttrackit;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private Track[] tracks = new Track[3];
    private List<Vehicle> competitors = new ArrayList<>();

    public void start() throws Exception {
        initializeTracks();
        displayTracks();

        Track selectedTrack = getTrackSelectedByUser();

        int competitorCount = getCompetitorCountFromUser();

        for (int i = 0; i < competitorCount; i++) {
            addCompetitor();
        }

        displayCompetitors();
    }

    private Track getTrackSelectedByUser() {
        System.out.println("Please enter track number:");
        try {
            Scanner scanner = new Scanner(System.in);
            int trackNumber = scanner.nextInt();

            Track track = tracks[trackNumber - 1];

            System.out.println("Selected track: " + track.getName());
            return track;
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("You entered an invalid track number. Please try again...");

            // recursion - a method invoking itself
            return getTrackSelectedByUser();
        }
    }

    private void addCompetitor() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(getVehicleNameFromUser());
        vehicle.setFuelLevel(60);
        vehicle.setMaxSpeed(200);
        vehicle.setMileage(ThreadLocalRandom.current().nextDouble(4.5, 20));

        competitors.add(vehicle);
    }

    private String getVehicleNameFromUser() {
        System.out.println("Please enter vehicle name:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int getCompetitorCountFromUser() throws Exception {
        System.out.println("Please enter vehicle count:");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new Exception("You entered an invalid value.");
        } finally {
            // finally block is always executed
            System.out.println("Read input from user");
        }
    }

    private void displayCompetitors() {
        System.out.println("Today's competitors are:");

        for (int i = 0; i < competitors.size(); i++) {
            if (competitors.get(i) != null) {
                System.out.println(competitors.get(i).getName() + " - mileage: " + competitors.get(i).getMileage());
            }
        }
    }

    private void initializeTracks() {
        Track city = new Track();
        city.setName("Cluj Track");
        city.setLength(100);

        tracks[0] = city;

        Track forest = new Track();
        forest.setName("Faget Track");
        forest.setLength(20);

        tracks[1] = forest;
    }

    private void displayTracks() {
        System.out.println("Available tracks:");
        for (int i = 0; i < tracks.length; i++) {
            if (tracks[i] != null) {
                System.out.println((i + 1) + ". " + tracks[i].getName());
            }
        }
    }
}
