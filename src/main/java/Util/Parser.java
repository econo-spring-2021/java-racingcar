package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Parser {
    public final static List<String> parse(String data, String delimiter) {
        return new ArrayList<>(Arrays.asList(data.replaceAll(" ", "").split(delimiter)));
    }
}
