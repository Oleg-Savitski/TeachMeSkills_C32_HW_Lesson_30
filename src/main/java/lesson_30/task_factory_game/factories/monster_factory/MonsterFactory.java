package lesson_30.task_factory_game.factories.monster_factory;

import lesson_30.task_factory_game.characters.monsters.IMonster;
import lesson_30.task_factory_game.characters.monsters.impl.Goblin;
import lesson_30.task_factory_game.characters.monsters.impl.Orc;

import java.util.Random;

public class MonsterFactory {
    private static final Random random = new Random();

    public static IMonster createRandomMonster() {
        int monsterType = random.nextInt(2);
        return switch (monsterType) {
            case 0 -> new Goblin();
            case 1 -> new Orc();
            default -> null;
        };
    }
}
