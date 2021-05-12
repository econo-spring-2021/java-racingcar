package racingcar.view;

public class NotProperInputTypeException extends Exception {
    public NotProperInputTypeException() {
        super("올바르지 않는 타입의 입력입니다.");
    }
}
