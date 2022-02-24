package persistence;

import model.Food;
import model.Meal;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            Meal m = new Meal();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Meal m = new Meal();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(m);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            m = reader.read();
            assertEquals(0, m.getBreakfastList().size());
            assertEquals(0, m.getLunchList().size());
            assertEquals(0, m.getDinnerList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Meal m = new Meal();
            m.addBreakfast(new Food("b", 1,1,1));
            m.addLunch(new Food("l",1,1,1));
            m.addDinner(new Food("d",1,1,1));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(m);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            m = reader.read();
            List<Food> breakfastList = m.getBreakfastList();
            assertEquals(1, m.breakfastSize());
            checkFood("b", 1,1,1, breakfastList.get(0));
            List<Food> lunchList = m.getLunchList();
            assertEquals(1, m.lunchSize());
            checkFood("l", 1,1,1, lunchList.get(0));
            List<Food> dinnerList = m.getDinnerList();
            assertEquals(1, m.dinnerSize());
            checkFood("d", 1,1,1, dinnerList.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
