package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ParticipatingCarTest {
    @Test
    void 자동차를_출전_자동차_리스트에_추가_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("lee");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        ParticipatingCar participatingCar = new ParticipatingCar();
        participatingCar.addRacingCar(car1);
        participatingCar.addRacingCar(car2);

        assertEquals(carList,participatingCar.getRacingCarList());
    }
}