package lesson_30.task_builder_pizza.model;

public record PizzaSize(String size, double basePrice, int ingredientCount) {

    @Override
    public String toString() {
        return size + " (Base Price -> " + basePrice + " rub., Max Ingredients -> " + ingredientCount + ")";
    }
}