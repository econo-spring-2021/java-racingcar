package Util;

public class DedicatedNumberGenerator implements NumberGenerator {
    int value;

    public DedicatedNumberGenerator(int value) {
        this.value = value;
    }

    public int getInt() {
        return value;
    }
}
