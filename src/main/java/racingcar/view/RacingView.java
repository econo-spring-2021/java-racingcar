package racingcar.view;

import java.util.ArrayList;
import java.util.Scanner;


public class RacingView {
    Scanner scanner = new Scanner(System.in);

    public ArrayList<String> racingCars = new ArrayList<String>();
    public int tryNumber;

    public void inputRacingCar(){
        System.out.println("경주할 자동차 이름을 입력합니다. 이름은 5자 이하만 가능합니다. (이름은 쉼표(,) 기준으로 구분됩니다.)");
        String carNames = scanner.nextLine();
        String[] cars = carNames.split(", ");

        for (int i = 0; i < cars.length; i++){
            checkName(cars[i]);
        }

        System.out.println("시도할 횟수는 몇 번인가요?");
        tryNumber = scanner.nextInt();
    }

    private void checkName(String carName){
        if (carName.length() > 5){
            System.out.println(carName+ " : 은 5글자 이상입니다. 다시 입력하세요.");
            tryInputName();
        }
        if (carName.length()<=5){
            racingCars.add(carName);
            System.out.println(carName+"경주 차량 등록이 완료되었습니다.");
        }
    }

    private void tryInputName(){
        Scanner scanner = new Scanner(System.in);
        String carName = scanner.nextLine();
        checkName(carName);
    }

    public void printGameResult(){
        System.out.println("실행 결과");
    }

    public void printBlankLine(){
        System.out.println("");
    }

    public void printRacingBroadCast(String carName, int distance){
        System.out.println(String.format("%s: %s", carName, printDistance(distance)));
    }

    public String printDistance(int distance){
        ArrayList<String> stringArrayList = new ArrayList<String>();

        for (int i=0; i < distance; i++){
            stringArrayList.add("-");
        }

        String stringDistance = String.join("", stringArrayList);
        return stringDistance;
    }

    public void printRacingWinner(ArrayList winners){
        String stringWinner = String.join(", ", winners);
        System.out.println(stringWinner+"가 최종 우승했습니다.");
    }

    public ArrayList<String> getRacingCars(){
        return racingCars;
    }

    public Integer getTryNumber(){
        return tryNumber;
    }
}