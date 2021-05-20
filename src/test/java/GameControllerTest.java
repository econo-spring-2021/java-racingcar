import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.view.InputView;


import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    @DisplayName("자동차 이름 쉼표 구분 테스트")
    @Test
    void separateNameTest()  {
        //given
        String names = "kim,park,hong";
        String[] cars = {"kim","park","hong"};
        //when
        String[] namesSeparate = InputView.separateName(names);
        //then
        assertArrayEquals(cars,namesSeparate);
    }


    @DisplayName("최소 인원(2명) 제한 테스트 ")
    @Test
    void checkIncludeCarNumTest() {
        //given
        final GameController game = new GameController();
        String[] cars = {"mike"};
        //when
        boolean a = game.checkIncludeCarNum(cars);
        //then
        assertFalse(a);
    }

    @DisplayName("랜덤 값 범위 테스트")
    @Test
    void randomValueGiveTest() {
        //given
        final GameController game = new GameController();
        //when
        int random = game.randomValueGive();
        //then
        assertTrue(random>=1 && random <=9);
    }

    @DisplayName("차 이름 길이(5글자) 초과 제한 테스트")
    @Test
    void InningFiveLengthTest(){
        //given
        final GameController game = new GameController();
        //when
        boolean result = game.InningFiveLength("asdfgg");
        //then
        assertFalse(result);
    }

}