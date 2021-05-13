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

    public String[] getWinner() {
        String[] winner = new String[car.length];
        int maxPosition = getMaxPosition();

        for (int i = 0; i < car.length; i++) {
            winner[i] = car[i].getNameIfPositionSameOrEmpty(maxPosition);
        }

        return winner;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car c : car) {
            max = c.getPositionIfBiggerOrComp(max);
        }

        return max;
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
