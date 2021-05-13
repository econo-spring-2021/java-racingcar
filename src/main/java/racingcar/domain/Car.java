package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void raceOnce() {
        int moveChance = (int) (Math.random() * 10);
        if (moveChance >= 4) move();
    }

    private void move() {
        position++;
    }
}
