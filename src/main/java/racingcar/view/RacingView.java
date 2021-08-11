package racingcar.view;

import racingcar.controller.Controller;

import java.util.Arrays;
import java.util.Scanner;

public class RacingView {

    Scanner scanner = new Scanner(System.in);

    // 경주할 자동차
    public String[] racingCars = new String[10];


    int racingCarCount = 0;

    // 경주 자동차 입력
    public void inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요. 이름은 5자 이하만 가능합니다. (이름은 쉼표(,) 기준으로 구분)");
        String carNames = scanner.nextLine();
        String[] Cars = carNames.split(", ");

        for(int i = 0; i <Cars.length; i++){
            String carName = Cars[i];
            checkName(carName);
        }

        System.out.println(Arrays.toString(Cars));
    }

    // 자동차 이름 재입력
    public void tryInputName(){
        String carName = scanner.nextLine();
        checkName(carName);
    }

    // 자동차 이름 글자 수
    public void checkName(String carName){
        if (carName.length() > 5){
            System.out.println(carName + " : 은 5글자 이상입니다. 다시 입력하세요.");
            tryInputName();
        }
        if (carName.length() <= 5){
            System.out.println(carName +" : 경주 차량으로 등록 완료되었습니다. ");
            racingCars[racingCarCount] = carName;
            racingCarCount+= 1;
        }
    }

    public void printResult(){
        System.out.println(Arrays.toString(racingCars));
    }



    // 경주 시도 횟수 입력
    public void inputTryNumber (){
        System.out.println("시도할 횟수는 몇 회인가요?");
        Integer tryNumber = scanner.nextInt();
    }

    // 랜덤한 숫자 출력
    public int generateRandomNumber(){
        int randomNumber = (int)(Math.random()*10);
        System.out.println(randomNumber);
        return randomNumber;
    }
}
