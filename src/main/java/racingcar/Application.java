package racingcar;

import racingcar.controller.Game;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException {
        ArrayList<Car> cars = new ArrayList<>();
        String[] carNameInputs = InputView.carNameInput();
        for (int i = 0; i < carNameInputs.length; i++) {
            cars.add(new Car(carNameInputs[i]));
        }
        int tryNumber = InputView.tryNumberInput();

        OutputView.raceStartView();
        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < cars.size(); j++) {
                cars.get(j).move(Car.setRandomValue());
                OutputView.raceResultView(cars.get(j).getName(), cars.get(j).getPosition());
            }
            OutputView.emptyLineView();
        }
        ArrayList<String> winners = Game.getWinner(cars);
        OutputView.winnersView(winners);
    }
}
