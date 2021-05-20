package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;


public class OutputView {
    private static final String PLAYING_RESULT_MESSAGE = "실행 결과";
    private static final String progress_status = "-";
    private static final String seperator = ":";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static String showProgressStatus(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(progress_status);
        }
        return sb.toString();
    }

    public static void showPlayingStart() {
        System.out.println();
        System.out.println(PLAYING_RESULT_MESSAGE);
    }

    public static void showPlayingResult(String name,int position) {
        System.out.println(name + seperator + " " + showProgressStatus(position));
    }

    public static void showWinner(ArrayList<String> winnerNames) {
        StringBuilder sb = new StringBuilder();
        for(String s : winnerNames)
            sb.append(s+", ");
        sb.append(WINNER_MESSAGE);
        System.out.println(sb);
    }
}
