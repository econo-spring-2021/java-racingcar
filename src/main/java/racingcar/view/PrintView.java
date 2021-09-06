package racingcar.view;

import java.util.ArrayList;

public class PrintView {
    public void printGameResult(){
        System.out.println("실행 결과");
    }

    public void printBlankLine(){
        System.out.println("");
    }

    public void printRacingBroadCast(String carName, int distance){
        System.out.println(String.format("%s: %s", carName, printDistance(distance)));
    }

    public String printDistance(int distance){
        ArrayList<String> stringArrayList = new ArrayList<String>();

        for (int i=0; i < distance; i++){
            stringArrayList.add("-");
        }

        String stringDistance = String.join("", stringArrayList);
        return stringDistance;
    }

    public void printRacingWinner(ArrayList winners){
        String stringWinner = String.join(", ", winners);
        System.out.println("");
        System.out.println(stringWinner+"가 최종 우승했습니다.");
    }
}
