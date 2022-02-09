package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MealTest {
    private Meal meal;
    private Food f1;
    private Food f2;
    private Food f3;


    @BeforeEach

    public void runBefore() {
        meal = new Meal();
        f1 = new Food("Salted Chicken Breast",20,12,13);
        f2 = new Food("McDonald's Junior Meal",10,42,21);
        f3 = new Food("French Egg Omelette",12,32,9);
    }

    @Test
    public void testAddBreakfast() {
        meal.addBreakfast(f1);
        assertEquals(1,meal.breakfastSize());
        meal.addBreakfast(f2);
        assertEquals(2,meal.breakfastSize());
        meal.addBreakfast(f3);
        assertEquals(3,meal.breakfastSize());
    }

    @Test
    public void testAddLunch() {
        meal.addLunch(f1);
        assertEquals(1,meal.lunchSize());
        meal.addLunch(f2);
        assertEquals(2,meal.lunchSize());
        meal.addLunch(f3);
        assertEquals(3,meal.lunchSize());
    }

    @Test
    public void testAddDinner() {
        meal.addDinner(f1);
        assertEquals(1,meal.dinnerSize());
        meal.addDinner(f2);
        assertEquals(2,meal.dinnerSize());
        meal.addDinner(f3);
        assertEquals(3,meal.dinnerSize());
    }

    @Test
    public void testDeleteBreakfast() {
        assertEquals(0, meal.breakfastSize());
        meal.addBreakfast(f1);
        meal.addBreakfast(f2);
        assertEquals(2,meal.breakfastSize());
        meal.deleteBreakfast(f1);
        assertEquals(1,meal.breakfastSize());
    }


    @Test
    public void testDeleteLunch() {
        assertEquals(0, meal.lunchSize());
        meal.addLunch(f1);
        meal.addLunch(f2);
        assertEquals(2,meal.lunchSize());
        meal.deleteLunch(f1);
        meal.addBreakfast(f1);
        assertEquals(1,meal.lunchSize());
    }

    @Test
    public void testDeleteDinner() {
        assertEquals(0, meal.dinnerSize());
        meal.addDinner(f1);
        meal.addDinner(f2);

        assertEquals(2,meal.dinnerSize());

        meal.deleteDinner(f1);
        meal.addBreakfast(f1);
        assertEquals(1,meal.dinnerSize());
    }

    @Test

    public void testTotalDayCalories() {
        meal.addBreakfast(f1);
        meal.addLunch(f1);
        meal.addDinner(f1);

        assertEquals(1,meal.breakfastSize());
        assertEquals(1,meal.lunchSize());
        assertEquals(1,meal.dinnerSize());
        assertEquals(540, meal.totalDayCalories());

        meal.addLunch(f2);
        meal.addDinner(f3);
        assertEquals(2,meal.lunchSize());
        assertEquals(2,meal.dinnerSize());
        assertEquals(1044, meal.totalDayCalories());

    }

    @Test

    public void testTotalDayCarbs() {
        meal.addBreakfast(f1);
        meal.addLunch(f2);
        meal.addDinner(f3);

        assertEquals(1,meal.breakfastSize());
        assertEquals(1,meal.lunchSize());
        assertEquals(1,meal.dinnerSize());
        assertEquals(42,meal.totalDayCarbs());

        meal.addLunch(f3);
        assertEquals(2,meal.lunchSize());

        assertEquals(54,meal.totalDayCarbs());

    }

    @Test

    public void testTotalDayProtein() {
        meal.addBreakfast(f1);
        meal.addLunch(f2);
        meal.addDinner(f3);

        assertEquals(1,meal.breakfastSize());
        assertEquals(1,meal.lunchSize());
        assertEquals(1,meal.dinnerSize());
        assertEquals(86,meal.totalDayProtein());

        meal.addLunch(f3);
        assertEquals(2,meal.lunchSize());

        assertEquals(118,meal.totalDayProtein());

    }

    @Test

    public void testTotalDayFats() {
        meal.addBreakfast(f1);
        meal.addLunch(f2);
        meal.addDinner(f3);

        assertEquals(1,meal.breakfastSize());
        assertEquals(1,meal.lunchSize());
        assertEquals(1,meal.dinnerSize());
        assertEquals(43,meal.totalDayFats());

        meal.addLunch(f3);
        assertEquals(2,meal.lunchSize());

        assertEquals(52,meal.totalDayFats());
    }

}
