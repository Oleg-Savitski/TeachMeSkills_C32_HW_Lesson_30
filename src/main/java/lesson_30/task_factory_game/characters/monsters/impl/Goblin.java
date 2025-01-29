package lesson_30.task_factory_game.characters.monsters.impl;

import lesson_30.task_factory_game.characters.monsters.IMonster;

public class Goblin implements IMonster {
    private int health = 30;

    @Override
    public String getDescriptionMonster() {
        return "Goblin with " + health + " health.";
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("Goblin took " + damage + " damage. Remaining health -> " + health);
    }
}