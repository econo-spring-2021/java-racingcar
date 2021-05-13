package racingcar.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int step) {
        if (step >= 4) position += 1;
    }

    @Override
    public int compareTo(Car o) {
        return position - o.position;
    }
}
