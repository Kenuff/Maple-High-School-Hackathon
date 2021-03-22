package mhs_hackathon2021;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Computer Science Independent Project Maple High School Hackathon December
 * 2020 - January 2021
 * @authors: Barbod Habibi & Yasmyn Safari
 */

/**
 * List of inventory items: 1. Lasagna Noodles 2. Pasta 3. Mozzarella 4.
 * Parmesan 5. Tomato 6. Onion 7. Potato 8. Sweet Pepper 9. Garlic 10. Grilled
 * Vegetables 11. Ground Beef 12. Steak
 *
 * List of menu items: 1. Lasagna 2. Spaghetti 3. Fiorentina Steak
 */
public class ClientCode {

    public static int numberOfDishes = 3;

    public static void main(String[] args) {
        // declaration
        Random rand = new Random();
        Inventory inventory = new Inventory();
        Meal[] meals = new Meal[3];
        Ingredient[] ingredients = new Ingredient[12];
        Scanner input = new Scanner(System.in);
        String loanOrSubsidy = "";
        double startingBalance;
        int choice;
        boolean done = false;

        // data obtainment from the user
        System.out.println("Enter the starting balance: ");
        startingBalance = input.nextDouble();
        inventory.setBalance(startingBalance);

        obtainIngredients(inventory, ingredients); // cost of each inventory item
        obtainMeals(meals); // price of each menu item

        while (!done) {
            printMenu();
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    done = true;
                    break;
                case 1:
                    purchaseMoreInventory(inventory, ingredients);
                    break;
                case 2:
                    checkInventory(inventory, ingredients);
                    break;
                case 3:
                    System.out.printf("Current balance: $%.2f\n", checkBalance(inventory));
                    System.out.print(loanOrSubsidy);
                    break;
                case 4:
                    System.out.println("Total Expenses = $" + getExpenses(inventory));
                    break;
                case 5:
                    System.out.print("How many employees do you have? ");
                    int employeeNumber = input.nextInt();
                    System.out.print("How much is your monthly rent? ");
                    double rent = input.nextDouble();
                    double lasagnaMonthlySales = rand.nextInt(175) + 15; // random number between 15 and 200
                    double spaghettiMonthlySales = rand.nextInt(175) + 15;
                    double fiorentinaSteakMontlySales = rand.nextInt(175) + 15;
                    double revenue = lasagnaMonthlySales * meals[0].getPrice()
                            + spaghettiMonthlySales * meals[1].getPrice()
                            + fiorentinaSteakMontlySales * meals[2].getPrice();

                    Lasagna lasagna = (Lasagna) meals[0];
                    double lasagnaCost = ingredients[0].getCost() * lasagna.getLasagnaNoodles_perMeal()
                            + ingredients[10].getCost() * lasagna.getGroundBeef_perMeal()
                            + ingredients[5].getCost() * lasagna.getOnion_perMeal()
                            + ingredients[4].getCost() * lasagna.getTomato_perMeal()
                            + ingredients[7].getCost() * lasagna.getSweetPepper_perMeal()
                            + ingredients[2].getCost() * lasagna.getMozzarella_perMeal();

                    Spaghetti spaghetti = (Spaghetti) meals[1];
                    double spaghettiCost = ingredients[1].getCost() * spaghetti.getPasta_perMeal()
                            + ingredients[10].getCost() * spaghetti.getGroundBeef_perMeal()
                            + ingredients[5].getCost() * spaghetti.getOnion_perMeal()
                            + ingredients[4].getCost() * spaghetti.getTomato_perMeal()
                            + ingredients[8].getCost() * spaghetti.getGarlic_perMeal()
                            + ingredients[3].getCost() * spaghetti.getParmesan_perMeal();

                    FiorentinaSteak fiorentinaSteak = (FiorentinaSteak) meals[2];
                    double fiorentinaSteakCost = ingredients[11].getCost() * fiorentinaSteak.getSteak_perMeal()
                            + ingredients[6].getCost() * fiorentinaSteak.getPotato_perMeal()
                            + ingredients[9].getCost() * fiorentinaSteak.getGrilledVegetables_perMeal()
                            + ingredients[8].getCost() * fiorentinaSteak.getGarlic_perMeal();

                    double expenses = rent
                            + lasagnaMonthlySales * lasagnaCost
                            + spaghettiMonthlySales * spaghettiCost
                            + fiorentinaSteakMontlySales * fiorentinaSteakCost;

                    loanOrSubsidy = checkFinancialPacakges(employeeNumber, revenue, expenses);
                    break;
                case 6:
                    survey(inventory, meals);
                    break;
                default:
                    System.out.println("Invalid input! Please try again!");
            }
        }

