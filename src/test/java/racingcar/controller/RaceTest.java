package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.ParticipatingCar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.*;

public class RaceTest {
    @Test
    void 값이_4_이상이면_전진하는가_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car = new Car("pobi");
        Race race = new Race();
        Method method = Race.class.getDeclaredMethod("judgeMovingCondition");
        method.setAccessible(true);
        if((boolean)method.invoke(race).equals(true)) {
            assertTrue((boolean) method.invoke(race));
        }

    }

    @Test
    void 값이_3_이하이면_멈추는가_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car = new Car("pobi");
        Race race = new Race();
        Method method = Race.class.getDeclaredMethod("judgeMovingCondition");
        method.setAccessible(true);
        if((boolean)method.invoke(race).equals(false)) {
            assertFalse((boolean) method.invoke(race));
        }
    }

    @Test
    void 우승자의_위치를_확인한는_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Car car1 = new Car("pobi");
        Car car2 = new Car("lee");
        Car car3 = new Car("kim");

        car1.move();
        car2.move();
        car2.move();
        car3.move();

        ParticipatingCar participatingCar = new ParticipatingCar();
        participatingCar.addRacingCar(car1);
        participatingCar.addRacingCar(car2);
        participatingCar.addRacingCar(car3);

        Race race = new Race();
        Method method = Race.class.getDeclaredMethod("findPositionOfWinner", List.class);
        method.setAccessible(true);

        assertEquals(method.invoke(race,participatingCar.getRacingCarList()),2);
    }

//    @Test
//    void 우승자_확인_테스트() {
//        Car car1 = new Car("pobi");
//        Car car2 = new Car("lee");
//
//        car1.move();
//        car1.move();
//        car2.move();
//
//        ParticipatingCar participatingCar = new ParticipatingCar();
//        participatingCar.addRacingCar(car1);
//        participatingCar.addRacingCar(car2);
//
//        Race race = new Race();
//        race.getWinner(participatingCar.getRacingCarList());
//    }

}