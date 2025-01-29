package lesson_30.task_factory_game.environments.impl;

import lesson_30.task_factory_game.environments.Environment;

public class Forest implements Environment {
    @Override
    public String getDescription() {
        return "in a dense forest with tall trees and the sounds of wildlife";
    }
}