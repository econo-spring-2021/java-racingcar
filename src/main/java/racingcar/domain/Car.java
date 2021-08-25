package racingcar.domain;

public class Car {

    public String carName;
    public int movement;
    public int distance;

    public Car(String name, int number, int d) {
        carName = name;
        movement = number;
        distance = d;
    }

    public String getCarName(){
        return carName;
    }

    public void setCarMovement(int number){
        movement = number;
    }

    public void setCarDistance(int d){
        distance = d;
    }

    public int getCarDistance(){
        return distance;
    }
}