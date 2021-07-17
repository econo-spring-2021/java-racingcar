package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class ParticipatingCar {
    private List<Car> racingCarList;

    public ParticipatingCar() {
        racingCarList = new ArrayList<>();
    }

    public void register(Car car) {
        racingCarList.add(car);
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }
}
