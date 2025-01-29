package lesson_30.task_factory_game.factories.environment_factory.impl;


import lesson_30.task_factory_game.environments.Environment;
import lesson_30.task_factory_game.environments.impl.Desert;
import lesson_30.task_factory_game.factories.environment_factory.EnvironmentFactory;

public class DesertFactory implements EnvironmentFactory {
    @Override
    public Environment createEnvironment() {
        return new Desert();
    }
}