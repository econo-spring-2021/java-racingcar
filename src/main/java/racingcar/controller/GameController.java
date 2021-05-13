package racingcar.controller;

import Util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
        game = new RacingGame(Parser.parse(carNames, CAR_NAME_DELIMITER), trialTime);
    }
}
