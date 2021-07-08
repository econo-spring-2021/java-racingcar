package Util;

public class RandomNumGenerator implements NumberGenerator {
    private int value;
    private int bound;

    public RandomNumGenerator(int bound) {
        this.value = (int)(Math.random() * bound);
        this.bound = bound;
    }

    public int getInt() {
        this.value = (int)(Math.random() * bound);
        return this.value;
    }
}
