package racingcar.view;

public class InputView {
    public static void carNameInputView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void checkCarNameInputView() {
        System.out.println("다시 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void tryNumberInputView() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void checkTryNumberInputView() {
        System.out.println("시도할 횟수는 0이상으로 입력해주세요.");
    }
}
