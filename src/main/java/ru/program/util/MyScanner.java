package ru.program.util;

import java.util.Scanner;

public class MyScanner {

    private static Scanner scanner;

    public static Scanner getScanner() {
        if (scanner == null) {
            return scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
