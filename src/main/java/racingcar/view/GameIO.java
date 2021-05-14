package racingcar.view;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameIO {
    private final static int LONGNAME_STANDARD = 5;

    private Scanner scanner = new Scanner(System.in);

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public void askTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printStartingRace() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(HashMap<String, Integer> results) {
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            drawPosition(entry.getValue());
        }
        System.out.println();
    }

    private void drawPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(String[] winner) {
        printNameList(winner);
        System.out.println("가 최종 우승했습니다.");
    }

    private void printNameList(String[] name) {
        for (int i = 0; i < name.length; i++) {
            printNameSpot(name[i], i);
            System.out.print(name[i]);
        }
    }

    private void printNameSpot(String name, int idx) {
        if (idx == 0 || name.equals("")) return;

        System.out.print(".");
    }

    public String[] inputCarNames() {
        return scanner.nextLine().replaceAll(" ", "").split(",");
    }

    public String inputTryCount() {
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
        if (name.length() > LONGNAME_STANDARD) throw new TooLongNameException();
    }

    public void catchTryCountException(String count) throws NotProperInputTypeException {
        boolean isDigit = count.matches("[+-]?\\d*(\\.\\d+)?");
        if (!isDigit) throw new NotProperInputTypeException();

    }
}
