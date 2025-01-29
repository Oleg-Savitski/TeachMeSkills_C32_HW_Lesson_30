package lesson_30.task_factory_game.characters.personage.impl;

import lesson_30.task_factory_game.characters.personage.ICharacter;

public class Warrior implements ICharacter {
    @Override
    public String getDescription() {
        return "Warrior in armor with a sword";
    }

    @Override
    public void useAbility() {
        System.out.println("The warrior delivers a powerful strike!");
    }

    @Override
    public int getAbilityDamage() {
        return 10;
    }
}