package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodTest {

    private Food f1;
    private Food f2;
    private Food f3;


    @BeforeEach

    public void runBefore() {
        f1 = new Food("Chicken Breast",20,12,13);
        f2 = new Food("McDonald's Junior Meal",10,42,21);
        f3 = new Food("French Egg Omelette",12,32,9);
    }

    @Test

    public void testTotalCalories() {
        assertEquals(180, f1.totalCalories());
        assertEquals(292,f2.totalCalories());
        assertEquals(212,f3.totalCalories());
    }

    @Test

    public void testTotalMacros() {
        assertEquals(45,f1.totalMacros());
        assertEquals(73, f2.totalMacros());
        assertEquals(53, f3.totalMacros());
    }




}
