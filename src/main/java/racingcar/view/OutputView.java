package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    public static void raceStartView() {
        System.out.println("실행 결과");
    }

    public static void raceResultView(String name, int position) {
        System.out.println(name + ": " + racingLengthView(position));
    }

    public static void emptyLineView() {
        System.out.println("");
    }

    public static void winnersView(ArrayList<String> winners) {
        StringBuilder view = new StringBuilder();
        view.append(winners.get(0));
        for (int i = 1; i < winners.size(); i++) {
            view.append(", ").append(winners.get(i));
        }
        view.append("가 최종 우승했습니다.");
        System.out.println(view.toString());
    }

    public static String racingLengthView(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
