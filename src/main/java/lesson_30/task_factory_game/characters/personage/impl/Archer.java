package lesson_30.task_factory_game.characters.personage.impl;

import lesson_30.task_factory_game.characters.personage.ICharacter;

public class Archer implements ICharacter {

    @Override
    public String getDescription() {
        return "Archer with a bow and arrows";
    }

    @Override
    public void useAbility() {
        System.out.println("The archer shoots an arrow with high precision!");
    }

    @Override
    public int getAbilityDamage() {
        return 15;
    }
}