package racingcar.controller;

public class RandomNumberGenerator implements NumberGenerator {
    public int generateNumber() {
        return (int) (Math.random() * 10);
    }
}
