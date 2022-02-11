package ui;

import model.Food;
import model.Meal;


import java.util.Scanner;

//Food Intake Tracker
public class TrackerApp {
    private Meal meal;
    private Scanner input;

    //EFFECTS: run the tracker application
    public TrackerApp() {
        meal = new Meal();
        welcome();
        runTracker();
    }


    //EFFECTS : prints out the welcome statement
    private void welcome() {
        System.out.println(" Welcome !! to your Calorie and Meal tracker !!!");
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runTracker() {
        displayMenu();
        input = new Scanner(System.in);
        String command = input.nextLine();
        processCommand(command);
    }

    //MODIFIES: this
    //EFFECTS: processes user command
   // @SuppressWarnings({"MethodLength", "checkstyle:SuppressWarnings"})
    private void processCommand(String command) {
        if (command.equals("b")) {
            addBreakfast();
        } else if (command.equals("db")) {
            deleteBreakfast();
        } else if (command.equals("cb")) {
            checkBreakfast();
        } else if (command.equals("l")) {
            addLunch();
        } else if (command.equals("dl")) {
            deleteLunch();
        } else {
            continuedProcessCommand(command);
        }
    }

    public void continuedProcessCommand(String command) {
        if (command.equals("cl")) {
            checkLunch();
        } else if (command.equals("d")) {
            addDinner();
        } else if (command.equals("dd")) {
            deleteDinner();
        } else if (command.equals("cd")) {
            checkDinner();
        } else if (command.equals("c")) {
            checkCalories();
        } else if (command.equals("e")) {
            System.out.println(" Good Bye ! Have a nice day !");
        }  else {
            System.out.println("Selection not valid....");
            runTracker();
        }
    }

    //EFFECTS : displays menu options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tb -> Breakfast");
        System.out.println("\tl -> Lunch");
        System.out.println("\td -> Dinner");
        System.out.println("\tcb -> Check Breakfast");
        System.out.println("\tcl -> Check Lunch");
        System.out.println("\tcd -> Check Dinner");
        System.out.println("\tc -> Check Calories");
        System.out.println("\tdb -> Delete Breakfast");
        System.out.println("\tdl -> Delete Lunch");
        System.out.println("\tdd -> Delete Dinner");
        System.out.println("\te -> Exit");
    }

    // MODIFIES: this
    // EFFECTS: adds the food to the breakfast list
    private void addBreakfast() {

        String name;
        System.out.println("Name :");
        name = input.nextLine();
        int carbohydrates;
        System.out.println("Carbohydrates :");
        carbohydrates = input.nextInt();
        int protein;
        System.out.println("Protein :");
        protein = input.nextInt();
        int fats;
        System.out.println("Fats :");
        fats = input.nextInt();

        Food f = new Food(name, carbohydrates, protein, fats);
        meal.addBreakfast(f);

        runTracker();

    }

    // MODIFIES: this
    // EFFECTS: deletes the food from the breakfast list
    private void deleteBreakfast() {

        String name;
        System.out.println(" Name: ");
        name = input.nextLine();

        boolean contains = false;

        Food toBeRemoved = new Food("name", 1, 2, 3);

        for (Food food : meal.getBreakfastList()) {
            if (food.getTitle().equals(name)) {
                contains = true;
                toBeRemoved = food;
            }
        }

        if (!contains) {
            System.out.println("Error: Food entered is not in the list");
        } else {

            meal.deleteBreakfast(toBeRemoved);
        }

        runTracker();

    }

    // EFFECTS: checks the food in the breakfast list
    private void checkBreakfast() {
        if (!meal.getBreakfastList().isEmpty()) {
            for (Food food : meal.getBreakfastList()) {
                System.out.println(" Name : " + food.getTitle() + " Carbohydrates : " + food.getCarbs() + " Protein : "
                        + " Fats :" + food.getFats());
            }
        } else {
            System.out.println("Breakfast list is empty !");
        }
        runTracker();
    }

    // MODIFIES: this
    // EFFECTS: adds the food to the lunch list
    private void addLunch() {

        String name;
        System.out.println("Name :");
        name = input.nextLine();
        int carbohydrates;
        System.out.println("Carbohydrates :");
        carbohydrates = input.nextInt();
        int protein;
        System.out.println("Protein :");
        protein = input.nextInt();
        int fats;
        System.out.println("Fats :");
        fats = input.nextInt();
        Food food = new Food(name, carbohydrates, protein, fats);
        meal.addLunch(food);
        runTracker();
    }

    // MODIFIES: this
    // EFFECTS: deletes the food from the lunch list
    private void deleteLunch() {

        String name;
        System.out.println(" Name: ");
        name = input.nextLine();

        boolean contains = false;

        Food toBeRemoved = new Food("name", 1, 2, 3);

        for (Food food : meal.getLunchList()) {
            if (food.getTitle().equals(name)) {
                contains = true;
                toBeRemoved = food;
            }
        }

        if (!contains) {
            System.out.println("Error: Food entered is not in the list");
        } else {
            meal.deleteLunch(toBeRemoved);
        }
        runTracker();
    }

    // EFFECTS: checks the food in the lunch list
    private void checkLunch() {
        if (!meal.getLunchList().isEmpty()) {
            for (Food food : meal.getLunchList()) {
                System.out.println(" Name : " + food.getTitle() + " Carbohydrates : " + food.getCarbs() + " Protein : "
                        + " Fats :" + food.getFats());
            }
        } else {
            System.out.println("Lunch list is empty !");
        }
        runTracker();
    }


    // MODIFIES: this
    // EFFECTS: adds the food to the dinner list
    private void addDinner() {

        String name;
        System.out.println("Name :");
        name = input.nextLine();
        int carbohydrates;
        System.out.println("Carbohydrates :");
        carbohydrates = input.nextInt();
        int protein;
        System.out.println("Protein :");
        protein = input.nextInt();
        int fats;
        System.out.println("Fats :");
        fats = input.nextInt();
        Food food = new Food(name, carbohydrates, protein, fats);
        meal.addDinner(food);
        runTracker();
    }

    // MODIFIES: this
    // EFFECTS: delete the food from the dinner list
    private void deleteDinner() {

        String name;
        System.out.println(" Name: ");
        name = input.nextLine();

        boolean contains = false;

        Food toBeRemoved = new Food("name", 1, 2, 3);

        for (Food food : meal.getDinnerList()) {
            if (food.getTitle().equals(name)) {
                contains = true;
                toBeRemoved = food;
            }
        }

        if (!contains) {
            System.out.println("Error: Food entered is not in the list");
        } else {
            meal.deleteDinner(toBeRemoved);
        }
        runTracker();
    }

    // EFFECTS: checks the food in the dinner list
    private void checkDinner() {
        if (!meal.getDinnerList().isEmpty()) {
            for (Food food : meal.getDinnerList()) {
                System.out.println(" Name : " + food.getTitle() + " Carbohydrates : " + food.getCarbs() + " Protein : "
                        + " Fats :" + food.getFats());
            }
        } else {
            System.out.println("Dinner list is empty !");
        }
        runTracker();
    }

    // MODIFIES: this
    // EFFECTS: check the cumulative calories from the all meals and total Macros
    private void checkCalories() {
        System.out.println("You ate " + meal.totalDayCalories() + " calories today ! ");
        System.out.println("Total Macros :");
        System.out.println(" Carbohydrates : " + meal.totalDayCarbs());
        System.out.println(" Proteins : " + meal.totalDayProtein());
        System.out.println(" Fats : " + meal.totalDayFats());
        runTracker();
    }

}
