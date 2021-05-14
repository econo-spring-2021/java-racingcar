package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
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
}
