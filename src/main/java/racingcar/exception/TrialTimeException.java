package racingcar.exception;

public class TrialTimeException extends Exception{
    public final static String NO_TRIAL_INPUT = "올바른 시도 횟수를 입력해 주세요.";

    public TrialTimeException() {
        super(NO_TRIAL_INPUT);
    }

    public TrialTimeException(String msg) {
        super(msg);
    }
}
