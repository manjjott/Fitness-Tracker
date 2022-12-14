package model;

import org.json.JSONObject;
import persistence.Writable;

public class Food implements Writable {
    private int carbohydrates;
    private int protein;
    private int fats;
    private String title;

    //REQUIRES: carbohydrates >=0,protein >=0,fats>=0
    //EFFECTS: constructs the food with given carbohydrates (g), protein (g), fats (g) & calories are calculated
    //using the fact 1 g Carbohydrates and protein contains 4 calories while fat contains 9 calories
    public Food(String title, int carbohydrates, int protein, int fats) {
        this.carbohydrates = carbohydrates;
        this.protein = protein;
        this.fats = fats;
        this.title = title;
    }

    //EFFECTS: returns food title
    public String getTitle() {
        return this.title;
    }


    //EFFECTS: returns carbohydrates
    public int getCarbs() {
        return this.carbohydrates;
    }

    //EFFECTS: returns protein
    public int getProtein() {
        return this.protein;
    }

    //EFFECTS: returns fats
    public int getFats() {
        return this.fats;
    }

    //EFFECTS: return total calories
    public int totalCalories() {
        return this.carbohydrates * 4 + this.protein * 4 + this.fats * 4;
    }

    @Override

    //EFFECTS: make the Json object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("carbohydrates", carbohydrates);
        json.put("proteins", protein);
        json.put("fats", fats);
        return json;
    }


}


