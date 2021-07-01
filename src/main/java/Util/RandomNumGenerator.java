package Util;

public class RandomNumGenerator extends NumberGenerator {
    private int bound;

    public RandomNumGenerator(int bound) {
        super((int)(Math.random() * bound));
        this.bound = bound;
    }

    public int getInt() {
        super.value = (int)(Math.random() * bound);
        return super.value;
    }
}
