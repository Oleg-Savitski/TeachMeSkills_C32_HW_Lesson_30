package lesson_30.task_builder_pizza.model;

public record Ingredient(String name, double price) {

    @Override
    public String toString() {
        return name + " (" + price + " rub.)";
    }
}