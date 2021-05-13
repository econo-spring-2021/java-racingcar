package racingcar.view;

import java.util.ArrayList;

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

    public static void winnersView(ArrayList<String> winners){
        StringBuilder view = new StringBuilder();
        view.append(winners.get(0));
        for(int i=1;i<winners.size();i++){
                view.append(", ").append(winners.get(i));
        }
        view.append("가 최종 우승했습니다.");
        System.out.println(view.toString());
    }
}
