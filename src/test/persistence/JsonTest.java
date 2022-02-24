package persistence;


import model.Food;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkFood(String title, int carbohydrates, int proteins,int fats, Food food) {
        assertEquals(title, food.getTitle());
        assertEquals(carbohydrates, food.getCarbs());
        assertEquals(proteins, food.getProtein());
        assertEquals(fats, food.getFats());

    }

}
