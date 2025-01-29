package lesson_30.task_factory_game.characters.monsters.impl;

import lesson_30.task_factory_game.characters.monsters.IMonster;

public class Orc implements IMonster {
    private int health = 50;

    @Override
    public String getDescriptionMonster() {
        return "Orc with " + health + " health.";
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("Orc took " + damage + " damage. Remaining health -> " + health);
    }
}