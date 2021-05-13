package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public final static String CAR_SHAPE = "-";

    public void showGameStartMsg() {
        System.out.println('\n' + Message.GAME_START);
    }

    public void showGameProcess(Map<String, Integer> carPositions) {
        carPositions.forEach((carName, carPosition) -> {
            StringBuilder builder = new StringBuilder();

            builder.append(carName + Message.SEMICOLON);
            for (int i = 0; i < carPosition; i++) {
                builder.append(CAR_SHAPE);
            }
            System.out.println(builder.toString());
        });
        System.out.println();
    }

    public void showWinner(List<String> winCarNames) {
        System.out.println(winCarNames.stream()
                .collect(Collectors.joining(", ")) + Message.WINNING_MESSAGE);
    }

    public void showError(String msg) {
        System.out.println("\n" + Message.ERROR + msg + "\n");
    }
}
