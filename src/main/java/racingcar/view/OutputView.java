package racingcar.view;

public class OutputView {
    public static void raceStartView() {
        System.out.println("실행 결과");
    }

    public static void raceResultView(String[] carNames, StringBuilder[] racingCars) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.println(carNames[i] + ": " + racingCars[i].toString());
        }
        System.out.println("");
    }
}
