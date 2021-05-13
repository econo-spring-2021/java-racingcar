import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import racingcar.controller.Game;

import java.io.IOException;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GameTest {

    @Test
    public void tryNumberTest() throws IOException {
        int tryNumber = 0;
        assertThat(false).isEqualTo(Game.checkTryNumberInput(tryNumber));
    }

    @Test
    public void carNameTest() throws IOException {
        String[] carNames = {"11111, 2, 3"};
        assertThat(false).isEqualTo(Game.checkCarNameInput(carNames));
    }

    @Test
    public void racingCarMoveTest() {
        StringBuilder racingCar = new StringBuilder();
        assertThat("-").isEqualTo(Game.racingCarMove(true, racingCar).toString());
        assertThat("--").isEqualTo(Game.racingCarMove(true, racingCar).toString());
        assertThat("--").isEqualTo(Game.racingCarMove(false, racingCar).toString());
    }


}
