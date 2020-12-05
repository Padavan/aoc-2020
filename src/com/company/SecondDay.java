package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondDay {

    public static void start() {
        System.out.println("Second Day");
        String filePath = "c:\\data\\aoc-2020-2day.txt";
        ArrayList<String> data = FileInputReader.readInput(filePath);

        executePart1(data);
        executePart2(data);
    }

    static String[] tokenize(String line) {
        return line.split("\\s+");
    }

    static boolean validateLetterCount(String line) {
        String[] policy = tokenize(line);
        int[] limitPolicy = Arrays.stream(policy[0].split("-")).mapToInt(num -> Integer.parseInt(num)).toArray();
        char letter = policy[1].charAt(0);
        String validatedString = policy[2];


        int occurance = validatedString.chars()
                .mapToObj(i -> (char)i)
                .filter(c -> c == letter)
                .collect(Collectors.toList()).size();

        if (occurance >= limitPolicy[0] && occurance <= limitPolicy[1]) {
            return true;
        } else {
            return false;
        }
    }

    static boolean validateLetterPosition(String line) {
        String[] policy = tokenize(line);
        int[] limitPolicy = Arrays.stream(policy[0].split("-")).mapToInt(num -> Integer.parseInt(num)).toArray();
        char letter = policy[1].charAt(0);
        String validatedString = policy[2];

        if ((validatedString.charAt(limitPolicy[0] - 1) == letter && validatedString.charAt(limitPolicy[1] - 1) != letter) ||
                (validatedString.charAt(limitPolicy[0] - 1) != letter && validatedString.charAt(limitPolicy[1] - 1) == letter)) {
            return true;
        } else {
            return false;
        }

    }

    static void executePart1(ArrayList<String> lineData) {

        int stack = 0;

        for (String line: lineData) {
            if (validateLetterCount(line)) {
                stack++;
            }
        }

        System.out.println("Part 1: " + stack);
    }

    static void executePart2(ArrayList<String> lineData) {
        String testString = "1-3 b: cdefg";
        int stack = 0;

        for (String line: lineData) {
            if (validateLetterPosition(line)) {
                stack++;
            }
        }

        System.out.println("Part 2: " + stack);
    }

}