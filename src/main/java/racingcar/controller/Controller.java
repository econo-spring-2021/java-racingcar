package racingcar.controller;

import racingcar.view.RacingView;

import java.util.Random;

public class Controller {

    // RacingView racingView = new RacingView();

    //int randomNumber= racingView.generateRandomNumber();

    public String judgeNumber(int randomNumber){
        if (randomNumber >= 4){
            // System.out.println("이동 거리가 1 증가합니다.");
            return "이동 거리 1 증가";
        }
        if (randomNumber <= 3){
            // System.out.println("이동 거리가 변하지 않습니다. ");
            return "이동 거리 변화 없음";
        }
        return null;
    }

    public void checkName(String carName){
        if (carName.length() > 5){
            System.out.println("이름이 5글자 이상입니다. 다시 입력하세요.");
        }
        if (carName.length() <= 5){
            System.out.println("경주 차량 등록 완료하였습니다.");
        }
    }
}
