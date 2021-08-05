package racingcar.view;

import racingcar.controller.Controller;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.Scanner;

public class Racing{

    public void inputNames(){
        Scanner scanner = new Scanner(System.in);

        /*
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        
        String racingCars = scanner.nextLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        Integer tryNumbers = scanner.nextInt();

        String[] carNames = racingCars.split(", ");

        Car firstCar = new Car(carNames[0], "---", 1);
        Car secondCar = new Car(carNames[1], "-", 2);
        Car thirdCar = new Car(carNames[2], "----", 3);

         */

        Controller controller = new Controller();
        System.out.println("랜덤 숫자 생성"+controller.generateNumber());

        int number = controller.generateNumber();
        System.out.println(controller.judgeNumber(number));

        // System.out.println("숫자 판별 결과"+controller.judgeNumber(number));

        /*
        System.out.println(Arrays.toString(carNames));
        System.out.println(tryNumbers);

         */

    };
};
