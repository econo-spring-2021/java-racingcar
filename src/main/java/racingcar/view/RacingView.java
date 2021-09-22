package racingcar.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class RacingView {
    private static final int MAXIMUM_CAR_LENGTH = 5;

    private Scanner scanner = new Scanner(System.in);

    public ArrayList<String> racingCars = new ArrayList<String>();
    public int tryNumber;

    public void inputCarNames(){
        askCarNames();

        try {
            String name = scanner.nextLine();
            String[] carNames = name.split(", ");
            checkNameException(carNames);
        }catch (Exception e){
            tryInputName();
        }
    }

    private void checkNameException(String[] names){
        for (int i = 0; i < names.length; i++){
            checkEmptyName(names[i]);
            checkLongLengthName(names[i]);
        }
    }

    private void askCarNames(){
        System.out.println("경주할 자동차 이름을 입력합니다. 이름은 5자 이하만 가능합니다. (이름은 쉼표(,) 기준으로 구분됩니다.)");
    }

    private void askTryNumber(){
        System.out.println("시도할 횟수는 몇 번인가요?");
    }

    public void inputTryNumber(){

        while (true){
            try {
                askTryNumber();
                int number = scanner.nextInt();
                tryNumber = number;
                break;
            }catch (InputMismatchException ime){
                System.out.println("정수만 입력할 수 있습니다.");
                scanner.next();
                continue;
            }
        }
    }

    private void checkEmptyName(String name){
        if (name==""){
            System.out.println("이름이 공백입니다. 다시 작성해주세요.");
            tryInputName();
        }
    }

    private void checkLongLengthName(String name){
        if (name.length() > MAXIMUM_CAR_LENGTH){
            System.out.println(name+ " : 은 5글자 이상입니다. 다시 입력하세요.");
            tryInputName();
        }
        if (name.length() <= MAXIMUM_CAR_LENGTH){
            racingCars.add(name);
            System.out.println(name+"경주 차량 등록이 완료되었습니다.");
        }
    }

    private void tryInputName(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        checkEmptyName(name);
        checkLongLengthName(name);
    }

    public ArrayList<String> getRacingCars(){
        return racingCars;
    }

    public Integer getTryNumber(){
        return tryNumber;
    }
}