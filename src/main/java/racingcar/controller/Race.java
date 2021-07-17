package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.ParticipatingCar;
import racingcar.view.Constants;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Race {
    private List<Car> racingCarList;
    private int trial;
    private Random random;

    public Race() {
        random = new Random();
        racingCarList = new ArrayList<>();
        this.trial = 0;
    }

    public void start(ParticipatingCar participatingCar, int trial) {
        racingCarList = participatingCar.getRacingCarList();
        this.trial = trial;

        OutputView.printRacingResultMessage();
        for(int count = 0; count < trial; count++) {
            startOneRound(racingCarList);
            System.out.println();
        }
    }

    private void startOneRound(List<Car> racingCarList) {
        for(Car car: racingCarList) {
            raceOneCarbyOneRound(car);
        }

        for(Car car: racingCarList) {
            OutputView.showOneRoundResultByOneCar(car.getName(), car.getPosition());
        }
    }

    private void raceOneCarbyOneRound(Car car) {
        if(isMovingCondition()) {
            car.move();
        }
    }

    private boolean isMovingCondition() {
        if(random.nextInt(10) >= Constants.MOVE_FORWARD_CONDITION) {
            return true;
        }
        return false;
    }

    public void getWinner(List<Car> racingCarList) {
        List<Car> winner = new ArrayList<>();
        int positionOfWinner = findPositionOfWinner(racingCarList);
        winner = racingCarList.stream()
                .filter(car -> (car.getPosition() == positionOfWinner))
                .collect(Collectors.toList());
        List<String> winnernames = new ArrayList<>();
        for(int i = 0; i < winner.size(); i++){
            winnernames.add(winner.get(i).getName());
        }
        OutputView.getWinnerMessage(winnernames);
    }

    private int findPositionOfWinner(List<Car> racingCarList) {
        List<Integer> position = new ArrayList<>();
        for(Car car: racingCarList){
            position.add(car.getPosition());
        }
        return Collections.max(position);
    }
}
