package lesson_30.task_builder_pizza.builder;

import lesson_30.task_builder_pizza.model.Ingredient;
import lesson_30.task_builder_pizza.model.Pizza;
import lesson_30.task_builder_pizza.model.PizzaSize;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/** The main reasons for using Builder in this code are:
 *
 1. Step-by-step construction of an object with the ability to configure various parameters.
 2. Encapsulation of validation logic (for example, checking the ingredient limit).
 3. Simplification of client code through a chain of methods.
 4. The ability to create an immutable Pizza object.
 5. Flexibility in adding ingredients with processing conditions.
 */

public class PizzaBuilder {
    private static final Logger logger = Logger.getLogger(PizzaBuilder.class.getName());
    private String name;
    private PizzaSize size;
    private final List<Ingredient> ingredients = new ArrayList<>();

    public PizzaBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PizzaBuilder setSize(PizzaSize size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder addIngredient(Ingredient ingredient) {
        if (ingredients.size() < size.ingredientCount()) {
            ingredients.add(ingredient);
            logger.fine("Ingredient added -> " + ingredient.name());
        } else {
            String warning = String.format("Ingredient limit (%d) reached for size %s",
                    size.ingredientCount(), size.size());
            logger.warning(warning);
        }
        return this;
    }

    public Pizza build() {
        return new Pizza(name, size, ingredients);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}