package racingcar.view;

import java.util.Scanner;

public class InputView {
    private String carNames;
    private String[] carName;
    private int count;

    public void inputCarNames(Scanner scanner) throws InputViewException {
        OutputView.inputCarNameMessage();
        carNames = scanner.nextLine();
        carName = splitCommaFromStringInput(carNames);
        for(int indexOfCars = 0; indexOfCars < carName.length; indexOfCars++) {
            checkNamingRule(carName[indexOfCars]);
        }
    }

    public void inputTryCount(Scanner scanner) {
        OutputView.inputTryCountMessage();
        count = scanner.nextInt();
    }

    public String[] getCarNames() {
        return this.carName;
    }

    public int getCount() {
        return this.count;
    }

    private String[] splitCommaFromStringInput(String carNames) {
        String[] carName = carNames.split(",");
        return carName;
    }

    private void checkNamingRule(String carName) throws InputViewException {
        if(carName.length() > Constants.CAR_NAME_VALID_LENGTH) {
            throw new InputViewException();
        }
    }
}
