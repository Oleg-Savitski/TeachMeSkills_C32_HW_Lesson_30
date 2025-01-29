package lesson_30.task_builder_pizza.service.discount;

import java.util.logging.Logger;

public class Discount {
    private static final Logger logger = Logger.getLogger(Discount.class.getName());

    public double calculateDiscount(double totalPrice, int pizzaCount, boolean isStudent, boolean isLargeFamily) {
        logger.config("Calculating discount for -> "
                + (isStudent ? "student " : "")
                + (isLargeFamily ? "large family " : "")
                + "number of pizzas -> " + pizzaCount);

        double discount = 0;

        if (isStudent) {
            discount += totalPrice * 0.05;
            logger.fine("Applied student discount of 5%");
        }
        if (isLargeFamily) {
            discount += totalPrice * 0.10;
            logger.fine("Applied large family discount of 10%");
        }
        if (pizzaCount >= 2) {
            discount += totalPrice * 0.20;
            logger.fine("Applied discount for ordering 2 or more pizzas: 20%");
        }

        return discount;
    }
}