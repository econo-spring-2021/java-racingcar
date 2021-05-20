package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;
    private static final int PROCESS_CRITERIA = 4;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void progress(int randomValue){
        if(randomValue>=PROCESS_CRITERIA)
            this.position++;
    }
}
