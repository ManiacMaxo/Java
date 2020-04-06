package com.elsys.fitness.util;

import java.util.Random;
import java.util.UUID;

public class RandomGenerator {
    public static int generateRandomInt(int max) {
        return new Random().nextInt(max);
    }

    public static String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    public static double generateRandomDouble() {
        return new Random().nextDouble();
    }
}
