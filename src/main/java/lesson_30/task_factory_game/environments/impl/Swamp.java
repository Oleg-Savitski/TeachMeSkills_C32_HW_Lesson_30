package lesson_30.task_factory_game.environments.impl;

import lesson_30.task_factory_game.environments.Environment;

public class Swamp implements Environment {
    @Override
    public String getDescription() {
        return "in a swamp with poisonous snakes and swarms of flying mosquitoes";
    }
}