package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class GameController {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_INCLUDE_CAR = 2;
    private static final int PROCESS_CRITERIA = 4;
    private static final String NAME_SEPARATOR = ",";
    private ArrayList<Car> arCar = new ArrayList<>();

    public ArrayList<Car> getArCar() {
        return arCar;
    }

    public void gameStart() {
        String carConnects;
        String[] carNames;
        do {
            carConnects = InputView.inputNames();
            carNames = separateName(carConnects);
        } while (checkNameLength(carNames).contains(false) || !checkIncludeCarNum(carNames));

        for (String s : carNames) {
            arCar.add(new Car(s));
        }
        totalPlayGame();
        OutputView.showWinner(decideWinner());
    }

    public String[] separateName(String names) {
        return names.split(NAME_SEPARATOR);
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

    public void oneTimeplayGame() {
        for (Car c : arCar) {
            goOrStop(c);
            OutputView.showPlayingResult(c);
        }
    }

    public void totalPlayGame() {
        int tryCount = InputView.inputGameCount();
        OutputView.showPlayingStart();
        for (int i = 0; i < tryCount; i++) {
            oneTimeplayGame();
            System.out.println();
        }
    }

    public ArrayList<Car> decideWinner(){
        int max =Integer.MIN_VALUE;
        ArrayList<Car> winnerCars = new ArrayList<>();
        for(Car c : arCar){
            if(max < c.getPosition()){
                max=c.getPosition();
            }
        }
        for(Car c : arCar){
            if(c.getPosition() == max)
                winnerCars.add(c);
        }
        return winnerCars;
    };
}
