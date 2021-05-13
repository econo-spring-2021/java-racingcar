package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.Map;

class RacingGame {
    public boolean IS_PLAYING;

    private final static int MOVE_BOUND = 10;
    private int MAX_TRIAL;

    private Cars racingCars;
    private int trialTime;

    public RacingGame(List<String> carNames, int maxTrial) {
        trialTime = 0;
        this.racingCars = new Cars();
        for (String carName: carNames) {
            racingCars.add(new Car(carName));
        }
        MAX_TRIAL = maxTrial;
        IS_PLAYING = true;
    }

    public void startRound() {
        if (!IS_PLAYING) return;
        racingCars.moveRandomAll(MOVE_BOUND);
        trialTime += 1;
        if (trialTime == MAX_TRIAL) IS_PLAYING = false;
    }

    public Map<String, Integer> getCarPositions() {
        return racingCars.getCarPositions();
    }
}
