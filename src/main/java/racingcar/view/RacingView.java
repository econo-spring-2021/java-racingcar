package racingcar.view;

import java.util.Scanner;

public class RacingView {
    Scanner scanner = new Scanner(System.in);

    // 경주 자동차 입력
    public void inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carNames = scanner.nextLine();
        String[] racingCars = carNames.split(", ");
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
