package racingcar.controller;

import Util.Parser;
import racingcar.view.InputView;
import racingcar.view.NameException;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    public final static String CAR_NAME_DELIMITER = ",";

    InputView inputView;
    OutputView outputView;
    RacingGame game;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        game = null;
    }

    public void play() {
        String carNames = inputView.inputCarNames(CAR_NAME_DELIMITER);
        int trialTime = inputView.inputTrialTime();

        try {
            game = new RacingGame(checkValidation(carNames), trialTime);

            outputView.showGameStartMsg();
            while (game.isPlaying()) {
                game.startRound();
                outputView.showGameProcess(game.getCarPositions());
            }

            outputView.showWinner(game.getWinnerNames());
        } catch (NameException e) {
            outputView.showError(e.getMessage());
            play();
        }

    }

    private List<String> checkValidation(String carNames) throws NameException {
        if (carNames.length() <= 0) {
            throw new NameException(NameException.NO_NAME_ERROR);
        }

        List<String> _carNames = Parser.parse(carNames, CAR_NAME_DELIMITER);
        for (String carName : _carNames) {
            if (carName.length() > 5) {
                throw new NameException(NameException.TOO_LONG_NAME_ERROR);
            }
        }

        return _carNames;
    }
}
