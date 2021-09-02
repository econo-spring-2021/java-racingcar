package racingcar.exception;

public class CarNameException extends Exception {
    public final static String TOO_LONG_NAME = "자동차 이름은 5글자 이하만 가능합니다.";
    public final static String NO_CAR_NAMES = "경주할 자동차 이름이 입력되지 않았습니다.";
    public final static String NO_CAR_NAME = "올바른 자동차 이름을 입력해 주세요.";

    public CarNameException(String msg) {
        super(msg);
    }
}
