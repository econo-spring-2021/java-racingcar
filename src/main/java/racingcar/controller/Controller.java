package racingcar.controller;

import java.util.Random;

public class Controller {
    public int generateNumber(){
        int randomNumber = (int)(Math.random()*10);
        System.out.println(randomNumber);
        return randomNumber;
    }

    int randomNumber=0;

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
}
