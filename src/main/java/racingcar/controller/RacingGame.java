package racingcar.controller;

import Util.NumberGenerator;
import Util.RandomNumGenerator;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.exception.CarNameException;
import racingcar.exception.TrialTimeException;

import java.util.List;
import java.util.Map;

class RacingGame {
    private final static int RAND_VAL_BOUND = 10;
    public final static int CAN_MOVE_MIN_VAL = 4;

    private int maxTrial;
    private boolean status;

    private Cars racingCars;
    private NumberGenerator numberGenerator;

    private int trialTime;

    public RacingGame(List<String> carNames, int maxTrial) throws CarNameException, TrialTimeException {
        if (carNames == null) throw new CarNameException(CarNameException.NO_CAR_NAMES);
        if (maxTrial <= 0) throw new TrialTimeException();

        this.racingCars = new Cars();
        this.numberGenerator = new RandomNumGenerator(RAND_VAL_BOUND);

        for (String carName : carNames) {
            racingCars.add(new Car(carName, numberGenerator));
        }
        this.trialTime = 0;
        this.maxTrial = maxTrial;
        this.status = true;
    }

    public boolean isPlaying() {
        return this.status;
    }

    public void startRound() {
        if (!status) return;
        racingCars.moveRandomAll(RAND_VAL_BOUND, CAN_MOVE_MIN_VAL);
        trialTime += 1;
        if (trialTime >= maxTrial) status = false;
    }

    public Map<String, Integer> getCarPositions() {
        return racingCars.getCarPositions();
    }

    public List<String> getWinnerNames() {
        int winPosition = racingCars.getTopPosition();
        return racingCars.getCarNamesAt(winPosition);
    }
}
