package ui;

import model.Food;
import model.Meal;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.JFrame;
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
    private JPanel jpanel;
    private JFrame jframe;
    private JTextField title;
    private JTextField carbohydrates;
    private JTextField proteins;
    private JTextField fats;
    private JButton back;
    private static final String JSON_STORE = "./data/meal.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private ImageIcon imageIcon;


    //EFFECTS: constructs panel, frame and buttons for the GUI
    public GUI() {
        meal = new Meal();
        jpanel = new JPanel();
        jpanel.setBackground(Color.BLACK);
        JLabel background = new JLabel();
        background.setIcon(panelImage());
        background.setBounds(250, 100, 200, 200);
        jpanel.add(background);
        jframe = new JFrame("My Fitness Calculator");
        jframe.add(jpanel);
        jframe.setSize(500, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back = new JButton("Back");
        back.setActionCommand("back");
        back.addActionListener(this);
        button();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        jframe.setVisible(true);
        imageIcon = new ImageIcon("balanced-diet.png");
        Image image = imageIcon.getImage();
        Image img = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(img);


    }

    //EFFECTS: gives the intro image on the introductory panel
    private ImageIcon panelImage() {
        ImageIcon calculator = new ImageIcon("calculator.png");
        Image image1 = calculator.getImage();
        Image img1 = image1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        calculator = new ImageIcon(img1);
        return calculator;
    }


    //EFFECTS: creates the jButton for save/load meal
    private void saveAndLoadButton() {
        JButton saveMeal = new JButton("Save Meal");
        JButton loadMeal = new JButton("Load Meal");

        saveMeal.setBounds(100, 370, 120, 35);
        loadMeal.setBounds(100, 410, 120, 35);
        saveMeal.setBackground(Color.CYAN);
        saveMeal.setOpaque(true);
        loadMeal.setBackground(Color.CYAN);
        loadMeal.setOpaque(true);


        saveMeal.setActionCommand("save");
        saveMeal.addActionListener(this);
        loadMeal.setActionCommand("load");
        loadMeal.addActionListener(this);


        jpanel.add(saveMeal);
        jpanel.add(loadMeal);
        jpanel.setLayout(null);
    }

    //EFFECTS: creates the jButton for check food
    private void checkButton() {
        JButton checkBreakfast = new JButton("Check Breakfast");
        JButton checkLunch = new JButton("Check Lunch");
        JButton checkDinner = new JButton("Check Dinner");


        checkBreakfast.setBounds(100, 250, 120, 35);
        checkLunch.setBounds(100, 290, 120, 35);
        checkDinner.setBounds(100, 330, 120, 35);
        checkBreakfast.setBackground(Color.CYAN);
        checkLunch.setBackground(Color.CYAN);
        checkDinner.setBackground(Color.CYAN);
        checkBreakfast.setOpaque(true);
        checkLunch.setOpaque(true);
        checkDinner.setOpaque(true);

        checkBreakfast.setActionCommand("check Breakfast");
        checkBreakfast.addActionListener(this);
        checkLunch.setActionCommand("check Lunch");
        checkLunch.addActionListener(this);
        checkDinner.setActionCommand("check Dinner");
        checkDinner.addActionListener(this);


        jpanel.add(checkBreakfast);
        jpanel.add(checkLunch);
        jpanel.add(checkDinner);
        jpanel.setLayout(null);
    }

    //EFFECTS: create the jButton for delete food
    private void deleteButton() {
        JButton deleteBreakfast = new JButton("Delete Breakfast");
        JButton deleteLunch = new JButton("Delete Lunch");
        JButton deleteDinner = new JButton("Delete Dinner");

        deleteBreakfast.setBounds(100, 130, 120, 35);
        deleteLunch.setBounds(100, 170, 120, 35);
        deleteDinner.setBounds(100, 210, 120, 35);
        deleteBreakfast.setBackground(Color.CYAN);
        deleteLunch.setBackground(Color.CYAN);
        deleteDinner.setBackground(Color.CYAN);
        deleteBreakfast.setOpaque(true);
        deleteLunch.setOpaque(true);
        deleteDinner.setOpaque(true);

        deleteBreakfast.setActionCommand("delete Breakfast");
        deleteBreakfast.addActionListener(this);
        deleteLunch.setActionCommand("delete Lunch");
        deleteLunch.addActionListener(this);
        deleteDinner.setActionCommand("delete Dinner");
        deleteDinner.addActionListener(this);


        jpanel.add(deleteBreakfast);
        jpanel.add(deleteLunch);
        jpanel.add(deleteDinner);
        jpanel.setLayout(null);

    }

    //EFFECTS: creates the jButton for the add food
    private void addButton() {
        JButton addBreakFast = new JButton("Add BreakFast");
        JButton addLunch = new JButton("Add Lunch");
        JButton addDinner = new JButton("Add Dinner");

        addBreakFast.setBounds(100, 10, 120, 35);
        addLunch.setBounds(100, 50, 120, 35);
        addDinner.setBounds(100, 90, 120, 35);
        addBreakFast.setBackground(Color.CYAN);
        addLunch.setBackground(Color.CYAN);
        addDinner.setBackground(Color.CYAN);
        addBreakFast.setOpaque(true);
        addLunch.setOpaque(true);
        addDinner.setOpaque(true);


        addBreakFast.setActionCommand("add Breakfast");
        addBreakFast.addActionListener(this);
        addLunch.setActionCommand("add Lunch");
        addLunch.addActionListener(this);
        addDinner.setActionCommand("add Dinner");
        addDinner.addActionListener(this);


        jpanel.add(addBreakFast);
        jpanel.add(addLunch);
        jpanel.add(addDinner);
        jpanel.setLayout(null);
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
        jframe = new JFrame();
        jframe.setSize(500, 500);

        jpanel = new JPanel();
        jpanel.setBackground(Color.black);

        frameFields();
        frameLabels();

        JButton addBreakfast = new JButton("Add");

        addBreakfast.setActionCommand("add breakfast");
        addBreakfast.addActionListener(this);
        addBreakfast.setBounds(200, (300 - 40), 100, 35);

        back.setBounds(200, 300, 100, 35);

        jpanel.add(title);
        jpanel.add(carbohydrates);
        jpanel.add(proteins);
        jpanel.add(fats);
        jpanel.add(addBreakfast);
        jpanel.add(back);
        jpanel.setLayout(null);

        jframe.add(jpanel);
        jframe.setVisible(true);

    }

    //EFFECTS: creates the add lunch frame and panel
    private void addLunchFrame() {
        jframe = new JFrame();
        jframe.setSize(500, 500);

        jpanel = new JPanel();
        jpanel.setBackground(Color.black);

        frameFields();
        frameLabels();

        JButton addLunch = new JButton("Add");

        addLunch.setActionCommand("add lunch");
        addLunch.addActionListener(this);
        addLunch.setBounds(200, (300 - 40), 100, 35);

        back.setBounds(200, 300, 100, 35);

        jpanel.add(title);
        jpanel.add(carbohydrates);
        jpanel.add(proteins);
        jpanel.add(fats);
        jpanel.add(addLunch);
        jpanel.add(back);
        jpanel.setLayout(null);

        jframe.add(jpanel);
        jframe.setVisible(true);

    }

    //EFFECTS: creates the add dinner frame and panel
    private void addDinnerFrame() {
        jframe = new JFrame();
        jframe.setSize(500, 500);

        jpanel = new JPanel();
        jpanel.setBackground(Color.black);

        frameFields();
        frameLabels();

        JButton addDinner = new JButton("Add");

        addDinner.setActionCommand("add dinner");
        addDinner.addActionListener(this);
        addDinner.setBounds(200, (300 - 40), 100, 35);

        back.setBounds(200, 300, 100, 35);

        jpanel.add(title);
        jpanel.add(carbohydrates);
        jpanel.add(proteins);
        jpanel.add(fats);
        jpanel.add(addDinner);
        jpanel.add(back);
        jpanel.setLayout(null);

        jframe.add(jpanel);
        jframe.setVisible(true);

    }

    //EFFECTS: creates frame labels
    private void frameLabels() {
        JLabel l1 = new JLabel("Title");
        JLabel l2 = new JLabel("Carbohydrates");
        JLabel l3 = new JLabel("Proteins");
        JLabel l4 = new JLabel("Fats");

        l1.setBounds(50, 10, 100, 35);
        l2.setBounds(50, 50, 100, 35);
        l3.setBounds(50, 90, 100, 35);
        l4.setBounds(50, 130, 100, 35);
        l1.setForeground(Color.CYAN);
        l2.setForeground(Color.CYAN);
        l3.setForeground(Color.CYAN);
        l4.setForeground(Color.CYAN);

        jpanel.add(l1);
        jpanel.add(l2);
        jpanel.add(l3);
        jpanel.add(l4);

    }

    //EFFECTS: creates frame fields
    private void frameFields() {
        title = new JTextField();
        carbohydrates = new JTextField();
        proteins = new JTextField();
        fats = new JTextField();

        title.setBounds(150, 10, 100, 35);
        carbohydrates.setBounds(150, 50, 100, 35);
        proteins.setBounds(150, 90, 100, 35);
        fats.setBounds(150, 130, 100, 35);
    }


    //EFFECTS: adds breakfast with given carbs, proteins and fats
    private void addBreakfast() {
        int c = Integer.parseInt(carbohydrates.getText());
        int p = Integer.parseInt(proteins.getText());
        int f = Integer.parseInt(fats.getText());

        Food food = new Food(title.getText(), c, p, f);
        meal.addBreakfast(food);

        JOptionPane.showMessageDialog(null, "Breakfast added successfully !!!",
                "Message", JOptionPane.PLAIN_MESSAGE, imageIcon);

    }

    //EFFECTS: adds lunch with given carbs, proteins and fats
    private void addLunch() {
        int c = Integer.parseInt(carbohydrates.getText());
        int p = Integer.parseInt(proteins.getText());
        int f = Integer.parseInt(fats.getText());

        Food food = new Food(title.getText(), c, p, f);
        meal.addLunch(food);

        JOptionPane.showMessageDialog(null, "Breakfast added successfully !!!",
                "Message", JOptionPane.PLAIN_MESSAGE, imageIcon);


    }

    //EFFECTS: adds dinner with given carbs, proteins and fats
    private void addDinner() {
        int c = Integer.parseInt(carbohydrates.getText());
        int p = Integer.parseInt(proteins.getText());
        int f = Integer.parseInt(fats.getText());

        Food food = new Food(title.getText(), c, p, f);
        meal.addDinner(food);

        JOptionPane.showMessageDialog(null, "Breakfast added successfully !!!",
                "Message", JOptionPane.PLAIN_MESSAGE, imageIcon);


    }


    //EFFECTS: creates remove breakfast frame and panel
    public void deleteBreakfastFrame() {
        initializeFrame();

        JButton deleteBreakfast = new JButton("Delete");
        deleteBreakfast.setBounds(200, (300 - 40), 100, 35);
        back.setBounds(200, 300, 100, 35);
        deleteBreakfast.setActionCommand("delete breakfast");
        deleteBreakfast.addActionListener(this);


        jpanel.add(title);
        jpanel.add(carbohydrates);
        jpanel.add(proteins);
        jpanel.add(fats);
        jpanel.add(deleteBreakfast);
        jpanel.add(back);
        jpanel.setLayout(null);

        jframe.add(jpanel);
        jframe.setVisible(true);
    }

    //EFFECTS: creates remove lunch frame and panel
    public void deleteLunchFrame() {
        initializeFrame();

        JButton deleteLunch = new JButton("Delete");
        deleteLunch.setBounds(200, (300 - 40), 100, 35);
        back.setBounds(200, 300, 100, 35);
        deleteLunch.setActionCommand("delete lunch");
        deleteLunch.addActionListener(this);

        jpanel.add(title);
        jpanel.add(carbohydrates);
        jpanel.add(proteins);
        jpanel.add(fats);
        jpanel.add(deleteLunch);
        jpanel.add(back);
        jpanel.setLayout(null);

        jframe.add(jpanel);
        jframe.setVisible(true);
    }


    //EFFECTS: creates remove dinner frame and panel
    public void deleteDinnerFrame() {
        initializeFrame();

        JButton deleteDinner = new JButton("Delete");
        deleteDinner.setBounds(200, (300 - 40), 100, 35);
        back.setBounds(200, 300, 100, 35);
        deleteDinner.setActionCommand("delete dinner");
        deleteDinner.addActionListener(this);

        jpanel.add(title);
        jpanel.add(carbohydrates);
        jpanel.add(proteins);
        jpanel.add(fats);
        jpanel.add(deleteDinner);
        jpanel.add(back);
        jpanel.setLayout(null);

        jframe.add(jpanel);
        jframe.setVisible(true);
    }


    //EFFECTS: initialize delete frame/s
    private void initializeFrame() {

        jframe = new JFrame();
        jframe.setSize(500, 500);

        jpanel = new JPanel();
        jpanel.setBackground(Color.black);

        title = new JTextField();
        carbohydrates = new JTextField();
        proteins = new JTextField();
        fats = new JTextField();
        JLabel label = new JLabel("Title");
        label.setBounds(100, 10, 100, 35);
        title.setBounds(130, 10, 100, 35);
        label.setForeground(Color.CYAN);

        jpanel.add(label);


    }

    //MODIFIES: meal
    //EFFECTS: delete breakfast food with the given title
    private void deleteBreakfast() {
        if (!meal.containBreakfastFood(title.getText())) {
            JOptionPane.showMessageDialog(null, "Food not in the list", "Message",
                    JOptionPane.PLAIN_MESSAGE, imageIcon);
        } else {
            for (Food f : meal.getBreakfastList()) {
                if (f.getTitle().equals(title.getText())) {
                    meal.getBreakfastList().remove(f);
                    JOptionPane.showMessageDialog(null, "Food deleted", "Message",
                            JOptionPane.PLAIN_MESSAGE, imageIcon);
                }
            }

        }
    }

    //MODIFIES: meal
    //EFFECTS: delete breakfast food with the given title
    private void deleteLunch() {
        if (!meal.containLunchFood(title.getText())) {
            JOptionPane.showMessageDialog(null, "Food not in the list", "Message",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            for (Food f : meal.getLunchList()) {
                if (f.getTitle().equals(title.getText())) {
                    meal.getLunchList().remove(f);
                    JOptionPane.showMessageDialog(null, "Food deleted", "Message",
                            JOptionPane.PLAIN_MESSAGE, imageIcon);
                }
            }

        }
    }

    //MODIFIES: meal
    //EFFECTS: delete dinner food with the given title
    private void deleteDinner() {
        if (!meal.containDinnerFood(title.getText())) {
            JOptionPane.showMessageDialog(null, "Food not in the list !!", "Message",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            for (Food f : meal.getDinnerList()) {
                if (f.getTitle().equals(title.getText())) {
                    meal.getDinnerList().remove(f);
                    JOptionPane.showMessageDialog(null, "Food deleted !!", "Message",
                            JOptionPane.PLAIN_MESSAGE, imageIcon);
                }
            }

        }
    }


    //EFFECTS: creates the check breakfast frame and panel
    public void checkBreakfast() {
        jframe = new JFrame();
        jpanel = new JPanel();
        jpanel.setBackground(Color.black);
        String str;
        List<String> formatted = new ArrayList<>();
        if (meal.getBreakfastList() != null) {
            for (Food f : meal.getBreakfastList()) {
                str = "Title : " + f.getTitle() + " " + " Carbohydrates : " + f.getCarbs() + " Proteins : "
                        + f.getProtein() + " Fats : " + f.getFats();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        jpanel.add(j);
        jpanel.add(BorderLayout.SOUTH, back);
        jframe.add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
    }


    //EFFECTS: creates the check lunch frame and panel
    public void checkLunch() {
        jframe = new JFrame();
        jpanel = new JPanel();
        jpanel.setBackground(Color.black);
        String str;
        List<String> formatted = new ArrayList<>();
        if (meal.getLunchList() != null) {
            for (Food f : meal.getLunchList()) {
                str = "Title : " + f.getTitle() + " Carbohydrates : " + f.getCarbs() + " Proteins : "
                        + f.getProtein() + " Fats : " + f.getFats();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        jpanel.add(j);
        jpanel.add(BorderLayout.SOUTH, back);
        jframe.add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
    }


    //EFFECTS: creates the check dinner frame and panel
    public void checkDinner() {
        jframe = new JFrame();
        jpanel = new JPanel();
        jpanel.setBackground(Color.black);
        String str;
        List<String> formatted = new ArrayList<>();
        if (meal.getDinnerList() != null) {
            for (Food f : meal.getDinnerList()) {
                str = "Title : " + f.getTitle() + " " + " Carbohydrates : " + f.getCarbs() + "Proteins :"
                        + f.getProtein() + "Fats :" + f.getFats();
                formatted.add(str);
            }
        }

        JList<Object> j = new JList<>(formatted.toArray());
        jpanel.add(j);
        jpanel.add(BorderLayout.SOUTH, back);
        jframe.add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
    }

    //EFFECTS: save a day's meal
    private void saveMeal() {
        try {
            jsonWriter.open();
            jsonWriter.write(meal);
            jsonWriter.close();

            System.out.println(" Saved " + meal + " to " + JSON_STORE);

        } catch (FileNotFoundException e) {

            System.out.println(" Unable to write to file: " + JSON_STORE);
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
        } else {
            actionPerformedContinued(e);
        }
    }

    //EFFECTS: actionPerformed function continued/message to all the action listeners
    private void actionPerformedContinued(ActionEvent e) {
        if (e.getActionCommand().equals("delete lunch")) {
            deleteLunch();
        } else if (e.getActionCommand().equals("delete dinner")) {
            deleteDinner();
        } else if (e.getActionCommand().equals("load")) {
            loadMeal();
        } else if (e.getActionCommand().equals("save")) {
            saveMeal();
        } else if (e.getActionCommand().equals("back")) {
            jframe.dispose();
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
