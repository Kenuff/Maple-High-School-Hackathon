package mhs_hackathon2021;

public class Inventory {

    double balance, expenses;
    // quantity of inventory items per unit
    double lasagnaNoodles, onion, tomato, pasta, potato, groundBeef, sweetPepper, parmesan, mozzarella, garlic, steak, grilledVegetables;
    // ingredients kept following the customer survey
    String[] ingredientList = {"Lasagna Noodles", "Pasta", "Mozzarella", "Parmesan", "Tomato", "Onion",
        "Potato", "Sweet Pepper", "Garlic", "Grilled Vegetables", "Ground Beef", "Steak"};
    String[] menuItems = {"Lasagna", "Spaghetti", "Fiorentina Steak"};

    // constructor
    Inventory() {
        balance = 0;
        expenses = 0;
        lasagnaNoodles = 0;
        onion = 0;
        tomato = 0;
        pasta = 0;
        potato = 0;
        groundBeef = 0;
        sweetPepper = 0;
        parmesan = 0;
        mozzarella = 0;
        parmesan = 0;
        garlic = 0;
        steak = 0;
        grilledVegetables = 0;
    }

    // modifier methods
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void updateBalance(double amount) {
        balance += amount;
    }

    public void updateExpenses(double amount) {
        expenses += amount;
    }

    public void setLasagnaNoodles(double countNo) {
        // unit = 500 g
        lasagnaNoodles = countNo;
    }

    public void setOnion(double countNo) {
        // unit = 1 kg
        onion = countNo;
    }

    public void setTomato(double countNo) {
        // unit = 1 kg
        tomato = countNo;
    }

    public void setPasta(double countNo) {
        pasta = countNo;
    }

    public void setPotato(double countNo) {
        potato = countNo;
    }

    public void setGroundBeef(double countNo) {
        // unit = 1 kg
        groundBeef = countNo;
    }

    public void setSweetPepper(double countNo) {
        // unit = 1 kg
        sweetPepper = countNo;
    }

    public void setParmesan(double countNo) {
        parmesan = countNo;
    }

    public void setMozzarella(double countNo) {
        // unit = 320 g
        mozzarella = countNo;
    }

    public void setGarlic(double countNo) {
        // unit = 1 kg
        garlic = countNo;
    }

    public void setSteak(double countNo) {
        // unit = 1 kg
        steak = countNo;
    }

    public void setGrilledVegetables(double countNo) {
        // unit = 900 g
        grilledVegetables = countNo;
    }

    public void updateQuantities(int index, double countNo) {
        switch (index) {
            case 0:
                lasagnaNoodles += countNo;
                break;
            case 1:
                pasta += countNo;
                break;
            case 2:
                mozzarella += countNo;
                break;
            case 3:
                parmesan += countNo;
                break;
            case 4:
                tomato += countNo;
                break;
            case 5:
                onion += countNo;
                break;
            case 6:
                potato += countNo;
                break;
            case 7:
                sweetPepper += countNo;
                break;
            case 8:
                garlic += countNo;
                break;
            case 9:
                grilledVegetables += countNo;
                break;
            case 10:
                groundBeef += countNo;
                break;
            case 11:
                steak += countNo;
        }
    }

    public void setIngredients(String[] ingredients_survey) {
        ingredientList = ingredients_survey;
    }

    public void setMenuItems(String[] meals_survey) {
        menuItems = meals_survey;
    }

    // accessor methods
    public double getBalance() {
        return balance;
    }

    public double getExpenses() {
        return expenses;
    }

    public double getLasagnaNoodles() {
        return lasagnaNoodles;
    }

    public double getOnion() {
        return onion;
    }

    public double getTomato() {
        return tomato;
    }

    public double getPasta() {
        return pasta;
    }

    public double getPotato() {
        return potato;
    }

    public double getGroundBeef() {
        return groundBeef;
    }

    public double getSweetPepper() {
        return sweetPepper;
    }

    public double getParmesan() {
        return parmesan;
    }

    public double getMozzarella() {
        return mozzarella;
    }

    public double getGarlic() {
        return garlic;
    }

    public double getSteak() {
        return steak;
    }

    public double getGrilledVegetables() {
        return grilledVegetables;
    }

    public double[] getQuantities() {
        double[] quantities = {lasagnaNoodles, pasta, mozzarella, parmesan, tomato, onion, potato,
            sweetPepper, garlic, grilledVegetables, groundBeef, steak};

        return quantities;
    }

    public String[] getIngredients() {
        return ingredientList;
    }

    public String[] getMenuItems() {
        return menuItems;
    }
}
