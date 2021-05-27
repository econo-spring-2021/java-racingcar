package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private List<Car> racingCarList;

    public CarFactory() {
        racingCarList = new ArrayList<>();
    }

    public void addRacingCar(Car car) {
        racingCarList.add(car);
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }
}
