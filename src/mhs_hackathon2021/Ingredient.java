package mhs_hackathon2021;

public abstract class Ingredient {

    // fields

    double cost; // cost per unit
    String name; // name of each object
    String unit; // quantity unit of each object

    // constructor
    Ingredient() {
        cost = 0;
        name = "";
        unit = "";
    }

    // constructor overload

    Ingredient(double cost) {
        this.cost = cost;
        name = "";
        unit = "";
    }

    // modifier method
    public void setCost(double cost) {
        this.cost = cost;
    }

    // accessor methods
    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
}

// Lasagna noodles - unit: 500 g
class LasagnaNoodles extends Ingredient {

    // constructor

    LasagnaNoodles() {
        super(1.67); // default cost = $1.67 / package
        name = "Lasagna Noodles";
        unit = "500 g";
    }

    // constructor overload

    LasagnaNoodles(double cost) {
        super(cost);
        name = "Lasagna Noodles";
        unit = "500 g";
    }

    public String toString() {
        return "Lasagna Noodles      Unit: 500 g package      Cost: $" + super.getCost() + " / package";
    }
}

// Onion - unit: 1 kg
class Onion extends Ingredient {

    // constructor

    Onion() {
        super(1.28); // default cost = $1.28 / kg
        name = "Onion";
        unit = "1 kg";
    }

    // constructor overload

    Onion(double cost) {
        super(cost);
        name = "Onion";
        unit = "1 kg";
    }

    public String toString() {
        return "Onion      Unit: 1 kg      Cost: $" + super.getCost() + " / kg";
    }
}

// Tomato - unit = 1 kg
class Tomato extends Ingredient {

    // constructor

    Tomato() {
        super(4.57); // default cost = $4.57 / kg
        name = "Tomato";
        unit = "1 kg";
    }

    // constructor overload

    Tomato(double cost) {
        super(cost);
        name = "Tomato";
        unit = "1 kg";
    }

    public String toString() {
        return "Tomato      Unit: 1 kg      Cost: $" + super.getCost() + " / kg";
    }
}

// Pasta - unit: 400 g
class Pasta extends Ingredient {

    // constructor

    Pasta() {
        super(1.97); // default cost = $1.97
        name = "Pasta";
        unit = "1 kg";
    }

    // constructor overload

    Pasta(double cost) {
        super(cost);
        name = "Pasta";
        unit = "1 kg";
    }

    public String toString() {
        return "Pasta      Unit: 450 g pacakge      Cost: $" + super.getCost() + " / package";
    }
}

// Potato - unit: 1 kg
class Potato extends Ingredient {

    // constructor

    Potato() {
        super(1.01); // default cost = $1.01 / kg
        name = "Potato";
        unit = "1 kg";
    }

    // constructor overload

    Potato(double cost) {
        super(cost);
        name = "Potato";
        unit = "1 kg";
    }

    public String toString() {
        return "Potato      Unit: 1 kg      Cost: $" + super.getCost() + " / kg";
    }
}

// Ground beef - unit = 1 kg
class GroundBeef extends Ingredient {

    // constructor

    GroundBeef() {
        super(11.38); // default cost = $11.38 / kg
        name = "Ground Beef";
        unit = "1 kg";
    }

    // constructor overload

    GroundBeef(double cost) {
        super(cost);
        name = "Ground Beef";
        unit = "1 kg";
    }

    public String toString() {
        return "Ground Beef      Unit: 1 kg      Cost: $" + super.getCost() + " / kg";
    }
}

// Sweet pepper - unit = 1 kg
class SweetPepper extends Ingredient {

    // constructor

    SweetPepper() {
        super(3.77); // default cost = $3.77 / kg
        name = "Sweet Pepper";
        unit = "1 kg";
    }

    // constructor overload

    SweetPepper(double cost) {
        super(cost);
        name = "Sweet Pepper";
        unit = "1 kg";
    }

    public String toString() {
        return "Sweet Pepper      Unit: 1 kg      Cost: $" + super.getCost() + " / kg";
    }
}

// Parmesan - unit: 250 g
class Parmesan extends Ingredient {

    // constructor

    Parmesan() {
        super(4.99); // default cost = $4.99 / package
        name = "Parmesan";
        unit = "250 g";
    }

    // constructor overload

    Parmesan(double cost) {
        super(cost);
        name = "Parmesan";
        unit = "250 g";
    }

    public String toString() {
        return "Parmesan      Unit: 250 g package      Cost: $" + super.getCost() + " / package";
    }
}

// Mozzarella - unit = 320 g
class Mozzarella extends Ingredient {

    // constructor

    Mozzarella() {
        super(5.00); // default cost = $5.00 / package
        name = "Mozzarella";
        unit = "320 g";
    }

    // constructor overload

    Mozzarella(double cost) {
        super(cost);
        name = "Mozzarella";
        unit = "320 g";
    }

    public String toString() {
        return "Mozzarella      Unit: 320 g package      Cost: $" + super.getCost() + " / package";
    }
}

// Garlic - unit = 1 kg
class Garlic extends Ingredient {

    // constructor

    Garlic() {
        super(3.51); // default cost = $3.51 / kg
        name = "Garlic";
        unit = "1 kg";
    }

    // constructor overload

    Garlic(double cost) {
        super(cost);
        name = "Garlic";
        unit = "1 kg";
    }

    public String toString() {
        return "Sweet Pepper      Unit: 1 kg      Cost: $" + super.getCost() + " / kg";
    }
}

// Steak - unit = 1 kg
class Steak extends Ingredient {

    // constructor

    Steak() {
        super(22.30); // default cost = $22.30 / kg
        name = "Steak";
        unit = "1 kg";
    }

    Steak(double cost) {
        super(cost);
        name = "Steak";
        unit = "1 kg";
    }

    public String toString() {
        return "Steak      Unit: 1 kg      Cost: $" + super.getCost() + " / kg";
    }
}

// Grilled Vegetables - unit = 900 g package
class GrilledVegetables extends Ingredient {

    // constructor

    GrilledVegetables() {
        super(14.99); // default cost = $14.99 / package
        name = "Grilled Vegetables";
        unit = "900 g";
    }

    // constructor overload

    GrilledVegetables(double cost) {
        super(cost);
        name = "Grilled Vegetables";
        unit = "900 g";
    }

    public String toString() {
        return "Grilled Vegetables      Unit: 900 g package      Cost: $" + super.getCost() + " / package";
    }
}
