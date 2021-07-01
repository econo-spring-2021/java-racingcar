package racingcar.view;

import Util.Parser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames(String delimiter) {
        System.out.println(String.format(Message.ASK_CAR_NAMES, delimiter));
        String input = scanner.nextLine();
        if (input.length() <= 0) return null;
        return Parser.parse(input, delimiter);
    }

    public static int inputTrialTime() {
        System.out.println(Message.ASK_TRIAL_TIME);
        String input = scanner.nextLine();
        if (input.length() <= 0) return 0;
        return Integer.parseInt(input);
    }
}
