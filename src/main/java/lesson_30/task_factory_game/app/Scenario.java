package lesson_30.task_factory_game.app;

import lesson_30.task_factory_game.characters.personage.ICharacter;
import lesson_30.task_factory_game.environments.Environment;

public class Scenario {
    public static void describeScenario(ICharacter character, Environment environment) {
        System.out.println(character.getDescription() + " is in " + environment.getDescription() + ".");
    }
}