package com.company;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;


public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        FirstDay.start();
//        SecondDay.start();
//        ThirdDay.start();
        FourthDay.start();
//        FifthDay.start();
//        Six.main();
    }
}

class ConsoleInputReader {
    public static String readInput() {
        System.out.println("Enter Advent String");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return input;
    }
}

class FileInputReader {
    public static ArrayList<String> readInput(String path) {
        ArrayList<String> lineData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);
                lineData.add(line);
                // read next line
                line = reader.readLine();

            }
        } catch (Exception ex) {
            System.out.println("readLine() failed.");
        }

        return lineData;
    }
}