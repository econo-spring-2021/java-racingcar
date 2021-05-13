package racingcar.domain;

import Util.RandomNumGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void moveRandomAll(int bound) {
        for (Car car: cars) {
            car.move(RandomNumGenerator.randInt(bound));
        }
    }
}
