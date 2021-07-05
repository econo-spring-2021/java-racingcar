package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void 자동차_전진_테스트() {
        Car car = new Car("pobi");
        car.move();
        assertEquals(1, car.getPosition());
    }
}