package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static final int MINIMUM_TRY_NUMBER = 0;
    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;

    public static void carNameInputView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void checkCarNameInputView() {
        System.out.println("다시 자동차 이름을 5자 이하로 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void tryNumberInputView() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void checkTryNumberInputView() {
        System.out.println("시도할 횟수는 0이상으로 입력해주세요.");
    }

    public static String[] carNameInput() throws IOException {
        carNameInputView();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carNameInput = br.readLine();
        String[] carNames = getCarNames(carNameInput);
        while (!checkCarNameInput(carNames)) {
            checkCarNameInputView();
            carNames = getCarNames(br.readLine());
        }
        return carNames;
    }

    public static String[] getCarNames(String carNameInput) {
        String[] carNames = carNameInput.split(",");
        return carNames;
    }

    public static boolean checkCarNameInput(String[] carNames) throws IOException {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > MAXIMUM_CAR_NAME_LENGTH) {
                return false;
            }
        }
        return true;
    }

    public static int tryNumberInput() throws IOException {
        InputView.tryNumberInputView();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNumber = Integer.parseInt(br.readLine());
        while (!checkTryNumberInput(tryNumber)) {
            InputView.checkTryNumberInputView();
            tryNumber = Integer.parseInt(br.readLine());
        }
        return tryNumber;
    }

    public static boolean checkTryNumberInput(int tryNumber) throws IOException {
        if (tryNumber <= MINIMUM_TRY_NUMBER) {
            return false;
        }
        return true;
    }
}
