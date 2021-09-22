package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.PrintView;
import racingcar.view.RacingView;
import java.util.ArrayList;

public class RacingController{
    private static final int MAXIMUM_CAR_LENGTH = 5;

    RacingView racingView = new RacingView();
    PrintView printView = new PrintView();

    ArrayList<String> racingCars;
    ArrayList<Car> carObject = new ArrayList<Car>();

    ArrayList<String> winners = new ArrayList<String>();


    int tryNumber;
    public int randomNumber;

    public void startGame(){
        racingView.inputCarNames();
        racingView.inputTryNumber();

        racingCars = racingView.getRacingCars();
        tryNumber = racingView.getTryNumber();

        assignCars();
        startRacing();

        printView.printRacingWinner(winners);
    }

    private void assignCars(){
        for (int i=0; i < racingCars.size(); i++){
            String carName = racingCars.get(i);

            carObject.add(new Car(carName, 0));
        }
    }

    private void startRacing(){
        printView.printGameResult();
        System.out.println(tryNumber);

        for (int i = 0; i < tryNumber; i++){
            startOneRound();
        }
        findWinner();
    }

    private void startOneRound(){
        for (int i = 0; i < racingCars.size(); i++){
            int randomNumber = generateRandomNumber();
            judgeMovement(randomNumber, i);
        }

        printView.printRacingResult(carObject);
    }

    private void judgeMovement(int number, int i){
        if (number > MAXIMUM_CAR_LENGTH){
            carObject.get(i).moveCar();
        }
    }

    private ArrayList<String> findWinner(){
        int maxDistance = carObject.get(0).getCarDistance();

        winners.add(carObject.get(0).getCarName());

        for(int i = 0; i < racingCars.size(); i++){
            int distance = carObject.get(i).getCarDistance();

            if (maxDistance < distance){
                maxDistance = distance;
                winners.removeAll(winners);
            }
            if (maxDistance == distance){
                maxDistance = distance;
                winners.add(carObject.get(i).getCarName());
            }
        }

        winners = duplicateCheck(winners);

        return winners;
    }

    private ArrayList<String> duplicateCheck(ArrayList<String> arrayList){
        ArrayList<String> resultList = new ArrayList<String>();

        for (int i = 0; i < arrayList.size(); i++){
            if (!resultList.contains(arrayList.get(i))){
                resultList.add(arrayList.get(i));
            }
        }

        return resultList;
    }

    private int generateRandomNumber(){
        randomNumber = (int) (Math.random()*10);

        return randomNumber;
    }
}