package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean move(){
        int randomValue = setRandomValue();
        if(randomValue >= 4){
            position++;
            return true;
        }
        return false;
    }

    public int setRandomValue(){
        return (int)((Math.random()*10000)%10);
    }

}
