package lesson_30.task_factory_game.characters.personage.impl;

import lesson_30.task_factory_game.characters.personage.ICharacter;

public class Druid implements ICharacter {

    @Override
    public String getDescription() {
        return "Druid connected to nature, with a staff and earth magic";
    }

    @Override
    public void useAbility() {
        System.out.println("The druid calls upon the forces of nature for healing and protection!");
    }

    @Override
    public int getAbilityDamage() {
        return 20;
    }
}