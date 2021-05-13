package racingcar.view;

import racingcar.Message;

import java.util.Scanner;

public class InputView {
    Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String inputCarNames() {
        System.out.println(Message.ASK_CAR_NAMES);
        return scanner.nextLine();
    }

    public String inputTrialTime() {
        System.out.println(Message.ASK_TRIAL_TIME);
        return scanner.nextLine();
    }
}
