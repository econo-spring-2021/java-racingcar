package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.RacingView;

import java.util.ArrayList;

public class RacingController{
    RacingView racingView = new RacingView();

    ArrayList<String> racingCars;
    ArrayList<Car> carObject = new ArrayList<Car>();
    int tryNumber;
    public int randomNumber;

    public void startGame(){
        racingView.inputRacingCar();

        racingCars = racingView.getRacingCars();
        tryNumber = racingView.getTryNumber();

        assignCars();
        startRacing();

    }

    private void assignCars(){
        for (int i=0; i < racingCars.size(); i++){
            String carName = racingCars.get(i);

            carObject.add(new Car(carName, 0, 0));
        }
    }

    public void startRacing(){
        for (int i = 0; i < tryNumber; i++){
            startOneRound();
        }
        findWinner();
    }

    public ArrayList<Car> startOneRound(){

        for (int i = 0; i < racingCars.size(); i++){
            int movement = judgeRandomNumber(generateRandomNumber());
            int distance = carObject.get(i).getCarDistance();
            int totalDistance = movement + distance;
            carObject.get(i).setCarMovement(movement);
            carObject.get(i).setCarDistance(totalDistance);
        }

        return carObject;
    }

    public ArrayList<String> findWinner(){
        ArrayList<String> winners = new ArrayList<String>();
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
        return winners;
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