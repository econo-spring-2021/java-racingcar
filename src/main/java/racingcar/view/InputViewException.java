package racingcar.view;

public class InputViewException extends Exception {
    public InputViewException() {
        super(Constants.CAR_NAMING_RULE_MESSAGE);
    }
}
