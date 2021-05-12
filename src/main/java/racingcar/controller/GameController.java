package racingcar.controller;

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
}
