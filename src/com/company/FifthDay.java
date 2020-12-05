package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FifthDay {
    public static void start() {
        System.out.println("Second Day");
        String filePath = "c:\\data\\aoc-2020-5day.txt";
        ArrayList<String> data = FileInputReader.readInput(filePath);

//        executePart1(data);
        executePart2(data);
    }

    static int getRow(String line) {
        String filteredLIne = line.chars()
                .mapToObj(i -> (char)i)
                .filter(c -> c == 'F' || c == 'B')
                .map(letter -> letter == 'F' ? '0' : '1')
                .map(c->c.toString()).collect(Collectors.joining());

//        System.out.println(Integer.parseInt(filteredLIne,2));
        return Integer.parseInt(filteredLIne,2);
    }

    static int getColumn(String line) {
        String filteredLIne = line.chars()
                .mapToObj(i -> (char)i)
                .filter(c -> c == 'R' || c == 'L')
                .map(letter -> letter == 'R' ? '1' : '0')
                .map(c->c.toString()).collect(Collectors.joining());

//        System.out.println(Integer.parseInt(filteredLIne,2));
        return Integer.parseInt(filteredLIne,2);
    }

    static int getId(String line) {
        return getRow(line)*8 + getColumn(line);
    }

    static int findMaxId(ArrayList<String> lineData) {
        int maxId = 0;
        for (String line: lineData) {
            int currentId = getId(line);
//            System.out.println(line + " " + currentId);
            if (currentId > maxId) {
                maxId = currentId;
            }
        }
        return maxId;
    }

    static int findMissingId(ArrayList<String> lineData) {
        List<Integer> sortedList = lineData.stream().map(s -> getId(s)).sorted().collect(Collectors.toList());
        System.out.println(sortedList);
        int missingId = 0;
        for (int i = 1; i < sortedList.size()-1; i++) {
            if ((sortedList.get(i - 1) + sortedList.get(i+1))/2 != sortedList.get(i)) {
                System.out.println(sortedList.get(i));
                missingId = (sortedList.get(i - 1) + sortedList.get(i+1))/2;
            }
        }
        return missingId;
    }

    static void executePart1(ArrayList<String> lineData) {
        System.out.println(getId("BBFFBBFRLL"));
//        System.out.println("Part 1: " + findMaxId(lineData));
    }

    static void executePart2(ArrayList<String> lineData) {
        System.out.println(getId("BBFFBBFRLL"));
        System.out.println("Part 2: " + findMissingId(lineData));
    }
}
