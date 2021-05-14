package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.GameIO;

import java.util.HashMap;

public class GameController {
    Game game;
    GameIO io;
    String[] inputtedCarNames;
    int inputtedTryCount;

    public void start() {
        io = new GameIO();

        inputCarNames();
        inputTryCount();
        game = new Game(inputtedCarNames, inputtedTryCount);
        simulateRace();
    }

    private void inputCarNames() {
        try {
            io.askCarNames();
            String[] carNames = io.inputCarNames();
            io.catchNameException(carNames);

            inputtedCarNames = carNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputCarNames();
        }
    }

    private void inputTryCount() {
        try {
            io.askTryCount();
            String tryCount = io.inputTryCount();
            io.catchTryCountException(tryCount);

            inputtedTryCount = Integer.parseInt(tryCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputTryCount();
        }
    }

    private void simulateRace() {
        io.printStartingRace();
        for (int i = 0; i < game.getTryCount(); i++) {
            raceAllCarOnce();
            io.printRaceResult(getRaceResultHashMap());
        }

        io.printWinner(game.getWinnerNames());
    }

    ;

    private void raceAllCarOnce() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (Car car : game.getCars()) {
            car.raceOnce(randomNumberGenerator);
        }
    }

    private HashMap<String, Integer> getRaceResultHashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (Car car : game.getCars()) {
            hashMap.put(car.getName(), car.getPosition());
        }

        return hashMap;
    }
}
