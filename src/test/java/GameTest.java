import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.Game;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GameTest {
    ArrayList<Car> cars;

    @Test
    public void carNameInputTest() throws IOException {
        String input = "111111,2,3";
        assertThat(false).isEqualTo(InputView.checkCarNameInput(InputView.getCarNames(input)));
        String input2 = "1,2,3,4";
        assertThat(true).isEqualTo(InputView.checkCarNameInput(InputView.getCarNames(input2)));
    }

    @Test
    public void tryNumberTest() throws IOException {
        int tryNumber = 0;
        assertThat(false).isEqualTo(InputView.checkTryNumberInput(tryNumber));
    }

    @BeforeEach
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("1"));
        cars.add(new Car("2"));

        cars.get(0).move(1);
        cars.get(1).move(5);
    }

    @Test
    public void raceResultViewTest() {
        assertThat("").isEqualTo(OutputView.racingLengthView(cars.get(0).getPosition()));
        assertThat("-").isEqualTo(OutputView.racingLengthView(cars.get(1).getPosition()));
    }

    @Test
    public void winnerTest(){
        assertThat("2").isEqualTo(Game.getWinner(cars).get(0));
    }

}
