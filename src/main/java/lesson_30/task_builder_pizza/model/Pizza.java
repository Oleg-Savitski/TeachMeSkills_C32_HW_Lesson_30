package lesson_30.task_builder_pizza.model;

import java.util.List;

public class Pizza {
    private final String name;
    private final PizzaSize size;
    private final List<Ingredient> ingredients;

    public Pizza(String name, PizzaSize size, List<Ingredient> ingredients) {
        this.name = name;
        this.size = size;
        this.ingredients = ingredients;
    }

    public double calculatePrice() {
        double totalPrice = size.basePrice();
        for (Ingredient ingredient : ingredients) {
            totalPrice += ingredient.price();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", ingredients=" + ingredients +
                ", total price=" + calculatePrice() +
                '}';
    }
}