package ui;

import model.Food;
import model.Meal;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


// Graphic-user interface of TrackerApp
public class GUI implements ActionListener {

    private Meal meal;
    private JPanel panel;
    private JFrame frame;
    private JTextField title;
    private JTextField carbohydrates;
    private JTextField proteins;
    private JTextField fats;
    private JButton back;
    private static final String JSON_STORE = "./data/meal.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public GUI() {

        meal = new Meal();
        panel = new JPanel();
        frame = new JFrame("My Fitness Calculator");
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back = new JButton("Back");
        back.setActionCommand("back");
        back.addActionListener(this);
        button();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        frame.setVisible(true);
    }


    //EFFECTS: creates the jButton for save/load meal
    private void saveAndLoadButton() {
        JButton saveMeal = new JButton("Save Meal");
        JButton loadMeal = new JButton("Load Meal");

        saveMeal.setActionCommand("save");
        saveMeal.addActionListener(this);
        loadMeal.setActionCommand("load");
        loadMeal.addActionListener(this);

        panel.add(saveMeal);
        panel.add(loadMeal);
    }

    //EFFECTS: creates the jButton for check food
    private void checkButton() {
        JButton checkBreakfast = new JButton("Check Breakfast");
        JButton checkLunch = new JButton("Check Lunch");
        JButton checkDinner = new JButton("Check Dinner");

        checkBreakfast.setActionCommand("check Breakfast");
        checkBreakfast.addActionListener(this);
        checkLunch.setActionCommand("check Lunch");
        checkLunch.addActionListener(this);
        checkDinner.setActionCommand("check Dinner");
        checkDinner.addActionListener(this);

        panel.add(checkBreakfast);
        panel.add(checkLunch);
        panel.add(checkDinner);
    }

    //EFFECTS: create the jButton for delete food
    private void deleteButton() {
        JButton deleteBreakfast = new JButton("Delete Breakfast");
        JButton deleteLunch = new JButton("Delete Lunch");
        JButton deleteDinner = new JButton("Delete Dinner");

        deleteBreakfast.setActionCommand("delete Breakfast");
        deleteBreakfast.addActionListener(this);
        deleteLunch.setActionCommand("delete Lunch");
        deleteLunch.addActionListener(this);
        deleteDinner.setActionCommand("delete Dinner");
        deleteDinner.addActionListener(this);

        panel.add(deleteBreakfast);
        panel.add(deleteLunch);
        panel.add(deleteDinner);

    }

    //EFFECTS: creates the jButton for the add food
    private void addButton() {
        JButton addBreakFast = new JButton("Add BreakFast");
        JButton addLunch = new JButton("Add Lunch");
        JButton addDinner = new JButton("Add Dinner");

        addBreakFast.setActionCommand("add Breakfast");
        addBreakFast.addActionListener(this);
        addLunch.setActionCommand("add Lunch");
        addLunch.addActionListener(this);
        addDinner.setActionCommand("add Dinner");
        addDinner.addActionListener(this);

        panel.add(addBreakFast);
        panel.add(addLunch);
        panel.add(addDinner);
    }


    //EFFECT: creates the jButton for the frame
    private void button() {
        addButton();
        deleteButton();
        checkButton();
        saveAndLoadButton();
    }

    //EFFECTS: creates the add breakfast frame and panel
    private void addBreakfastFrame() {
        frame = new JFrame();
        frame.setSize(500, 500);

        panel = new JPanel();

        frameFields();
        frameLabels();

        JButton addBreakfast = new JButton("Add Breakfast");

        addBreakfast.setActionCommand("add breakfast");
        addBreakfast.addActionListener(this);
        addBreakfast.setBounds(100, 200, 200, 100);

        back.setBounds(100, 200, 200, 100);

        panel.add(title);
        panel.add(carbohydrates);
        panel.add(carbohydrates);
        panel.add(addBreakfast);
        panel.add(back);
        panel.setLayout(null);

        frame.add(panel);
        frame.setVisible(true);

    }

    //EFFECTS: creates the add lunch frame and panel
    private void addLunchFrame() {
        frame = new JFrame();
        frame.setSize(500, 500);

        panel = new JPanel();

        frameFields();
        frameLabels();

        JButton addLunch = new JButton("Add Lunch");

        addLunch.setActionCommand("add lunch");
        addLunch.addActionListener(this);
        addLunch.setBounds(100, 200, 200, 100);

        back.setBounds(100, 200, 200, 100);

        panel.add(title);
        panel.add(carbohydrates);
        panel.add(carbohydrates);
        panel.add(addLunch);
        panel.add(back);
        panel.setLayout(null);

        frame.add(panel);
        frame.setVisible(true);

    }

    //EFFECTS: creates the add dinner frame and panel
    private void addDinnerFrame() {
        frame = new JFrame();
        frame.setSize(500, 500);

        panel = new JPanel();

        frameFields();
        frameLabels();

        JButton addDinner = new JButton("Add Dinner");

        addDinner.setActionCommand("add dinner");
        addDinner.addActionListener(this);
        addDinner.setBounds(100, 200, 200, 100);

        back.setBounds(120, 100, 100, 35);

        panel.add(title);
        panel.add(carbohydrates);
        panel.add(carbohydrates);
        panel.add(addDinner);
        panel.add(back);
        panel.setLayout(null);

        frame.add(panel);
        frame.setVisible(true);

    }

    //EFFECTS: creates frame labels
    private void frameLabels() {
        JLabel l1 = new JLabel("Title");
        JLabel l2 = new JLabel("Carbohydrates");
        JLabel l3 = new JLabel("Proteins");
        JLabel l4 = new JLabel("Fats");

        l1.setBounds(50, 10, 100, 35);
        l2.setBounds(50, 10, 100, 35);
        l3.setBounds(50, 10, 100, 35);
        l4.setBounds(50, 10, 100, 35);

        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);

    }

    //EFFECTS: creates frame fields
    private void frameFields() {
        title = new JTextField();
        carbohydrates = new JTextField();
        proteins = new JTextField();
        fats = new JTextField();

        title.setBounds(100, 20, 100, 40);
        carbohydrates.setBounds(100, 20, 100, 40);
        proteins.setBounds(100, 20, 100, 40);
        fats.setBounds(100, 20, 100, 40);
    }


    //EFFECTS: adds breakfast with given carbs, proteins and fats
    private void addBreakfast() {
        int c = Integer.parseInt(carbohydrates.getText());
        int p = Integer.parseInt(proteins.getText());
        int f = Integer.parseInt(fats.getText());

        Food food = new Food(title.getText(), c, p, f);
        meal.addBreakfast(food);

        JOptionPane.showMessageDialog(null, "Breakfast added successfully !!!",
                "??", JOptionPane.PLAIN_MESSAGE);

    }

    //EFFECTS: adds lunch with given carbs, proteins and fats
    private void addLunch() {
        int c = Integer.parseInt(carbohydrates.getText());
        int p = Integer.parseInt(proteins.getText());
        int f = Integer.parseInt(fats.getText());

        Food food = new Food(title.getText(), c, p, f);
        meal.addLunch(food);

        JOptionPane.showMessageDialog(null, "Breakfast added successfully !!!",
                "??", JOptionPane.PLAIN_MESSAGE);


    }

    //EFFECTS: adds dinner with given carbs, proteins and fats
    private void addDinner() {
        int c = Integer.parseInt(carbohydrates.getText());
        int p = Integer.parseInt(proteins.getText());
        int f = Integer.parseInt(fats.getText());

        Food food = new Food(title.getText(), c, p, f);
        meal.addDinner(food);

        JOptionPane.showMessageDialog(null, "Breakfast added successfully !!!",
                "??", JOptionPane.PLAIN_MESSAGE);


    }


    //EFFECTS: creates remove breakfast frame and panel
    @SuppressWarnings({"MethodLength", "checkstyle:SuppressWarnings"})
    public void deleteBreakfastFrame() {
        frame = new JFrame();
        frame.setSize(500, 500);

        panel = new JPanel();

        title = new JTextField();
        carbohydrates = new JTextField();
        proteins = new JTextField();
        fats = new JTextField();
        JLabel label = new JLabel("Title");
        label.setBounds(50, 10, 100, 35);
        title.setBounds(120, 30, 103, 33);

        JButton deleteBreakfast = new JButton("Delete Breakfast");
        deleteBreakfast.setBounds(100, 80, 100, 30);
        back.setBounds(120, 100, 100, 35);
        deleteBreakfast.setActionCommand("delete");
        deleteBreakfast.addActionListener(this);

        panel.add(label);
        panel.add(title);
        panel.add(carbohydrates);
        panel.add(proteins);
        panel.add(fats);
        panel.add(deleteBreakfast);
        panel.add(back);
        panel.setLayout(null);

        frame.add(panel);
        frame.setVisible(true);
    }

    //EFFECTS: creates remove lunch frame and panel
    @SuppressWarnings({"MethodLength", "checkstyle:SuppressWarnings"})
    public void deleteLunchFrame() {
        frame = new JFrame();
        frame.setSize(500, 500);

        panel = new JPanel();

        title = new JTextField();
        carbohydrates = new JTextField();
        proteins = new JTextField();
        fats = new JTextField();
        JLabel label = new JLabel("Title");
        label.setBounds(50, 10, 100, 35);
        title.setBounds(120, 30, 103, 33);

        JButton deleteLunch = new JButton("Delete Lunch");
        deleteLunch.setBounds(100, 80, 100, 30);
        back.setBounds(120, 100, 100, 35);
        deleteLunch.setActionCommand("delete");
        deleteLunch.addActionListener(this);

        panel.add(label);
        panel.add(title);
        panel.add(carbohydrates);
        panel.add(proteins);
        panel.add(fats);
        panel.add(deleteLunch);
        panel.add(back);
        panel.setLayout(null);

        frame.add(panel);
        frame.setVisible(true);
    }

    //EFFECTS: creates remove dinner frame and panel
    @SuppressWarnings({"MethodLength", "checkstyle:SuppressWarnings"})
    public void deleteDinnerFrame() {
        frame = new JFrame();
        frame.setSize(500, 500);

        panel = new JPanel();

        title = new JTextField();
        carbohydrates = new JTextField();
        proteins = new JTextField();
        fats = new JTextField();
        JLabel label = new JLabel("Title");
        label.setBounds(50, 10, 100, 35);
        title.setBounds(120, 30, 103, 33);

        JButton deleteDinner = new JButton("Delete Dinner");
        deleteDinner.setBounds(100, 80, 100, 30);
        back.setBounds(120, 100, 100, 35);
        deleteDinner.setActionCommand("delete");
        deleteDinner.addActionListener(this);

        panel.add(label);
        panel.add(title);
        panel.add(carbohydrates);
        panel.add(proteins);
        panel.add(fats);
        panel.add(deleteDinner);
        panel.add(back);
        panel.setLayout(null);

        frame.add(panel);
        frame.setVisible(true);
    }

    //MODIFIES: meal
    //EFFECTS: delete breakfast food with the given title
    private void deleteBreakfast() {
        if (!meal.containBreakfastFood(title.getText())) {
            JOptionPane.showMessageDialog(null, "Food not in the list", "??",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            for (Food f : meal.getBreakfastList()) {
                if (f.getTitle().equals(title.getText())) {
                    meal.getBreakfastList().remove(f);
                }
            }
            if (!meal.containBreakfastFood(title.getText())) {
                JOptionPane.showMessageDialog(null, "Food deleted", "??",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Couldn't delete", "??",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    //MODIFIES: meal
    //EFFECTS: delete breakfast food with the given title
    private void deleteLunch() {
        if (!meal.containBreakfastFood(title.getText())) {
            JOptionPane.showMessageDialog(null, "Food not in the list", "??",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            for (Food f : meal.getLunchList()) {
                if (f.getTitle().equals(title.getText())) {
                    meal.getBreakfastList().remove(f);
                }
            }
            if (!meal.containLunchFood(title.getText())) {
                JOptionPane.showMessageDialog(null, "Food deleted", "??",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Couldn't delete", "??",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    //MODIFIES: meal
    //EFFECTS: delete dinner food with the given title
    private void deleteDinner() {
        if (!meal.containBreakfastFood(title.getText())) {
            JOptionPane.showMessageDialog(null, "Food not in the list", "??",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            for (Food f : meal.getDinnerList()) {
                if (f.getTitle().equals(title.getText())) {
                    meal.getDinnerList().remove(f);
                }
            }
            if (!meal.containDinnerFood(title.getText())) {
                JOptionPane.showMessageDialog(null, "Food deleted", "??",
                        JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Couldn't delete", "??",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }


    //EFFECTS: creates the check breakfast frame and panel
    public void checkBreakfast() {
        frame = new JFrame();
        panel = new JPanel();
        String str;
        List<String> formatted = new ArrayList<>();
        if (meal.getBreakfastList() != null) {
            for (Food f : meal.getBreakfastList()) {
                str = "Title : " + f.getTitle() + " " + "Carbohydrates : " + f.getCarbs() + "Proteins :"
                        + f.getProtein() + "Fats :" + f.getFats();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        panel.add(j);
        panel.add(BorderLayout.SOUTH, back);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    //EFFECTS: creates the check lunch frame and panel
    public void checkLunch() {
        frame = new JFrame();
        panel = new JPanel();
        String str;
        List<String> formatted = new ArrayList<>();
        if (meal.getLunchList() != null) {
            for (Food f : meal.getLunchList()) {
                str = "Title : " + f.getTitle() + " " + "Carbohydrates : " + f.getCarbs() + "Proteins :"
                        + f.getProtein() + "Fats :" + f.getFats();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        panel.add(j);
        panel.add(BorderLayout.SOUTH, back);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    //EFFECTS: creates the check dinner frame and panel
    public void checkDinner() {
        frame = new JFrame();
        panel = new JPanel();
        String str;
        List<String> formatted = new ArrayList<>();
        if (meal.getDinnerList() != null) {
            for (Food f : meal.getDinnerList()) {
                str = "Title : " + f.getTitle() + " " + "Carbohydrates : " + f.getCarbs() + "Proteins :"
                        + f.getProtein() + "Fats :" + f.getFats();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        panel.add(j);
        panel.add(BorderLayout.SOUTH, back);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    //EFFECTS: save a day's meal
    private void saveMeal() {
        try {
            jsonWriter.open();
            jsonWriter.write(meal);
            jsonWriter.close();

            System.out.println("Saved " + meal + " to " + JSON_STORE);

        } catch (FileNotFoundException e) {

            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }

    //EFFECTS: load a day's meal
    private void loadMeal() {
        try {
            meal = jsonReader.read();

            System.out.println("Loaded " + meal + " from " + JSON_STORE);

        } catch (IOException e) {

            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    @Override

    @SuppressWarnings({"MethodLength", "checkstyle:SuppressWarnings"})
    //EFFECTS: message to all the action listeners
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("add Breakfast")) {
            addBreakfastFrame();
        } else if (e.getActionCommand().equals("add Lunch")) {
            addLunchFrame();
        } else if (e.getActionCommand().equals("add Dinner")) {
            addDinnerFrame();
        } else if (e.getActionCommand().equals("add breakfast")) {
            addBreakfast();
        } else if (e.getActionCommand().equals("add lunch")) {
            addLunch();
        } else if (e.getActionCommand().equals("add dinner")) {
            addDinner();
        } else if (e.getActionCommand().equals("delete Breakfast")) {
            deleteBreakfastFrame();
        } else if (e.getActionCommand().equals("delete Lunch")) {
            deleteLunchFrame();
        } else if (e.getActionCommand().equals("delete Dinner")) {
            deleteDinnerFrame();
        } else if (e.getActionCommand().equals("delete breakfast")) {
            deleteBreakfast();
        } else if (e.getActionCommand().equals("delete lunch")) {
            deleteLunch();
        } else if (e.getActionCommand().equals("delete dinner")) {
            deleteDinner();
        } else if (e.getActionCommand().equals("load")) {
            loadMeal();
        } else if (e.getActionCommand().equals("save")) {
            saveMeal();
        } else if (e.getActionCommand().equals("back")) {
            frame.dispose();
        } else if (e.getActionCommand().equals("check Breakfast")) {
            checkBreakfast();
        } else if (e.getActionCommand().equals("check Lunch")) {
            checkLunch();
        } else if (e.getActionCommand().equals("check Dinner")) {
            checkDinner();
        }
    }

    //EFFECTS: runs the gui
    public static void main(String[] args) {
        new GUI();
    }
}
