package model;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private List<Food> breakfast;
    private List<Food> lunch;
    private List<Food> dinner;


    //EFFECT: constructs a day's meal; with breakfast , lunch and dinner lists
    public Meal() {

        breakfast = new ArrayList<>();
        lunch = new ArrayList<>();
        dinner = new ArrayList<>();


    }

    //MODIFIES: this
    //EFFECTS: add the given food in the List<Food> breakfast;
    public void addBreakfast(Food food) {
        breakfast.add(food);

    }

    //MODIFIES: this
    //EFFECTS: add the given food in the List<Food> lunch;
    public void addLunch(Food food) {
        lunch.add(food);
    }

    //MODIFIES: this
    //EFFECTS: add the given food in the List<Food> dinner
    public void addDinner(Food food) {
        dinner.add(food);
    }

    //MODIFIES: this
    //EFFECTS: delete the given food from the breakfast
    public void deleteBreakfast(Food food) {
        breakfast.remove(food);
    }

    //MODIFIES: this
    //EFFECTS: delete the given food from the lunch
    public void deleteLunch(Food food) {
        lunch.remove(food);

    }

    //MODIFIES: this
    //EFFECTS: delete the given food from the dinner
    public void deleteDinner(Food food) {
        dinner.remove(food);
    }

    //EFFECTS: return the total calories consumed in the day combined from breakfast + lunch + dinner
    public int totalDayCalories() {

        int b = 0;
        int l = 0;
        int d = 0;

        for (Food f : breakfast) {
            b = b + f.totalCalories();
        }
        for (Food f : lunch) {
            l = l + f.totalCalories();
        }
        for (Food f : dinner) {
            d = d + f.totalCalories();
        }

        return b + l + d;
    }

    //MODIFIES: this
    //EFFECTS: returns total carbohydrates as of the day/meal
    public int totalDayCarbs() {
        int b = 0;
        int l = 0;
        int d = 0;

        for (Food f : breakfast) {
            b = b + f.getCarbs();
        }
        for (Food f : lunch) {
            l = l + f.getCarbs();
        }
        for (Food f : dinner) {
            d = d + f.getCarbs();
        }

        return b + l + d;
    }

    //MODIFIES: this
    //EFFECTS: returns total protein as of the day/meal
    public int totalDayProtein() {
        int b = 0;
        int l = 0;
        int d = 0;

        for (Food f : breakfast) {
            b = b + f.getProtein();
        }
        for (Food f : lunch) {
            l = l + f.getProtein();
        }
        for (Food f : dinner) {
            d = d + f.getProtein();
        }

        return b + l + d;
    }

    //MODIFIES: this
    //EFFECTS: returns total fats as of the day/meal
    public int totalDayFats() {
        int b = 0;
        int l = 0;
        int d = 0;

        for (Food f : breakfast) {
            b = b + f.getFats();
        }
        for (Food f : lunch) {
            l = l + f.getFats();
        }
        for (Food f : dinner) {
            d = d + f.getFats();
        }

        return b + l + d;
    }

    //EFFECTS: return size of List<Food> breakfast
    public int breakfastSize() {
        return breakfast.size();
    }

    //EFFECTS: return size of List<Food> lunch
    public int lunchSize() {
        return lunch.size();
    }

    //EFFECTS: return size of List<Food> dinner
    public int dinnerSize() {
        return dinner.size();
    }

    //EFFECTS: returns the list of breakfast
    public List<Food> getBreakfastList() {
        return breakfast;
    }

    //EFFECTS: returns the list of lunch
    public List<Food> getLunchList() {
        return lunch;
    }

    //EFFECTS: returns the list of dinner
    public List<Food> getDinnerList() {
        return dinner;
    }


}
