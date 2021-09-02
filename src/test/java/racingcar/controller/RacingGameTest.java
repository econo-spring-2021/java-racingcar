package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameException;
import racingcar.exception.TrialTimeException;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    public void 시도_회수_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add("fry");
        carNames.add("hero");

        try {
            RacingGame racingGame = new RacingGame(carNames, 2);

            assertThat(racingGame.isPlaying()).isEqualTo(true);

            racingGame.startRound();
            racingGame.startRound();

            assertThat(racingGame.isPlaying()).isEqualTo(false);
        } catch (CarNameException | TrialTimeException e) {
            OutputView.showError(e.getMessage());
        }
    }
}