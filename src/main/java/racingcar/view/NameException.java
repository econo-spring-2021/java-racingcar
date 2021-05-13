package racingcar.view;

public class NameException extends Exception {
    public final static String TOO_LONG_NAME_ERROR = "자동차 이름은 5글자 이하만 가능합니다.";
    public final static String NO_NAME_ERROR = "경주할 자동차 이름이 입력되지 않았습니다.";

    public NameException(String msg) {
        super(msg);
    }
}
