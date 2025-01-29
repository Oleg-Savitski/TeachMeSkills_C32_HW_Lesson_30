package lesson_30.task_factory_game.environments.impl;

import lesson_30.task_factory_game.environments.Environment;

public class Desert implements Environment {
    @Override
    public String getDescription() {
        return "in a hot desert with sandy dunes and sparse vegetation";
    }
}