package lesson_30.task_factory_game.factories.environment_factory.impl;

import lesson_30.task_factory_game.environments.Environment;
import lesson_30.task_factory_game.environments.impl.Swamp;
import lesson_30.task_factory_game.factories.environment_factory.EnvironmentFactory;

public class SwampFactory implements EnvironmentFactory {
    @Override
    public Environment createEnvironment() {
        return new Swamp();
    }
}
