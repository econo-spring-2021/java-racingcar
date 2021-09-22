package racingcar.controller;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import racingcar.domain.Car;

import java.lang.reflect.Method;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RacingControllerTest {

   // @Test
    //@DisplayName("경주 시작할 자동차 할당")
    /*
    public void assignCars(){
        RacingController racingController = new RacingController();

        try {
            Method method = racingController.getClass().getDeclaredMethod("assignCars");
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // given
        ArrayList<String> racingCars = new ArrayList<String>(Arrays.asList("july", "rayna", "kiki"));
        ArrayList<Car> carArrayList = new ArrayList<Car>();
        int racingCarSize = 3;

        // when
        for(int i=0; i < racingCars.size(); i++){
            String carName = racingCars.get(i);
            carArrayList.add(new Car(carName, 0,0));
        }

        // then
        assertEquals(carArrayList.size(), racingCarSize);
    }

     */


    /*
    @Test
    public void findWinner() {
        ArrayList<Car> carObject = new ArrayList<Car>();
        carObject.add(new Car("july", 1, 3));
        carObject.add(new Car("nina", 2,5));
        carObject.add(new Car("coco", 1, 5));

        String winner = "nina, coco";

        RacingController racingController = new RacingController();
        ArrayList<String> racingWinner = racingController.findWinner();
        String stringWinner = String.join(", ", racingWinner);

        assertEquals(stringWinner, winner);
    }
     */

    /*
    @Test
    public void duplicateCheck() {
        ArrayList<String> carName = new ArrayList<String>(Arrays.asList("july, july, nina"));
        ArrayList<String> expectedWinner = new ArrayList<String>(Arrays.asList("july, nina"));

        RacingController controller = new RacingController();
        ArrayList<String> actualWinner = controller.duplicateCheck(carName);

        assertEquals(actualWinner, expectedWinner);
    }
     */

    @Test
    public void generateRandomNumber(){

    }
}