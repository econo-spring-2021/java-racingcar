package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void inputCarNameMessage() {
        System.out.println(Constants.CAR_NAME_INPUT_MESSAGE);
    }

    public static void inputTryCountMessage() {
        System.out.println(Constants.TRY_INPUT_MESSAGE);
    }

    public static void resultMessage() {
        System.out.println(Constants.RACING_RESULT_MESSAGE);
    }

    public static void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void showOneRoundResultByOneCar(String name, int position) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name + Constants.COLON + Constants.SPACE);
        for(int i = 0; i < position; i++) {
            stringBuilder.append(Constants.CAR_SHAPE);
        }
        System.out.println(stringBuilder.toString());
        //System.out.println();
    }

    public static void getWinnerMessage(List<String> winnernames) {
        System.out.println(String.join(",", winnernames + "가 최종 우승했습니다."));
    }
}
