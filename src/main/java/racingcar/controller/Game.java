package racingcar.controller;

import racingcar.view.GameIO;

import java.util.Scanner;

public class Game {
    private String[] carName;
    private int tryCount;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        GameIO io = new GameIO();

        inputGameData(scanner, io);

    }

    private void inputGameData(Scanner scanner, GameIO io) {
        try {
            io.askCarName();
            String[] inputCarName = io.inputCarNameArr(scanner);
            io.catchNameException(inputCarName);
            carName = inputCarName;

            io.askTryCount();
            String inputTryCount = io.inputTryCount(scanner);
            io.catchTryCountException(inputTryCount);
            tryCount = Integer.parseInt(inputTryCount);

            for (String s : carName) System.out.println(s + " ");
            System.out.println(tryCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputGameData(scanner, io);
        }
    }
}
