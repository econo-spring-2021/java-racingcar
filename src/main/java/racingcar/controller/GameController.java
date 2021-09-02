package racingcar.controller;

import racingcar.exception.TrialTimeException;
import racingcar.view.InputView;
import racingcar.exception.CarNameException;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    public final static String CAR_NAME_DELIMITER = ",";

    RacingGame game;

    public GameController() {
        game = null;
    }

    public void play() {
        List<String> carNames = InputView.inputCarNames(CAR_NAME_DELIMITER);
        int trialTime = InputView.inputTrialTime();

        try {
            game = new RacingGame(carNames, trialTime);

            OutputView.showGameStartMsg();
            while (game.isPlaying()) {
                game.startRound();
                OutputView.showGameProcess(game.getCarPositions());
            }

            OutputView.showWinner(game.getWinnerNames());
        } catch (CarNameException | TrialTimeException e) {
            OutputView.showError(e.getMessage());
            play();
        }
    }
}
