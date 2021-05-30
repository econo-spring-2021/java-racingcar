package racingcar.controller;

import racingcar.domain.Car;
import java.util.ArrayList;

public class Game {
    public static ArrayList<String> getWinner(ArrayList<Car> cars) {
        int max = getMaxPosition(cars);
        ArrayList<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == max) {
                winners.add(cars.get(i).getName());
            }
        }
        return winners;
    }

    public static int getMaxPosition(ArrayList<Car> cars) {
        int max = 0;
        int position;
        for (int i = 0; i < cars.size(); i++) {
            position = cars.get(i).getPosition();
            if (max < position) {
                max = position;
            }
        }
        return max;
    }
}
