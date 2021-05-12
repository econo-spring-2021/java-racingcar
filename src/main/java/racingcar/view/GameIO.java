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

    public int inputTryCount(Scanner scanner) {
        return scanner.nextInt();
    }
}
