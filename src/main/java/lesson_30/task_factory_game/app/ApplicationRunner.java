package lesson_30.task_factory_game.app;

import lesson_30.task_factory_game.characters.monsters.IMonster;
import lesson_30.task_factory_game.characters.personage.ICharacter;
import lesson_30.task_factory_game.environments.Environment;
import lesson_30.task_factory_game.factories.character_factory.impl.ArcherFactory;
import lesson_30.task_factory_game.factories.character_factory.impl.DruidFactory;
import lesson_30.task_factory_game.factories.character_factory.impl.MagicianFactory;
import lesson_30.task_factory_game.factories.character_factory.impl.WarriorFactory;
import lesson_30.task_factory_game.factories.environment_factory.impl.CityFactory;
import lesson_30.task_factory_game.factories.environment_factory.impl.DesertFactory;
import lesson_30.task_factory_game.factories.environment_factory.impl.ForestFactory;
import lesson_30.task_factory_game.factories.environment_factory.impl.SwampFactory;
import lesson_30.task_factory_game.factories.monster_factory.MonsterFactory;

import java.util.Random;
import java.util.Scanner;

/**
 * An imitation of a mini-console game has been created.
 * 4 characters, 2 monsters and 4 locations.
 * All actions in the game are random.
 * This game demonstrates the principles of the "Factory" pattern.
 */

public class ApplicationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ICharacter character = null;
        Environment environment = null;

        System.out.println("Choose a character: 1 - Mage, 2 - Warrior, 3 - Archer, 4 - Druid (or press Enter for random selection)");
        String characterInput = scanner.nextLine();
        if (characterInput.isEmpty()) {
            int randomCharacter = random.nextInt(4) + 1;
            characterInput = String.valueOf(randomCharacter);
        }

        character = switch (characterInput) {
            case "1" -> new MagicianFactory().createCharacter();
            case "2" -> new WarriorFactory().createCharacter();
            case "3" -> new ArcherFactory().createCharacter();
            case "4" -> new DruidFactory().createCharacter();
            default -> {
                System.out.println("Invalid character selection.");
                yield null;
            }
        };

        if (character == null) {
            return;
        }

        System.out.println("Choose a location: 1 - Forest, 2 - Desert, 3 - City, 4 - Swamp (or press Enter for random selection)");
        String environmentInput = scanner.nextLine();
        if (environmentInput.isEmpty()) {
            int randomEnvironment = random.nextInt(4) + 1;
            environmentInput = String.valueOf(randomEnvironment);
        }

        environment = switch (environmentInput) {
            case "1" -> new ForestFactory().createEnvironment();
            case "2" -> new DesertFactory().createEnvironment();
            case "3" -> new CityFactory().createEnvironment();
            case "4" -> new SwampFactory().createEnvironment();
            default -> {
                System.out.println("Invalid location selection.");
                yield null;
            }
        };

        if (environment == null) {
            return;
        }

        Scenario.describeScenario(character, environment);

        IMonster monster = MonsterFactory.createRandomMonster();
        if (monster != null) {
            System.out.println("A " + monster.getDescriptionMonster() + " has attacked you!");
            character.useAbility();
            monster.takeDamage(character.getAbilityDamage());
        } else {
            System.out.println("Failed to create a monster.");
        }

        scanner.close();
    }
}