import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;


import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    @DisplayName("차 번호 갯수 테스트")
    @Test
    void separateName()  {
        //given
        final GameController game = new GameController();
        String names = "kim,park,hong";
        String[] cars = {"kim","park","hong"};
        //when
        String[] namesSeparate = game.separateName(names);
        //then
        assertArrayEquals(cars,namesSeparate);
    }


    @DisplayName("최소 참가 인원 테스트")
    @Test
    void checkIncludeCarNum() {
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
    void randomValueGive() {
        //given
        final GameController game = new GameController();
        //when
        int random = game.randomValueGive();
        //then
        assertTrue(random>=1 && random <=9);
    }

    @DisplayName("차 이름 글자 제한 초과 테스트")
    @Test
    void InningFiveLength(){
        //given
        final GameController game = new GameController();
        //when
        boolean result = game.InningFiveLength("asdfgg");
        //then
        assertFalse(result);
    }

    @DisplayName("최소 참가 인원 이상 여부 테스트")
    @Test
    void checkIncludeNum(){
        //given
        final GameController game = new GameController();
        String[] participations ={"mike"};
        //when
        boolean result = game.checkIncludeCarNum(participations);
        //then
        assertFalse(result);
    }

}