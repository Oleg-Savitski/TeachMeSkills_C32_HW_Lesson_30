package lesson_30.task_builder_pizza.service.delivery;

import java.util.Scanner;
import java.util.logging.Logger;

public class Delivery {
    private static final Logger logger = Logger.getLogger(Delivery.class.getName());

    public double calculateDeliveryCost(int pizzaCount, Scanner scanner) {
        logger.info("Calculating delivery cost for " + pizzaCount + " pizzas");
        System.out.println("Choose a delivery method ->");
        System.out.println("1. Pickup (free)");
        System.out.println("2. Delivery within MKAD (free for orders of 2 or more pizzas)");
        System.out.println("3. Delivery outside MKAD (1 ruble per km)");

        int choice = scanner.nextInt();
        double deliveryCost = 0;

        switch (choice) {
            case 1:
                logger.info("You chose pickup.");
                deliveryCost = 0;
                break;
            case 2:
                if (pizzaCount >= 2) {
                    logger.info("Free delivery within MKAD for 2+ pizzas");
                    deliveryCost = 0;
                } else {
                    logger.info("You chose delivery within MKAD.");
                    deliveryCost = 5;
                }
                break;
            case 3:
                System.out.println("Enter the distance in km:");
                int kilometers = scanner.nextInt();
                deliveryCost = kilometers;
                logger.info("Delivery cost -> " + deliveryCost + " rub.");
                break;
            default:
                logger.warning("Invalid choice. Contact your manager.");
                deliveryCost = 0;
        }

        return deliveryCost;
    }
}