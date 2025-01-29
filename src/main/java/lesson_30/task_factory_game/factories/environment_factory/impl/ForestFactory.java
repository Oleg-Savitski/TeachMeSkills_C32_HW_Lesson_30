package lesson_30.task_factory_game.factories.environment_factory.impl;

import lesson_30.task_factory_game.environments.Environment;
import lesson_30.task_factory_game.environments.impl.Forest;
import lesson_30.task_factory_game.factories.environment_factory.EnvironmentFactory;

public class ForestFactory implements EnvironmentFactory {
    @Override
    public Environment createEnvironment() {
        return new Forest();
    }
}