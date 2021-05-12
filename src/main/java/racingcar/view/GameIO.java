package racingcar.view;

import java.util.Scanner;

public class GameIO {
    public void askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void askTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String[] inputCarNameArr(Scanner scanner) {
        return scanner.nextLine().replaceAll(" ", "").split(",");
    }

    public String inputTryCount(Scanner scanner) {
        return scanner.nextLine().replaceAll(" ", "");
    }

    public void catchNameException(String[] name) throws EmptyNameException, TooLongNameException {
        for (String n : name) {
            catchEmptyName(n);
            catchTooLongName(n);
        }
    }

    public void catchEmptyName(String name) throws EmptyNameException {
        if (name == "") throw new EmptyNameException();
    }

    public void catchTooLongName(String name) throws TooLongNameException {
        if (name.length() > 5) throw new TooLongNameException();
    }

    public void catchTryCountException(String count) throws NotProperInputTypeException {
        boolean isDigit =  count.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isDigit) throw new NotProperInputTypeException();

    }
}
