package racingcar.domain;

import Util.DedicatedNumberGenerator;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameException;
import racingcar.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    public void 값이_4_이상_이면_전진하는지_테스트() {
        try {
            Car car;
            for (int i = 4; i < 10; i++) {
                car = new Car("Fry", new DedicatedNumberGenerator(i));
                car.move();
                assertThat(car.getPosition()).isEqualTo(1);
            }
        } catch (CarNameException e) {
            OutputView.showError(e.getMessage());
        }
    }

    @Test
    public void 값이_3_이하_이면_멈추는지_테스트() {
        try {
            Car car;
            for (int i = 1; i < 4; i++) {
                car = new Car("Fry", new DedicatedNumberGenerator(i));
                car.move();
                assertThat(car.getPosition()).isEqualTo(0);
            }
        } catch (CarNameException e) {
            OutputView.showError(e.getMessage());
        }
    }
}