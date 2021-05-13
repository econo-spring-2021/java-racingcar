package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class GameController {
    private final int MAX_NAME_LENGTH = 5;
    private static final int PROCESS_CRITERIA = 4;
    private final String NAME_SEPARATOR=",";
    private ArrayList<Car> arCar = new ArrayList<>();
    private String names;
    private int tryCount;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();


    public void gameStart(){
        separateName();
        tryCount = inputView.inputGameCount();
        outputView.showPlayingStart();
        totalPlayGame();
    }

    public void separateName() {
        names = inputView.inputNames();
        StringTokenizer st = new StringTokenizer(names, NAME_SEPARATOR);
        String part;
        do {
            part = st.nextToken();
            arCar.add(new Car(part));
        } while (st.hasMoreTokens() && checkNameLength(part));
    }

    public boolean checkNameLength(String s) {
        boolean answer = false;
        if (s.length() <= MAX_NAME_LENGTH) {
            answer = true;
        }
        return answer;
    }

    public int randomValueGive(){
        return (int)(Math.random()*10000)%10;
    }

    public void goOrStop(Car c){
        if(randomValueGive() > PROCESS_CRITERIA){
            c.progress();
        }
    }

    public void oneTimeplayGame(){
        for (Car c : arCar){
            goOrStop(c);
            outputView.showPlayingResult(c);
        }
    }

    public void totalPlayGame(){
        for (int i=0; i<tryCount; i++){
            oneTimeplayGame();
            System.out.println();
        }
    }

}
