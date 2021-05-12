package racingcar.view;

public class EmptyNameException extends Exception {
    public EmptyNameException() {
        super("** Exception : 이름에 공백이 포함되어있습니다 **");
    }
}
