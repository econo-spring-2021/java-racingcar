package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private String carNames;
    private List<String> carName;
    private int count;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public void inputCarNames() throws InputViewException {
        OutputView.inputCarNameMessage();
        carNames = scanner.nextLine();
        carName = splitCommaFromStringInput(carNames);
        for(int indexOfCars = 0; indexOfCars < carName.size(); indexOfCars++) {
            checkNamingRule(carName.get(indexOfCars));
        }
    }

    public void inputTryCount() {
        OutputView.inputTryCountMessage();
        count = scanner.nextInt();
    }

    public List<String> getCarNames() {
        return this.carName;
    }

    public int getCount() {
        return this.count;
    }

    private List<String> splitCommaFromStringInput(String carNames) {
        List<String> carName = Arrays.asList(carNames.split(","));
        return carName;
    }

    private void checkNamingRule(String carName) throws InputViewException {
        if(carName.length() > Constants.CAR_NAME_VALID_LENGTH) {
            throw new InputViewException();
        }
    }
}
