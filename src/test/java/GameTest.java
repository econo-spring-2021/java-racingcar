import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GameTest {
    @Test
    void test_getWinnerNames() {
        Game game = new Game();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cars.add(new Car(Integer.toString(i), i));
        }
        game.setCar(cars);

        assertThat(game.getWinnerNames()[4]).isEqualTo("4");
    }

    @Test
    void test_getMaxPosition() {
        Game game = new Game();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cars.add(new Car(Integer.toString(i), i));
        }
        game.setCar(cars);

        assertThat(game.getMaxPosition()).isEqualTo(4);
    }
}
