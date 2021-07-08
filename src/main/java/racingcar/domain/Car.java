package racingcar.domain;

import Util.NumberGenerator;
import racingcar.exception.CarNameException;

public class Car implements Comparable<Car> {
    private final static int MIN_VAL_FORWARD = 4;

    private static NumberGenerator numberGenerator = null;

    private final String name;
    private int position = 0;

    public Car(String name, NumberGenerator numberGenerator) throws CarNameException {
        if (name == null || name.length() <= 0) {
            throw new CarNameException(CarNameException.NO_CAR_NAME);
        }
        if (name.length() > 5) {
            throw new CarNameException(CarNameException.TOO_LONG_NAME);
        }
        this.numberGenerator = numberGenerator;
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (numberGenerator.getInt() >= MIN_VAL_FORWARD) {
            position += 1;
        }
    }

    @Override
    public int compareTo(Car o) {
        return position - o.position;
    }
}
