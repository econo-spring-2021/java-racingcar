package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    public static final String PLAYING_RESULT_MESSAGE = "실행 결과";
    public static final String progress_status = "-";
    public static final String seperator = ":";
    public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public String showProgressStatus(int position){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<position; i++){
            sb.append(progress_status);
        }
        return sb.toString();
    }

    public void showPlayingStart(){
        System.out.println();
        System.out.println(PLAYING_RESULT_MESSAGE);
    }

    public void showPlayingResult(Car c){
        System.out.println(c.getName()+seperator+" "+showProgressStatus(c.getPosition()));
    }

    public void showWinner(Car c){
        StringBuilder sb = new StringBuilder();
        System.out.println();
    }
}
