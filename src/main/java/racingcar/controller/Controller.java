package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.RacingView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.RacingView.getTryNumber;

public class Controller {
    public static List<String> racingCars = getRacingCars();
    public static int tryNumber = getTryNumber();
    // static List<Object> cars = new ArrayList<Object>();

    private static int racingCarCount = racingCars.size();
    private static Car[] cars = new Car[10];

    private String carName;
    private int randomNumber;
    private int distance;

    public static void main() {

        // 자동차 할당
        assignCars();

        System.out.println("실행 결과");
        // 횟수만큼 경기 진행
        for (int j = 0; j < tryNumber; j++){
            startRacing();
            printPlay();
            System.out.println("");
        }
    }

    /*
    // 가장 많이 움직인 자동차 출력
    public static void judgeWinner(){
        int movement[] = {};
        for(int i = 0; i < racingCarCount; i++){
            movement[i] = cars[i].distance;
        }

        int max = movement[0];
        for (int j = 0; j < movement.length; j++){
            if (max < movement[j]){
                max = movement[j];
            }
        }
    }

     */

    // 자동차 할당
    public static void assignCars(){
        for(int i = 0; i <racingCarCount; i++){
            cars[i] = new Car();
            cars[i].carName = racingCars.get(i);
        }
    }

    // 경주 시작
    public static void startRacing(){
        for (int i = 0; i < racingCarCount; i++){
            cars[i].randomNumber = generateRandomNumber();
            cars[i].distance += judgeRandomNumber(cars[i].randomNumber);
        }
    }

    // 자동차 진행상황 출력
    public static void printPlay(){

        for(int i = 0; i <racingCarCount; i++){
            System.out.print(cars[i].carName+": ");
            printMovement(cars[i].distance);
            System.out.println();
        }
    }

    public static Object[] getCarObjects() {

        return cars;
    }

    // 자동차 가져오기
    public static List<String> getRacingCars(){
        RacingView racingView = new RacingView();
        List<String> racingCars = racingView.getRacingCars();
        System.out.println(racingCars);

        return racingCars;
    }

    // 랜덤한 숫자 생성 후 움직이는 거리 판별
    public static int generateRandomNumber(){
        int randomNumber = (int)(Math.random()*10);
        // int movement = judgeRandomNumber(randomNumber);
        return randomNumber;
    }

    // 랜덤한 숫자의 크기 판별
    public static int judgeRandomNumber(int randomNumber){
        int movement = 0;
        if (randomNumber >= 4){
            movement = 1;
        }
        if (randomNumber < 4){
            movement = 0;
        }
        return movement;
    }

    public static void printMovement(int movement){
        for(int i = 0; i < movement; i++){
            System.out.print("-");
        }
    }
}
