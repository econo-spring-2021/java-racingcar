package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    public void 값이_4_이상_이면_전진하는지_테스트() {
        Car car = new Car("Fry");
        int initPosition = 0;

        for (int i = 4; i < 10; i++) {
            car.move(i);
            assertThat(car.getPosition()).isEqualTo(++initPosition);
        }
    }

    @Test
    public void 값이_3_이하_이면_멈추는지_테스트() {
        Car car = new Car("Fry");
        int initPosition = 0;

        for (int i = 0; i < 4; i++) {
            car.move(i);
            assertThat(car.getPosition()).isEqualTo(initPosition);
        }
    }
}