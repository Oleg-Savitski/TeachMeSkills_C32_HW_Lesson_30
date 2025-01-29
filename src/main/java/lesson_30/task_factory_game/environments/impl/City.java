package lesson_30.task_factory_game.environments.impl;

import lesson_30.task_factory_game.environments.Environment;

public class City implements Environment {
    @Override
    public String getDescription() {
        return "in a bustling city with many people and buildings";
    }
}