import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GameTest {
    @Test
    void test_getWinner() {
        Game game = new Game();

        Car[] car = new Car[5];
        for (int i = 0 ; i < 5; i++) {
            car[i] = new Car(Integer.toString(i), i);
        }
        game.setCar(car);

        assertThat(game.getWinner()[4]).isEqualTo("4");
    }

    @Test
    void test_getMaxPosition() {
        Game game = new Game();

        Car[] car = new Car[5];
        for (int i = 0 ; i < 5; i++) {
            car[i] = new Car(Integer.toString(i), i);
        }
        game.setCar(car);

        assertThat(game.getMaxPosition()).isEqualTo(4);
    }
}
