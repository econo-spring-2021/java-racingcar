package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.ParticipatingCar;
import racingcar.view.InputView;
import racingcar.view.InputViewException;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private InputView inputView;
    private ParticipatingCar participatingCar;
    private Race race;

    public Game() {
        inputView = new InputView();
        race = new Race();
    }

    public void play() {
        try {
            scanner = new Scanner(System.in);
            participatingCar = new ParticipatingCar();
            inputView.inputCarNames(scanner);
            String[] carName = inputView.getCarNames();
            inputView.inputTryCount(scanner);
            int trial = inputView.getCount();

            for (int indexOfCars = 0; indexOfCars < carName.length; indexOfCars++) { // 레이싱 경기에 참여하는 출전 자동차들
                Car car = new Car(carName[indexOfCars]);
                participatingCar.addRacingCar(car);
            }

            race.race(participatingCar, trial);
            race.getWinner(participatingCar.getRacingCarList());

        } catch(InputViewException e) {
            OutputView.showErrorMessage(e.getMessage());
            play();
        }
    }
}
