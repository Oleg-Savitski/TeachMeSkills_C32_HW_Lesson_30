package lesson_30.task_builder_pizza.app;

import lesson_30.task_builder_pizza.builder.PizzaBuilder;
import lesson_30.task_builder_pizza.menu.PizzaMenu;
import lesson_30.task_builder_pizza.model.Ingredient;
import lesson_30.task_builder_pizza.model.Pizza;
import lesson_30.task_builder_pizza.model.PizzaSize;
import lesson_30.task_builder_pizza.service.order.PizzaOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/** This program simulates the operation of a pizza delivery service.
 * The principle of the "Builder" pattern is demonstrated here.
 * Enter the name of the pizza and the ingredients strictly using the case.
 * This is done specifically to focus on the operation of the program during user interaction.
 */

public class PizzaApp {
    private static final Logger logger = Logger.getLogger(PizzaApp.class.getName());

    public static void main(String[] args) {
        System.setProperty("java.util.logging.config.file", "src/main/resources/logging.properties");
        logger.info("Starting PizzaApp");

        PizzaMenu menu = new PizzaMenu();
        PizzaOrder pizzaOrder = new PizzaOrder();
        Scanner scanner = new Scanner(System.in);
        List<Pizza> pizzas = new ArrayList<>();

        System.out.println("*** Welcome to PizzaApp! ***");
        System.out.println("Available menu->");
        menu.getMenu().forEach((String name, List<Ingredient> ingredients) -> {
            System.out.println(name + " -> " + ingredients);
        });

        boolean addMorePizzas = true;

        while (addMorePizzas) {
            System.out.println("Choose a pizza (enter the name) ->");
            String pizzaName = scanner.nextLine();

            if (!menu.getMenu().containsKey(pizzaName)) {
                System.out.println("This pizza is not on the menu.");
                continue;
            }

            List<PizzaSize> availableSizes = menu.getAvailableSizes();
            System.out.println("Available pizza sizes->");
            availableSizes.forEach(System.out::println);
            System.out.println("Enter the pizza size->");
            String sizeInput = scanner.nextLine();
            PizzaSize selectedSize = availableSizes.stream()
                    .filter(size -> size.size().equalsIgnoreCase(sizeInput))
                    .findFirst()
                    .orElse(null);

            if (selectedSize == null) {
                System.out.println("This size is not available.");
                continue;
            }

            List<Ingredient> availableIngredients = menu.getMenu().get(pizzaName);
            PizzaBuilder builder = new PizzaBuilder();
            builder.setName(pizzaName);
            builder.setSize(selectedSize);
            System.out.println("Choose ingredients (enter names separated by commas)->");
            String ingredientsInput = scanner.nextLine();
            System.out.println("Available ingredients for " + pizzaName + "->");
            availableIngredients.forEach(ingredient -> System.out.println(ingredient.name()));

            for (String ingredientName : ingredientsInput.split(",")) {
                ingredientName = ingredientName.trim();
                String finalIngredientName = ingredientName;
                availableIngredients.stream()
                        .filter(ingredient -> ingredient.name().equalsIgnoreCase(finalIngredientName))
                        .findFirst()
                        .ifPresentOrElse(
                                builder::addIngredient,
                                () -> System.out.println("Ingredient '" + finalIngredientName + "' not found in available ingredients.")
                        );
            }

            if (builder.getIngredients().isEmpty()) {
                System.out.println("You did not add any ingredients. Please try again.");
                continue;
            }
            pizzas.add(builder.build());
            logger.info("Pizza added to order -> " + builder.build());
            System.out.println("Pizza added to order.");
            System.out.println("Would you like to add another pizza? (yes/no)");
            String response = scanner.nextLine();
            addMorePizzas = response.equalsIgnoreCase("yes");
        }

        System.out.println("Are you a student? (yes/no)");
        boolean isStudent = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.println("Are you a large family? (yes/no)");
        boolean isLargeFamily = scanner.nextLine().equalsIgnoreCase("yes");

        pizzaOrder.placeOrder(pizzas, isStudent, isLargeFamily, scanner);
        System.out.println("Thank you for your order! Expect a call to confirm the order.");
        scanner.close();
    }
}