package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ThirdDay {

    public static void start() {
        System.out.println("Third Day");
//        executePart1();
        executePart2();
    }

    static void executePart1() {
        String filePath = "c:\\data\\aoc-2020-3day.txt";

        ArrayList<String> lineData = FileInputReader.readInput(filePath);

        int stack = 0;

//        for (int i=0; i < height; i++) {
//            char slopeCharacter = lineData.get(i).charAt(i*3 % width);
//            System.out.println(slopeCharacter);
//            if (slopeCharacter == TREE) {
//                stack++;
//            }
//        }

        System.out.println("Part 1: " + getTrees(3,1, lineData));
    }

    static void executePart2() {
        String filePath = "c:\\data\\aoc-2020-3day.txt";

        ArrayList<String> lineData = FileInputReader.readInput(filePath);

        ArrayList<int[]> paths = new ArrayList<int[]>();
        paths.add(new int[]{1, 1});
        paths.add(new int[]{3, 1});
        paths.add(new int[]{5, 1});
        paths.add(new int[]{7, 1});
        paths.add(new int[]{1, 2});

        long total = 1;

        for (int[] path: paths) {
            total = total * getTrees(path[0], path[1], lineData);
            System.out.println(total);
        }

        System.out.println("Part 2: " + total);
    }

    static int getTrees(int xTraverse, int yTraverse, ArrayList<String> slope) {
        int stack = 0;
        char TREE = '#';
        int height = slope.size();
        int width = slope.get(0).length();

        for (int i=0; i < height; i++) {
            if (yTraverse * i > height) {
                return stack;
            }

            char slopeCharacter = slope.get(yTraverse * i).charAt(i*xTraverse % width);
//            System.out.println(i*yTraverse + " - " + i*xTraverse % width + " - " + slopeCharacter);
            if (slopeCharacter == TREE) {
                stack++;
            }
        }

        return stack;
    }

}
