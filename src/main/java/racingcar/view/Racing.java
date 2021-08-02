package racingcar.view;

import java.util.Arrays;
import java.util.Scanner;

public class Racing {
    public void inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        Scanner scanner = new Scanner(System.in);
        String racingCars = scanner.nextLine();

        String[] carNames = racingCars.split(", ");

        System.out.println(Arrays.toString(carNames));
    };
};
