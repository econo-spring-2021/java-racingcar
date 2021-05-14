import racingcar.controller.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {
    private int chance;

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int generateNumber() {
        return chance;
    }
}
