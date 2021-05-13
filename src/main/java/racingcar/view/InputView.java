package racingcar.view;

import racingcar.Message;

import java.util.Scanner;

public class InputView {
    Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String inputCarNames(String delimiter) {
        System.out.println(String.format(Message.ASK_CAR_NAMES, delimiter));
        return scanner.nextLine();
    }

    public int inputTrialTime() {
        System.out.println(Message.ASK_TRIAL_TIME);
        return Integer.parseInt(scanner.nextLine());
    }
}
