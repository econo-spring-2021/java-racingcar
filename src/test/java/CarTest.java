import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarTest {
    @Test
    void test_raceOnce() {
        Car car = new Car("car");

        TestNumberGenerator testNumberGenerator = new TestNumberGenerator();
        testNumberGenerator.setChance(2);
        car.raceOnce(testNumberGenerator);

        assertThat(car.getPosition()).isEqualTo(0);

        testNumberGenerator.setChance(5);
        car.raceOnce(testNumberGenerator);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