        System.out.println("*** PROGRAM ENDED ***");
    }

    public static void printMenu() {
        System.out.println("\n1. Purchase more inventory."
                + "\n2. Check inventory."
                + "\n3. Check the current balance."
                + "\n4. Display expenses made on inventory items."
                + "\n5. Check eligibiligy and check one financial aid package."
                + "\n6. Input survey responses and remove the least favourite dish from the menu."
                + "\n0. Exit program.");
    }

    // obtain the cost & quantity of each inventory item
    public static void obtainIngredients(Inventory inventory, Ingredient[] ingredients) {
        // declaration
        int index = 0;
        double cost;

        // data obtainment from the user
        System.out.println("\n*** ENTER THE COST & STARTING QUANTITY OF EACH INVENTORY ITEM. ***");
        System.out.println("* Input 0 to proceed with the default cost.");

        // 1. Lasagna Noodles
        System.out.println("\nLasagna Noodles      Unit: 500 g package      Default price: $1.67 / package");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new LasagnaNoodles(); // proceed with default cost
        } else {
            ingredients[index] = new LasagnaNoodles(cost); // obtain & input cost
        }
        inventory.setLasagnaNoodles(validateInput_quantities()); // obtain & input quantity
        index++;

        // 2 Pasta
        System.out.println("\nPasta      Unit: 450 g pacakge      Default price: $1.97 / package");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new Pasta(); // proceed with default cost
        } else {
            ingredients[index] = new Pasta(cost); // obtain & input cost
        }
        inventory.setPasta(validateInput_quantities()); // obtain & input quantity
        index++;

        // 3. Mozzarella
        System.out.println("\nMozzarella      Unit: 320 g package      Default price: $5.00 / package");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new Mozzarella(); // proceed with default cost
        } else {
            ingredients[index] = new Mozzarella(cost); // obtain & input cost
        }
        inventory.setMozzarella(validateInput_quantities()); // obtain & input quantity
        index++;

        // 4. Parmesan
        System.out.println("\nParmesan      Unit: 250 g package      Default price: $4.99 / package");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new Parmesan(); // proceed with default cost
        } else {
            ingredients[index] = new Parmesan(cost); // obtain & input cost
        }
        inventory.setParmesan(validateInput_quantities()); // obtain & input quantity
        index++;

        // 5. Tomato
        System.out.println("\nTomato      Unit: 1 kg      Default price: $4.57 / kg");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new Tomato(); // proceed with default cost
        } else {
            ingredients[index] = new Tomato(cost); // obtain & input cost
        }
        inventory.setTomato(validateInput_quantities()); // obtain & input quantity
        index++;

        // 6. Onion
        System.out.println("\nOnion      Unit: 1 kg      Default price: $1.28 / kg");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new Onion(); // proceed with default cost
        } else {
            ingredients[index] = new Onion(cost); // obtain & input cost
        }
        inventory.setOnion(validateInput_quantities()); // obtain & input quantity
        index++;

        // 7. Potato
        System.out.println("\nPotato      Unit: 1 kg      Default price: $1.01 / kg");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new Potato(); // proceed with default cost
        } else {
            ingredients[index] = new Potato(cost); // obtain & input cost
        }
        inventory.setPotato(validateInput_quantities()); // obtain & input quantity
        index++;

        // 8. Sweet Pepper
        System.out.println("\nSweet Pepper      Unit: 1 kg      Default price: $3.77 / kg");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new Potato(); // proceed with default cost
        } else {
            ingredients[index] = new Potato(cost); // obtain & input cost
        }
        inventory.setSweetPepper(validateInput_quantities()); // obtain & input quantity
        index++;

        // 9. Garlic
        System.out.println("\nGarlic      Unit: 1 kg      Default price: $3.51 / kg");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new Garlic(); // proceed with default cost
        } else {
            ingredients[index] = new Garlic(cost); // obtain & input cost
        }
        inventory.setGarlic(validateInput_quantities()); // obtain & input quantity
        index++;

        // 10. Grilled Vegetables
        System.out.println("\nGrilled Vegetables      Unit: 900 g package      Default price: $14.99 / package");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new GrilledVegetables(); // proceed with default cost
        } else {
            ingredients[index] = new GrilledVegetables(cost); // obtain & input cost
        }
        inventory.setGrilledVegetables(validateInput_quantities()); // obtain & input quantity
        index++;

        // 11. Ground Beef
        System.out.println("\nGround Beef      Unit: 1 kg      Default price: $11.38 / kg");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new GroundBeef(); // proceed with default cost
        } else {
            ingredients[index] = new GroundBeef(cost); // obtain & input cost
        }
        inventory.setGroundBeef(validateInput_quantities()); // obtain & input quantity
        index++;

        // 12. Steak
        System.out.println("\nSteak      Unit: 1 kg      Default price: $22.30 / kg");
        cost = validateInput_costs();
        if (cost == 0) {
            ingredients[index] = new Steak(); // proceed with default cost
        } else {
            ingredients[index] = new Steak(cost); // obtain & input cost
        }
        inventory.setSteak(validateInput_quantities()); // obtain & input quantity
        index++;
    }
	// helper method - determine whether the input is valid or not
    // helper method - validate the user input for cost

    private static double validateInput_costs() {
        // declaration
        Scanner input = new Scanner(System.in);
        double cost;

        // processing data
        while (true) {
            System.out.println("Enter the cost per unit: ");
            cost = input.nextDouble();

            if (cost >= 0) {
                break;
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }

        return cost;
    }

    // helper method - validate the user input for quantity

    private static double validateInput_quantities() {
        // declaration
        Scanner input = new Scanner(System.in);
        double quantity;

        // processing data
        while (true) {
            System.out.println("Enter quantity (# of units): ");
            quantity = input.nextDouble();

            if (quantity >= 0) {
                break;
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }

        return quantity;
    }

    // obtain the price of each meal
    public static void obtainMeals(Meal[] meals) {
        // declaration
        double price;
        int index = 0;

        // processing data
        System.out.println("\n*** Enter the price of each menu item. ***");
        System.out.println("* Input 0 to proceed with the default price.");

        System.out.println("Lasagna      Default price: $22.00 / meal");
        price = validateInput_price();
        if (price == 0) {
            meals[index] = new Lasagna();
        } else {
            meals[index] = new Lasagna(price);
        }
        index++;

        System.out.println("Spaghetti      Default price: $25.50 / meal");
        price = validateInput_price();
        if (price == 0) {
            meals[index] = new Spaghetti();
        } else {
            meals[index] = new Spaghetti(price);
        }
        index++;

        System.out.println("Fiorentina Steak      Default price: $32.00 / meal");
        price = validateInput_price();
        if (price == 0) {
            meals[index] = new FiorentinaSteak();
        } else {
            meals[index] = new FiorentinaSteak(price);
        }
        index++;
    }

    // helper method - validate the price of each menu item

    private static double validateInput_price() {
        // declaration
        Scanner input = new Scanner(System.in);
        double price;

        // data obtainment from the user
        while (true) {
            System.out.println("Enter the price per meal: ");
            price = input.nextDouble();

            if (price >= 0) {
                break;
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }

        return price;
    }

    // 1. Purchase more inventory
    public static void purchaseMoreInventory(Inventory inventory, Ingredient[] ingredients) {
        // declaration
        Scanner input = new Scanner(System.in);
        double cost, units;
        int choice, index;

        // data obtainment from the user
        for (int i = 0; i < ingredients.length; i++) {
            System.out.println((i + 1) + ". " + ingredients[i] + "\n");
        }

        while (true) {
            System.out.println("*** Which item would you like to purchase? (Input 0 to return to the previous menu) ");
            choice = input.nextInt();
            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= 12) {
                index = choice - 1; // each index is assigned to an ingredient
                units = validateInput_numPurchase();
                cost = ingredients[index].getCost() * units;
                if (cost > inventory.getBalance()) {
                    System.out.println("You do not have enough money in your balance :(");
                } else {
                    inventory.updateBalance(-cost);
                    inventory.updateExpenses(cost);
                    inventory.updateQuantities(index, units);
                    System.out.println("Successfully purchased " + ingredients[index].getName() + " [" + units + " unit(s)]");
                }
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
    }

    private static double validateInput_numPurchase() {
        // declaration
        Scanner input = new Scanner(System.in);
        double units;

        // data obtainment from the user
        while (true) {
            System.out.println("How many units would you like to purchase? (Input 0 to discard your selection) ");
            units = input.nextInt();

            if (units >= 0) {
                break;
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }

        return units;
    }

    // 2. Check inventory
    public static void checkInventory(Inventory inventory, Ingredient[] ingredients) {
        System.out.println("\n*** INVENTORY ***");
        System.out.printf("%-25s%-20s%-20s%-20s\n", "Ingredient", "Unit", "Cost (per unit)", "Count No.");
        for (int i = 0; i < ingredients.length; i++) {
            System.out.printf("%-25s%-20s%-20.2f%-20.1f\n", ingredients[i].getName(), ingredients[i].getUnit(),
                    ingredients[i].getCost(), inventory.getQuantities()[i]);
        }
    }

    // 3. Check the current balance
    public static double checkBalance(Inventory inventory) {
        return inventory.getBalance();
    }

    // 4. Display the expenses made on inventory items
    public static double getExpenses(Inventory inventory) {
        return inventory.getExpenses();
    }

    // 5. Check eligibiligy and check one financial aid package.
    public static String checkFinancialPacakges(int employeeNumber, double revenue, double expenses) {
        Scanner input = new Scanner(System.in);
        boolean anyPackages = false;
        boolean[] packageOptions = new boolean[5];
        System.out.println("Financial aid packages you are eligible for:");
        if (revenue >= 5000 && employeeNumber >= 10) { //
            System.out.println("#1: RBC Maple Businesses Subsidy: Provides $20,000.");
            packageOptions[0] = true;
            anyPackages = true;
        }
        if (revenue >= 1500 && revenue <= 3000 && employeeNumber >= 10) {
            System.out.println("#2: TD Extreme Financial Need Loan: Provides $10,000 with a 1% interest compounded anually.");
            packageOptions[1] = true;
            anyPackages = true;
        }
        if (revenue >= 7000 && employeeNumber >= 5) {
            System.out.println("#3: CIBC Financial Need Loan: Provides $100,000 with a 2.1% interest compounded annually.");
            packageOptions[2] = true;
            anyPackages = true;
        }
        if (expenses <= 1000 && revenue >= 2000) {
            System.out.println("#4: Scotiabank Entrepreneurship Loan: Provides $100,000 with a 3.2% interest compounded annually.");
            packageOptions[3] = true;
            anyPackages = true;
        }
        if (expenses <= 1500 && revenue >= 7000) {
            System.out.println("#5: BMO Operation Small Business Subsidy: Provides $70,000.");
            packageOptions[4] = true;
            anyPackages = true;
        }
        if (anyPackages) {
            int choice;
            do {
                System.out.print("Which package number would you like to choose? ");
                choice = input.nextInt();
            } while (!packageOptions[choice - 1]); //Repeat if the user's choice is not in their package options
            switch (choice) {
                case 1:
                    return "You also have a subsidy of $20,000 from RBC.\n";
                case 2:
                    return "You also have a loan of $10,000 with a 1% interest compounded anually from TD.\n";
                case 3:
                    return "You also have a loan of $100,000 with a 2.1% interest compounded annually from CIBC.\n";
                case 4:
                    return "You also have a loan of $100,000 with a 3.2% interest compounded annually from Scotiabank.\n";
                case 5:
                    return "You also have a subsidy of $70,000 from BMO.\n";
                default:
                    System.out.println("That is not an option.");
            }
        } else {
            System.out.println("You are not eligible for any loans or subsidies at this time.");
        }
        return "";
    }

    // 6. Input survey responses and remove the least favourite dish from the menu.
    public static void survey(Inventory inventory, Meal[] meals) {
        String[] dishes = inventory.getMenuItems();
        String[] ingredientNames = inventory.getIngredients();

        if (dishes[0] == "" && dishes[1] == "" && dishes[2] == "") {
            System.out.println("There are no dishes on the menu to rank.");
        } else {
            Scanner input = new Scanner(System.in);
            String[] choices = new String[numberOfDishes];
            double lasagnaScore = 0;
            double spaghettiScore = 0;
            double fiorentinaSteakScore = 0;
            System.out.print("How many customer survey responses would you like to enter? ");
            int numberOfSurveys = input.nextInt();
            //Each dish will have a final score which is the sum of the rank each customer gave the dish. The lower the score, the better
            for (int i = 1; i <= numberOfSurveys; i++) {
                System.out.println("*** MENU ITEMS *** (not case sensitive, no spaces)");
                System.out.println("- Lasagna\n- Spaghetti\n- Fiorentina-Steak");
                System.out.println("For customer #" + i + "...");
                for (int j = 0; j < numberOfDishes; j++) {
                    boolean choiceInvalid = false;
                    do {
                        choiceInvalid = false;
                        System.out.print("Enter choice #" + (j + 1) + ": ");
                        choices[j] = input.next();
                        if (choices[j].equalsIgnoreCase("Lasagna") && !dishes[0].equals("") && indexOf("Lasagna", Arrays.copyOfRange(choices, 0, j)) == -1) {
                            lasagnaScore += j + 1;
                        } else if (choices[j].equalsIgnoreCase("Spaghetti") && !dishes[1].equals("") && indexOf("Spaghetti", Arrays.copyOfRange(choices, 0, j)) == -1) {
                            spaghettiScore += j + 1;
                        } else if (choices[j].equalsIgnoreCase("Fiorentina-Steak") && !dishes[2].equals("") && indexOf("Fiorentina-Steak", Arrays.copyOfRange(choices, 0, j)) == -1) {
                            fiorentinaSteakScore += j + 1;
                        } else {
                            System.out.println("That dish is not on the menu, or you entered the same dish twice. Please try again.");
                            choiceInvalid = true;
                        }
                    } while (choiceInvalid);
                }
            }
            // create a map where the key is the dish name and the value is the total score of the dish
            HashMap<String, Double> rankings = new HashMap<String, Double>();
            if (!dishes[0].equals("")) {
                rankings.put("Lasagna", lasagnaScore);
            }
            if (!dishes[1].equals("")) {
                rankings.put("Spaghetti", spaghettiScore);
            }
            if (!dishes[2].equals("")) {
                rankings.put("Fiorentina Steak", fiorentinaSteakScore);
            }
			// sort map by value (score of the dishes) in ascending order, meaning the first dish is the favourite and
            // first dish is the favourite and the last dish is the least favourite
            rankings = sortMap(rankings);
            String leastFavourite = "";
            System.out.println("Dishes ranked from most favourite to least favourite:");
            int i = 1;
            for (String key : rankings.keySet()) {
                System.out.printf(i + ". " + key + " (average ranking: %.2f)\n", rankings.get(key) / (double) numberOfSurveys);
                if (i == numberOfDishes) {
                    leastFavourite = key;
                }
                i++;
            }
            System.out.print("Would you like to remove " + leastFavourite + " from the menu? ");
            String remove = input.next();
            if (remove.equalsIgnoreCase("yes")) {
                if (leastFavourite.equals("Lasagna")) {
                    dishes[0] = "";
                    ingredientNames[0] = ""; // lasagna noodles
                    ingredientNames[7] = ""; // sweet pepper
                    ingredientNames[2] = ""; // mozzarella
                    // if spaghetti is also not on the menu, remove shared ingredients between lasagna and spaghetti
                    if (dishes[1].equals("")) {
                        ingredientNames[10] = ""; // ground beef
                        ingredientNames[4] = ""; // tomato
                        ingredientNames[5] = ""; // onion
                    }
					// if Fiorentina steak is also not on the menu, remove shared ingredients between lasagna and Fiorentina steak
                    // nonetheless, lasagna and Fiorentina steak do not share any ingredients
                } else if (leastFavourite.equals("Spaghetti")) {
                    dishes[1] = "";
                    ingredientNames[1] = ""; // pasta
                    ingredientNames[3] = ""; // parmesan
                    // if lasagna is also not on the menu, remove shared ingredients between spaghetti and lasagna
                    if (dishes[0].equals("")) {
                        ingredientNames[10] = ""; // ground beef
                        ingredientNames[4] = ""; // tomato
                        ingredientNames[5] = ""; // onion
                    }
                    // if Fiorentina steak is also not on the menu, remove shared ingredients between spaghetti and Fiorentina steak
                    if (dishes[2].equals("")) {
                        ingredientNames[8] = ""; // garlic
                    }
                } else {
                    dishes[2] = "";
                    ingredientNames[11] = ""; // steak
                    ingredientNames[6] = ""; // potato
                    ingredientNames[9] = ""; // grilled vegetables
                    // if lasagna is also not on the menu, remove shared ingredients between Fiorentina steak and lasagna
                    // nonetheless, Fiorentina steak and lasagna do not share any ingredients

                    // if spaghetti is also not on the menu, remove shared ingredients between Fiorentina steak and spaghetti
                    if (dishes[1].equals("")) {
                        ingredientNames[8] = ""; // garlic
                    }
                }
				// if all three dishes are not on the menu, remove the shared ingredient between them
                // nonetheless, all the dishes do not share any ingredients
                System.out.println("New Ingredient List:");
                for (int j = 0; j < ingredientNames.length; j++) {
                    if (!ingredientNames[j].equals("")) {
                        System.out.println(ingredientNames[j]);
                    }
                }
                numberOfDishes--;
            }

            inventory.setMenuItems(dishes);
            inventory.setIngredients(ingredientNames);
        }
    }

    //This method sorts a map in ascending order by its values and returns the sorted map

    public static HashMap<String, Double> sortMap(HashMap<String, Double> map) {
        HashMap<String, Double> sortedMap = map.entrySet().
                stream().
                sorted(HashMap.Entry.comparingByValue()).
                collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap;
    }

    public static int indexOf(String string, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(string)) {
                return i;
            }
        }
        return -1;
    }
}
