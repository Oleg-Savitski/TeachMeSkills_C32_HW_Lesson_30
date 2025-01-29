package lesson_30.task_factory_game.factories.character_factory.impl;

import lesson_30.task_factory_game.characters.personage.ICharacter;
import lesson_30.task_factory_game.characters.personage.impl.Warrior;
import lesson_30.task_factory_game.factories.character_factory.CharacterFactory;

public class WarriorFactory implements CharacterFactory {
    @Override
    public ICharacter createCharacter() {
        return new Warrior();
    }
}