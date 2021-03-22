package mhs_hackathon2021;

public abstract class Meal {

    // field(s)

    private double price;

    // constructor
    Meal() {
        price = 0;
    }

    // constructor overload

    Meal(double price) {
        this.price = price;
    }

    // modifier method
    public void setPrice(double price) {
        this.price = price;
    }

    // accessor method
    public double getPrice() {
        return price;
    }
}

/**
 * Lasagna dish lasagna noodles (half of 500 g package), ground beef (450 g),
 * onion (~123 g), tomato (~123 g), sweet pepper (~119 g), Mozzarella (320 g
 * package)
 */
class Lasagna extends Meal {

    // fields - default units per meal of inventory items

    private double lasagnaNoodles_perMeal = 0.5;
    private double groundBeef_perMeal = 0.450;
    private double onion_perMeal = 0.123;
    private double tomato_perMeal = 0.123;
    private double sweetPepper_perMeal = 0.119;
    private double mozzarella_perMeal = 1;

    // constructor
    Lasagna() {
        super(22.00); // default price = $22.00
    }

    // constructor overload

    Lasagna(double price) {
        super(price);
    }

    // modifier methods
    public void setLasagnaNoodles_perMeal(double unitsPerMeal) {
        lasagnaNoodles_perMeal = unitsPerMeal;
    }

    public void setGroundBeef_perMeal(double unitsPerMeal) {
        groundBeef_perMeal = unitsPerMeal;
    }

    public void setOnion_perMeal(double unitsPerMeal) {
        onion_perMeal = unitsPerMeal;
    }

    public void setTomato_perMeal(double unitsPerMeal) {
        tomato_perMeal = unitsPerMeal;
    }

    public void setSweetPepper_perMeal(double unitsPerMeal) {
        sweetPepper_perMeal = unitsPerMeal;
    }

    public void setMozzarella_perMeal(double unitsPerMeal) {
        mozzarella_perMeal = unitsPerMeal;
    }

    // accessor methods
    public double getLasagnaNoodles_perMeal() {
        return lasagnaNoodles_perMeal;
    }

    public double getGroundBeef_perMeal() {
        return groundBeef_perMeal;
    }

    public double getOnion_perMeal() {
        return onion_perMeal;
    }

    public double getTomato_perMeal() {
        return tomato_perMeal;
    }

    public double getSweetPepper_perMeal() {
        return sweetPepper_perMeal;
    }

    public double getMozzarella_perMeal() {
        return mozzarella_perMeal;
    }
}

/**
 * Spaghetti dish pasta (250 g package), ground beef (450 g), onion (~123 g),
 * tomato (~123 g), garlic (~45 g), Parmesan (50 g)
 */
class Spaghetti extends Meal {

    // fields - default units per meal of inventory items

    private double pasta_perMeal = 1;
    private double groundBeef_perMeal = 0.450;
    private double onion_perMeal = 0.123;
    private double tomato_perMeal = 0.123;
    private double garlic_perMeal = 0.03;
    private double parmesan_perMeal = 0.2;

    // constructor
    Spaghetti() {
        super(25.50); // default price = $25.50
    }

    // constructor overload

    Spaghetti(double price) {
        super(price);
    }

    // modifier methods
    public void setPasta_perMeal(double unitsPerMeal) {
        pasta_perMeal = unitsPerMeal;
    }

    public void setGroundBeef_perMeal(double unitsPerMeal) {
        groundBeef_perMeal = unitsPerMeal;
    }

    public void setOnion_perMeal(double unitsPerMeal) {
        onion_perMeal = unitsPerMeal;
    }

    public void setTomato_perMeal(double unitsPerMeal) {
        tomato_perMeal = unitsPerMeal;
    }

    public void setGarlic_perMeal(double unitsPerMeal) {
        garlic_perMeal = unitsPerMeal;
    }

    public void setParmesan_perMeal(double unitsPerMeal) {
        parmesan_perMeal = unitsPerMeal;
    }

    // accessor methods
    public double getPasta_perMeal() {
        return pasta_perMeal;
    }

    public double getGroundBeef_perMeal() {
        return groundBeef_perMeal;
    }

    public double getOnion_perMeal() {
        return onion_perMeal;
    }

    public double getTomato_perMeal() {
        return tomato_perMeal;
    }

    public double getGarlic_perMeal() {
        return garlic_perMeal;
    }

    public double getParmesan_perMeal() {
        return parmesan_perMeal;
    }
}

// Florentina steak
class FiorentinaSteak extends Meal {

    // fields - default units per meal of inventory items

    private double steak_perMeal = 0.25;
    private double potato_perMeal = 0.180;
    private double garlic_perMeal = 0.03;
    private double grilledVegetables_perMeal = 0.111;

    // constructor
    FiorentinaSteak() {
        super(32.00); // default price = $32.00
    }

    // constructor overload

    FiorentinaSteak(double cost) {
        super(cost);
    }

    // modifier methods
    public void setSteak_perMeal(double unitsPerMeal) {
        steak_perMeal = unitsPerMeal;
    }

    public void setPotato_perMeal(double unitsPerMeal) {
        potato_perMeal = unitsPerMeal;
    }

    public void setGarlic_perMeal(double unitsPerMeal) {
        garlic_perMeal = unitsPerMeal;
    }

    public void setGrilledVegetables_perMeal(double unitsPerMeal) {
        grilledVegetables_perMeal = unitsPerMeal;
    }

    // accessor methdos
    public double getSteak_perMeal() {
        return steak_perMeal;
    }

    public double getPotato_perMeal() {
        return potato_perMeal;
    }

    public double getGarlic_perMeal() {
        return garlic_perMeal;
    }

    public double getGrilledVegetables_perMeal() {
        return grilledVegetables_perMeal;
    }
}
