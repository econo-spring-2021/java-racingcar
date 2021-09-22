package racingcar.domain;

public class Car {
    public String carName;
    public int distance;

    public Car(String name, int d) {
        carName = name;
        distance = d;
    }

    public void moveCar(){
        distance++;
    }

    public String getCarName(){
        return carName;
    }

    public int getCarDistance(){
        return distance;
    }
}