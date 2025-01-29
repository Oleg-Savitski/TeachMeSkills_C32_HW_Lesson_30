package lesson_30.task_builder_pizza.service.order;

import lesson_30.task_builder_pizza.service.delivery.Delivery;
import lesson_30.task_builder_pizza.service.discount.Discount;
import lesson_30.task_builder_pizza.model.Pizza;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class PizzaOrder {
    private static final Logger logger = Logger.getLogger(PizzaOrder.class.getName());
    private final Delivery delivery = new Delivery();
    private final Discount discount = new Discount();

    public void placeOrder(List<Pizza> pizzas, boolean isStudent, boolean isLargeFamily, Scanner scanner) {
        logger.info("Placing an order for " + pizzas.size() + " pizzas");
        double totalCost = 0;
        for (Pizza pizza : pizzas) {
            totalCost += pizza.calculatePrice();
        }
        double deliveryCost = delivery.calculateDeliveryCost(pizzas.size(), scanner);
        totalCost += deliveryCost;
        double discountAmount = discount.calculateDiscount(totalCost, pizzas.size(), isStudent, isLargeFamily);
        totalCost -= discountAmount;
        logger.info(String.format(
                "Order summary -> Total cost=%.2f rub. Discount=%.2f rub. Delivery=%.2f rub.",
                totalCost, discountAmount, deliveryCost));

        System.out.println("Total order cost -> " + totalCost + " rub. (Discount -> " + discountAmount + " rub.)");
    }
}