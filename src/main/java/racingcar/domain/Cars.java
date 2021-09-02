package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

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

    public void moveRandomAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Map<String, Integer> getCarPositions() {
        Map<String, Integer> carPositions = new HashMap<>();
        for (Car car : cars) {
            carPositions.put(car.getCarName(), car.getPosition());
        }
        return carPositions;
    }

    public int getTopPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .get()
                .getPosition();
    }

    public List<String> getCarNamesAt(int position) {
        return cars.stream()
                .filter(t -> t.getPosition() == position)
                .map((car) -> car.getCarName())
                .collect(Collectors.toList());
    }
}
