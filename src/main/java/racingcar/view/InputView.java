package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String INIT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표 (, ) 기준으로 구분)";
    private static final String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private static Scanner input = new Scanner(System.in);

    public String inputNames() {
        System.out.println(INIT_MESSAGE);
        return input.nextLine().replaceAll(" ","").trim();
    }

    public int inputGameCount() {
        System.out.println(INPUT_COUNT_MESSAGE);
        return input.nextInt();
    }

}
