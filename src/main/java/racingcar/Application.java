package racingcar;

import racingcar.controller.Controller;
import racingcar.view.RacingView;

public class Application{

    public static void main(String[] args) {

        RacingView racingView = new RacingView();
        racingView.main();

        Controller controller = new Controller();
        controller.main();


        // racingView.getRacingCars();
        /*
        racingView.inputNames();
        // racingView.generateRandomNumber();

        System.out.println("경주할 자동차를 출력합니다.");
        racingView.printResult();

        System.out.println("Controller.class 에서 자동차를 출력합니다. ");
        controller.printControllerResult();
         */
    }


}
