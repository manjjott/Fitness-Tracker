package persistence;

import model.Food;
import model.Meal;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    // Represents a reader that reads meal from JSON data stored in file
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Meal read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMeal(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses meal from JSON object and returns it
    private Meal parseMeal(JSONObject jsonObject) {
        Meal m = new Meal();
        addFoods(m, jsonObject);
        return m;
    }

    // MODIFIES: m
    // EFFECTS: parses food from JSON object and adds them to meal
    private void addFoods(Meal m, JSONObject jsonObject) {
        JSONArray jsonArrayOne = jsonObject.getJSONArray("breakfast");
        JSONArray jsonArrayTwo = jsonObject.getJSONArray("lunch");
        JSONArray jsonArrayThree = jsonObject.getJSONArray("dinner");
        for (Object json : jsonArrayOne) {
            JSONObject nextFood = (JSONObject) json;
            addFoodBreakfast(m, nextFood);
        }

        for (Object json : jsonArrayTwo) {
            JSONObject nextFood = (JSONObject) json;
            addFoodLunch(m, nextFood);
        }

        for (Object json : jsonArrayThree) {
            JSONObject nextFood = (JSONObject) json;
            addFooDinner(m, nextFood);
        }

    }

    // MODIFIES: m
    // EFFECTS: parses food from JSON object and adds it to meal
    private void addFoodBreakfast(Meal m, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        int carbohydrates = jsonObject.getInt("carbohydrates");
        int proteins = jsonObject.getInt("proteins");
        int fats = jsonObject.getInt("fats");

        Food f = new Food(title, carbohydrates, proteins, fats);
        m.addBreakfast(f);

    }

    // MODIFIES: m
    // EFFECTS: parses food from JSON object and adds it to meal
    private void addFoodLunch(Meal m, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        int carbohydrates = jsonObject.getInt("carbohydrates");
        int proteins = jsonObject.getInt("proteins");
        int fats = jsonObject.getInt("fats");

        Food f = new Food(title, carbohydrates, proteins, fats);
        m.addLunch(f);

    }

    // MODIFIES: m
    // EFFECTS: parses food from JSON object and adds it to meal
    private void addFooDinner(Meal m, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        int carbohydrates = jsonObject.getInt("carbohydrates");
        int proteins = jsonObject.getInt("proteins");
        int fats = jsonObject.getInt("fats");

        Food f = new Food(title, carbohydrates, proteins, fats);
        m.addDinner(f);

    }
}



