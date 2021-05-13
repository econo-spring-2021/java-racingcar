package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class RacingGame {
    public final static int MOVE_BOUND = 10;

    public int trialTime;
    private Cars racingCars;

    public RacingGame(List<String> carNames, int trial) {
        this.racingCars = new Cars();
        for (String carName: carNames) {
            racingCars.add(new Car(carName));
        }
        trialTime = trial;
    }

    public void start() {
        racingCars.moveRandomAll(MOVE_BOUND);
    }
}
