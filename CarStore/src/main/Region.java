package main;

import java.util.Map;
import java.util.Random;

public enum Region {
    SOFIA, BURGAS, VARNA, PLOVDIV, RUSE, GABROVO, VIDIN, VRATSA;

    private static final Map<Region, String> prefixes = Map.ofEntries(
            Map.entry(BURGAS, "A"),
            Map.entry(SOFIA, "CB"),
            Map.entry(VARNA, "B"),
            Map.entry(VIDIN, "BH"),
            Map.entry(VRATSA, "BP"),
            Map.entry(GABROVO, "EB"),
            Map.entry(PLOVDIV, "PB"),
            Map.entry(RUSE, "P")
    );

    public static String getPrefix(Region region) {
        return prefixes.get(region);
    }

    public static int getNumber() {
        return new Random().nextInt(9000) + 1000;
    }

    public static String getChars() {
        char char1 = (char) (new Random().nextInt(26) + 65);
        char char2 = (char) (new Random().nextInt(26) + 65);

        return String.format("%c%c", char1, char2);
    }
}
