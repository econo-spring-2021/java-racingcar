package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.GameIO;

import java.util.Scanner;

public class GameController {
    Scanner scanner;
    Game game;
    GameIO io;

    public void start() {
        scanner = new Scanner(System.in);
        game = new Game();
        io = new GameIO();

        inputGameData();
        generateCar(game.getCarName());
        simulateRace();
    }

    private void inputGameData() {
        try {
            io.askCarName();
            String[] inputCarName = io.inputCarNameArr(scanner);
            io.catchNameException(inputCarName);
            game.setCarName(inputCarName);

            io.askTryCount();
            String inputTryCount = io.inputTryCount(scanner);
            io.catchTryCountException(inputTryCount);
            game.setTryCount(Integer.parseInt(inputTryCount));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputGameData();
        }
    }

    private void generateCar(String[] carName) {
        Car[] car = new Car[carName.length];
        for (int i = 0; i < car.length; i++) {
            Car generatedCar = new Car(carName[i]);
            car[i] = generatedCar;
        }
        game.setCar(car);
    }

    private void simulateRace() {
        io.printStartingRace();
        for (int i = 0; i < game.getTryCount(); i++) {
            raceAllCarOnce();
            io.printRaceResult(game.getCar());
        }

        io.printWinner(game.getWinner());
    }

    private void raceAllCarOnce() {
        for (Car car : game.getCar()) {
            car.raceOnce();
        }
    }
}
