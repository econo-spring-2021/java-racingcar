package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.view.Constants;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private List<Car> racingCarList;
    private int trial;
    private Random random;

    public Race() {
        random = new Random();
        racingCarList = new ArrayList<>();
        this.trial = 0;
    }

    public void race(CarFactory carFactory, int trial) {
        racingCarList = carFactory.getRacingCarList();
        this.trial = trial;

        System.out.println(Constants.RACING_RESULT_MESSAGE);
        for(int count = 0; count < trial; count++) {
            startOneRound(racingCarList);
            System.out.println();
        }
    }

    private void startOneRound(List<Car> racingCarList) {
        for(Car car: racingCarList) {
            car.move(random);
        }

        for(Car car: racingCarList) {
            OutputView.showOneRoundResultByOneCar(car.getName(), car.getPosition());
        }
    }
}
