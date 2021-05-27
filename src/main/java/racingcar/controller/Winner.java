package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    public static void getWinner(List<Car> racingCarList) {
        List<Car> winner = new ArrayList<>();
        int positionOfWinner = findPositionOfWinner(racingCarList);
        winner = racingCarList.stream().filter(car -> (car.getPosition() == positionOfWinner)).collect(Collectors.toList());
        List<String> winnernames = new ArrayList<>();
        for(int i = 0; i < winner.size(); i++){
            winnernames.add(winner.get(i).getName());
        }
        OutputView.getWinnerMessage(winnernames);
    }

    private static int findPositionOfWinner(List<Car> racingCarList) {
        List<Integer> position = new ArrayList<>();
        for(Car car: racingCarList){
            position.add(car.getPosition());
        }
        int positionOfWinner = Collections.max(position);
        return positionOfWinner;
    }
}
