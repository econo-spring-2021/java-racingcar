package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public static int setRandomValue() {
        return (int) ((Math.random() * 10000) % 10);
    }

    public int getPosition() {
        return position;
    }
}
