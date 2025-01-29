package lesson_30.task_builder_pizza.menu;

import lesson_30.task_builder_pizza.model.Ingredient;
import lesson_30.task_builder_pizza.model.PizzaSize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PizzaMenu {
    private static final Logger logger = Logger.getLogger(PizzaMenu.class.getName());
    private final Map<String, List<Ingredient>> menu = new HashMap<>();
    private final List<PizzaSize> availableSizes;

    public PizzaMenu() {
        logger.config("Initializing the menu with pizza sizes and ingredients");
        availableSizes = List.of(
                new PizzaSize("Small", 15, 3),
                new PizzaSize("Medium", 20, 5),
                new PizzaSize("Large", 30, 7)
        );
        menu.put("Margherita", List.of(
                new Ingredient("Tomato Sauce", 2),
                new Ingredient("Cheese", 4),
                new Ingredient("Basil", 2),
                new Ingredient("Olive Oil", 3)
        ));
        menu.put("Pepperoni", List.of(
                new Ingredient("Tomato Sauce", 2),
                new Ingredient("Cheese", 4),
                new Ingredient("Pepperoni", 5),
                new Ingredient("Garlic", 3)
        ));
        menu.put("Hawaiian", List.of(
                new Ingredient("Tomato Sauce", 2),
                new Ingredient("Cheese", 4),
                new Ingredient("Ham", 5),
                new Ingredient("Pineapple", 4)
        ));
        menu.put("Four Cheeses", List.of(
                new Ingredient("Mozzarella", 5),
                new Ingredient("Cheddar", 5),
                new Ingredient("Gorgonzola", 3),
                new Ingredient("Parmesan", 7)
        ));
        menu.put("Vegetarian", List.of(
                new Ingredient("Tomato Sauce", 2),
                new Ingredient("Cheese", 4),
                new Ingredient("Broccoli", 2),
                new Ingredient("Mushrooms", 4)
        ));

        menu.forEach((name, ingredients) ->
                logger.fine("Added pizza to the menu -> " + name + " with " + ingredients.size() + " ingredients")
        );
    }

    public Map<String, List<Ingredient>> getMenu() {
        return menu;
    }

    public List<PizzaSize> getAvailableSizes() {
        return availableSizes;
    }
}