package racingcar.view;

import racingcar.controller.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static racingcar.controller.Controller.getCarObjects;

public class RacingView {
    private static int racingCarCount;
    static List<String> racingCars = new ArrayList<String>();
    // public static Object[] cars;

    private static int tryNumber;

    public static void main(){
        Scanner scanner = new Scanner(System.in);

        // 경주할 자동차 입력
        System.out.println("경주할 자동차 이름을 입력하세요. 이름은 5자 이하만 가능합니다. (이름은 쉼표(,) 기준으로 구분됩니다.)");
        String carNames = scanner.nextLine();
        String[] Cars = carNames.split(", ");

        // 입력한 자동차 검사
        for (int i = 0; i <Cars.length; i++){
            String carName = Cars[i];
            checkName(carName);
        }

        // 경주 시도 횟수 입력하기
        System.out.println("시도할 회수는 몇 회인가요?");
        tryNumber = scanner.nextInt();
    }

    public static void checkName(String carName){
        if (carName.length() > 5){
            System.out.println(carName + " : 은 5글자 이상입니다. 다시 입력하세요.");
            tryInputName();
        }
        if (carName.length()<=5){
            // racingCars[racingCarCount] = carName;
            // racingCarCount = 0;
            racingCars.add(racingCarCount, carName);
            racingCarCount+=1;
            System.out.println(carName+"경주 차량 등록 완료되었습니다. ");
        }
    }

    public static void tryInputName(){
        Scanner scanner = new Scanner(System.in);
        String carName = scanner.nextLine();
        checkName(carName);
    }

    public static List<String> getRacingCars() {
        return racingCars;
    }


    public static int getTryNumber(){
        return tryNumber;
    }
}