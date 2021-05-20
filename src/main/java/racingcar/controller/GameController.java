package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class GameController {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_INCLUDE_CAR = 2;
    private static final int PROCESS_CRITERIA = 4;
    private ArrayList<Car> arrayCars = new ArrayList<>();

    public ArrayList<Car> getArCar() {
        return arrayCars;
    }

    public void gameStart() {
        String[] carNames;
        do {
            carNames = InputView.separateName(InputView.inputNames());
        } while (checkNameLength(carNames).contains(false) || !checkIncludeCarNum(carNames));

        for (String s : carNames) {
            arrayCars.add(new Car(s));
        }
        totalTimePlay();
        OutputView.showWinner(decideWinner());
    }

    public ArrayList<Boolean> checkNameLength(String[] carNames) {
        ArrayList<Boolean> carsContainFalse = new ArrayList<>(carNames.length);
        for (String s : carNames) {
            carsContainFalse.add(InningFiveLength(s));
        }
        return carsContainFalse;
    }

    public boolean InningFiveLength(String carName) {
        boolean result = true;
        if (carName.length() > MAX_NAME_LENGTH) {
            result = false;
        }
        return result;

    }

    public boolean checkIncludeCarNum(String[] carNames) {
        boolean answer = false;
        if (carNames.length >= MINIMUM_INCLUDE_CAR) {
            answer = true;
        }
        return answer;
    }

    public int randomValueGive() {
        return (int) (Math.random() * 10000) % 10;
    }

    public void goOrStop(Car c) {
        if (randomValueGive() >= PROCESS_CRITERIA) {
            c.progress();
        }
    }

    public void oneTimeplay() {
        for (Car c : arrayCars) {
            goOrStop(c);
            OutputView.showPlayingResult(c);
        }
    }

    public void totalTimePlay() {
        int tryCount = InputView.inputGameCount();
        OutputView.showPlayingStart();
        for (int i = 0; i < tryCount; i++) {
            oneTimeplay();
            System.out.println();
        }
    }

    public ArrayList<Car> decideWinner(){
        int max =Integer.MIN_VALUE;
        ArrayList<Car> winnerCars = new ArrayList<>();
        for(Car c : arrayCars){
            if(max < c.getPosition()){
                max=c.getPosition();
            }
        }
        for(Car c : arrayCars){
            if(c.getPosition() == max)
                winnerCars.add(c);
        }
        return winnerCars;
    };
}
