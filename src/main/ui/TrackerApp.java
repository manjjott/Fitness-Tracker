package ui;

import model.Meal;

import java.util.Locale;
import java.util.Scanner;

//Food Intake Tracker
public class TrackerApp {
    private Meal meal;
    private Scanner input;

    //EFFECTS: run the tracker application
    public TrackerApp() {
        runTracker();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runTracker() {
        boolean keepGoing = true;
        String command = null;

        input = new Scanner(System.in);
        input.useDelimiter("\n");

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {

                processCommand(command);
            }

            System.out.println("\nGoodbye!");

        }
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("b")) {
            addBreakfast();
        } else if (command.equals("l")) {
            addLunch();
        } else if (command.equals("d")) {
            addDinner();
        } else if (command.equals("c")) {
            checkCalories();
        } else if  (command.equals("m")) {
            checkMacros();
        } else {
            System.out.println("Selection not available...");
        }
    }

    //EFFECTS : displays menu options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tb -> Breakfast");
        System.out.println("\tl -> Lunch");
        System.out.println("\td -> Dinner");
        System.out.println("\tc -> Check Calories");
        System.out.println("\tm -> Check Macros");
    }

    private void addBreakfast() {

    }

    private void addLunch() {
    }

    private void addDinner() {

    }

    private void checkCalories() {

    }

    private void checkMacros() {
    }


}
