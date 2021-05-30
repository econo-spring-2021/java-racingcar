import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.TooLongNameException;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GameTest {

    @Test
    void test_inputCarNames() {
        GameController controller = new GameController();

        String input = "abc,efg";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        controller.inputCarNames();

//        Field field = controller.getClass().getDeclaredField("inputtedCarNames");
    }

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
