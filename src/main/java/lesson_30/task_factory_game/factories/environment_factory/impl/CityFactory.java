package lesson_30.task_factory_game.factories.environment_factory.impl;

import lesson_30.task_factory_game.environments.Environment;
import lesson_30.task_factory_game.environments.impl.City;
import lesson_30.task_factory_game.factories.environment_factory.EnvironmentFactory;

public class CityFactory implements EnvironmentFactory {
    @Override
    public Environment createEnvironment() {
        return new City();
    }
}