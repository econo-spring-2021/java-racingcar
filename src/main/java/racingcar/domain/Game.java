package racingcar.domain;

import racingcar.view.EmptyNameException;
import racingcar.view.NotProperInputTypeException;
import racingcar.view.TooLongNameException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final static int LONGNAME_STANDARD = 5;

    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public Game() {
    }

    public Game(String[] carNames, int tryCount) {
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
        this.tryCount = tryCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String[] getWinnerNames() {
        String[] winner = new String[cars.size()];
        int maxPosition = getMaxPosition();

        for (int i = 0; i < cars.size(); i++) {
            winner[i] = cars.get(i).getNameIfPositionSameOrEmpty(maxPosition);
        }

        return winner;
    }

    public int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }

        return max;
    }

    public void setCar(List<Car> cars) {
        this.cars = cars;
    }

    public void catchNameException(String[] name) throws EmptyNameException, TooLongNameException {
        for (String n : name) {
            catchEmptyName(n);
            catchTooLongName(n);
        }
    }

    public void catchEmptyName(String name) throws EmptyNameException {
        if (name == "") throw new EmptyNameException();
    }

    public void catchTooLongName(String name) throws TooLongNameException {
        if (name.length() > LONGNAME_STANDARD) throw new TooLongNameException();
    }

    public void catchTryCountException(String count) throws NotProperInputTypeException {
        boolean isDigit = count.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isDigit) throw new NotProperInputTypeException();

    }
}
