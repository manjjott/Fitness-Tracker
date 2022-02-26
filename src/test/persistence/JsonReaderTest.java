package persistence;

import model.Food;
import model.Meal;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Meal m = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyMeal.json");
        try {
            Meal m = reader.read();
            assertEquals(0, m.getBreakfastList().size());
            assertEquals(0, m.getLunchList().size());
            assertEquals(0, m.getDinnerList().size());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralMeal.json");
        try {
            Meal m = reader.read();
            List<Food> bl = m.getBreakfastList();
            assertEquals(1, bl.size());
            checkFood("b",1,1,1,bl.get(0));
            List<Food> ll = m.getLunchList();
            assertEquals(1, ll.size());
            checkFood("l",1,1,1,ll.get(0));
            List<Food> dl = m.getDinnerList();
            assertEquals(1, dl.size());
            checkFood("d",1,1,1,dl.get(0));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
