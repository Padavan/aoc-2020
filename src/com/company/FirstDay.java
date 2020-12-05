package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstDay {

    public static void start() {
        System.out.println("First Day");
        executePart1();
        executePart2();
    }

    static void executePart1() {
        String filePath = "c:\\data\\FirstDayData.txt";

        ArrayList<String> lineData = FileInputReader.readInput(filePath);

        int numberOfNiceStrings = 0;
        for (String a: lineData) {
            for (String b: lineData) {
                if (Integer.parseInt(a) + Integer.parseInt(b) == 2020) {
                    System.out.println("Part 1: " + Integer.parseInt(a) * Integer.parseInt(b));
                }
            }
        }

        System.out.println("Part 1: ");
    }

    static void executePart2() {
        String filePath = "c:\\data\\FirstDayData.txt";

        ArrayList<String> lineData = FileInputReader.readInput(filePath);

        int numberOfNiceStrings = 0;
        for (String a: lineData) {
            for (String b: lineData) {
                for (String c: lineData) {
                    if (Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c) == 2020) {
                        System.out.println("Part 2: " + Integer.parseInt(a) * Integer.parseInt(b) * Integer.parseInt(c));
                    }
                }
            }
        }

        System.out.println("Part 2: ");
    }

}
