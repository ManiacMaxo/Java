package org.elsys.ip.socketGame;

import java.io.IOException;

public class GameClient {

    public static void printScreen(char c) {
        int width = 100;
        int height = 30;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(c);
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        printScreen('+');
        Runtime.getRuntime().exec("clear");
        printScreen('-');
    }
}
