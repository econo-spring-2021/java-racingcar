package racingcar.view;

public class TooLongNameException extends Exception{
    public TooLongNameException() {
        super("이름이 5글자를 넘어갑니다");
    }
}
