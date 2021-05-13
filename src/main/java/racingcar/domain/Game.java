package racingcar.domain;

public class Game {
    private Car[] car;
    private String[] carName;
    private int tryCount;

    public Car[] getCar() {
        return car;
    }

    public String[] getCarName() {
        return carName;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setCar(Car[] _car) {
        car = _car;
    }

    public void setCarName(String[] _carName) {
        carName = _carName;
    }

    public void setTryCount(int _tryCount) {
        tryCount = _tryCount;
    }
}
