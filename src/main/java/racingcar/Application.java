package racingcar;

import racingcar.view.RacingView;

public class Application{

    public static void main(String[] args) {

        RacingView racingView = new RacingView();
        racingView.inputNames();
        // racingView.generateRandomNumber();

        System.out.println("경주할 자동차를 출력합니다.");
        racingView.printResult();
    }
}
