package lesson_30.task_factory_game.characters.personage.impl;

import lesson_30.task_factory_game.characters.personage.ICharacter;

public class Magician implements ICharacter {
    @Override
    public String getDescription() {
        return "Mage with a long robe and a magic wand";
    }

    @Override
    public void useAbility() {
        System.out.println("The mage casts a fire spell!");
    }

    @Override
    public int getAbilityDamage() {
        return 18;
    }
}