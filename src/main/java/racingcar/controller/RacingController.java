package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.RacingView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RacingController{
    RacingView racingView = new RacingView();

    ArrayList<String> racingCars;
    ArrayList<Car> carObject = new ArrayList<Car>();

    ArrayList<String> winners = new ArrayList<String>();


    int tryNumber;
    public int randomNumber;

    public void startGame(){
        racingView.inputRacingCar();

        racingCars = racingView.getRacingCars();
        tryNumber = racingView.getTryNumber();

        assignCars();

        startRacing();

        racingView.printBlankLine();
        racingView.printRacingWinner(winners);
    }

    private void assignCars(){
        for (int i=0; i < racingCars.size(); i++){
            String carName = racingCars.get(i);

            carObject.add(new Car(carName, 0, 0));
        }
    }

    public void startRacing(){
        racingView.printGameResult();

        for (int i = 0; i < tryNumber; i++){
            startOneRound();

        }
        findWinner();
    }

    public void startOneRound(){

        String name;
        int d;

        racingView.printBlankLine();

        for (int i = 0; i < racingCars.size(); i++){
            int movement = judgeRandomNumber(generateRandomNumber());
            int distance = carObject.get(i).getCarDistance();
            int totalDistance = movement + distance;
            carObject.get(i).setCarMovement(movement);
            carObject.get(i).setCarDistance(totalDistance);

            name = carObject.get(i).getCarName();
            d = carObject.get(i).getCarDistance();

            racingView.printRacingBroadCast(name, d);
        }
    }

    public ArrayList<String> findWinner(){
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

    public ArrayList<String> duplicateCheck(ArrayList<String> arrayList){
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

    private int judgeRandomNumber(int randomNumber){
        int movement = 0;

        if (randomNumber >=4){
            movement = 1;
        }
        if (randomNumber < 4){
            movement = 0;
        }
        return movement;
    }
}