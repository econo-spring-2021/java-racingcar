package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {
    private static int max = 0;
    private static ArrayList<Car> cars;
    private static String[] carNames;

    public static void main(String[] args) throws IOException {
        InputView.carNameInputView();
        carNames = carNameInput();
        cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        int tryNumber = tryNumberInput();
        StringBuilder[] racingCars = new StringBuilder[cars.size()];
        racingCarsInit(racingCars);

        OutputView.raceStartView();
        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < cars.size(); j++) {
                racingCars[j] = racingCarMove(cars.get(j).move(), racingCars[j]);
            }
            OutputView.raceResultView(carNames, racingCars);
        }
        ArrayList<String> winners = getWinner();
        OutputView.winnersView(winners);
    }

    public static ArrayList<String> getWinner() {
        getMaxPosition();
        ArrayList<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == max) {
                winners.add(carNames[i]);
            }
        }
        return winners;
    }

    public static void getMaxPosition() {
        int position;
        for (int i = 0; i < cars.size(); i++) {
            position = cars.get(i).getPosition();
            if (max < position) {
                max = position;
            }
        }
    }

    public static StringBuilder[] racingCarsInit(StringBuilder[] racingCars) {
        for (int i = 0; i < racingCars.length; i++) {
            racingCars[i] = new StringBuilder("");
        }
        return racingCars;
    }

    public static StringBuilder racingCarMove(boolean isMoving, StringBuilder racingCar) {
        if (isMoving) {
            racingCar.append("-");
            return racingCar;
        }
        return racingCar;
    }

    public static String[] carNameInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carNameInput = br.readLine();
        String[] carNames = getCarNames(carNameInput);
        checkCarNameInput(carNames.length);
        return carNames;
    }

    public static String[] getCarNames(String carNameInput) {
        String[] carNames = carNameInput.split(",");
        return carNames;
    }

    public static void checkCarNameInput(int number) throws IOException {
        if (number > 5) {
            InputView.checkCarNameInputView();
            carNameInput();
        }
    }

    public static int tryNumberInput() throws IOException {
        InputView.tryNumberInputView();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNumber = Integer.parseInt(br.readLine());
        checkTryNumberInput(tryNumber);
        return tryNumber;
    }

    public static void checkTryNumberInput(int tryNumber) throws IOException {
        if (tryNumber <= 0) {
            InputView.checkTryNumberInputView();
            tryNumberInput();
        }
    }
}
