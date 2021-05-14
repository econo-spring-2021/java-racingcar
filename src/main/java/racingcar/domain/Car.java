package racingcar.domain;

import racingcar.controller.NumberGenerator;

public class Car {
    private final static int MOVE_CHANCE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getNameIfPositionSameOrEmpty(int comp) {
        if (position == comp) return name;

        return "";
    }

    public int getPosition() {
        return position;
    }

    public void raceOnce(NumberGenerator numberGenerator) {
        int moveChance = numberGenerator.generateNumber();
        if (moveChance >= MOVE_CHANCE) move();
    }

    private void move() {
        position++;
    }
}
