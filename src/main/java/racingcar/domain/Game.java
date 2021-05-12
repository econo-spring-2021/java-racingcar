package racingcar.domain;

public class Game {
    private String[] carName;
    private int tryCount;

    public String[] getCarName() {
        return carName;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setCarName(String[] _carName) {
        carName = _carName;
    }

    public void setTryCount(int _tryCount) {
        tryCount = _tryCount;
    }
}
