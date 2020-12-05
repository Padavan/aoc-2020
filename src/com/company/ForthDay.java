package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static java.security.spec.RSAKeyGenParameterSpec.F0;

class FourthDay {
    public static void start() {
        System.out.println("===Day 4===");
        String filePath = "c:\\data\\aoc-2020-4day.txt";
        ArrayList<String> data = FileInputReader.readInput(filePath);

        List<HashMap> passports = getPassports(data);
//        executePart1(passports);
        executePart2(passports);
    }

    static List<HashMap> getPassports(ArrayList<String> data) {
        List<HashMap> passports = new ArrayList<>();
        String passport = "";
        for (String line: data) {
            if (!line.isEmpty()) {
                passport = passport + " " + line;
            } else {
//                System.out.println(passport);
                passports.add(getPassportMap(passport));
                passport = "";
            }
        }
        passports.add(getPassportMap(passport)); // add last pasport

        return passports;
    }

    static HashMap getPassportMap(String passportString) {
        HashMap<String,String> map = new HashMap<>();
        Arrays.stream(passportString.split(" ")).forEach(d -> {
            String[] pair = d.split(":");
            if (pair.length > 1) {
                map.put(pair[0].trim(), pair[1].trim());
            }
        });
      return map;
    }

    static String[] requiredFields = new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};

    static boolean validate(HashMap passportObject) {
        return Arrays.stream(requiredFields).filter(k -> !passportObject.containsKey(k)).collect(Collectors.toList()).size() == 0;
    }

    static int getValidPassportCount(List<HashMap> passports) {
        int stack = 0;
        int invalid = 0;
        for (HashMap pass: passports) {
            if (validate(pass)) {
//                System.out.println(pass + " is valid");
                stack++;
            } else {
                System.out.println(pass + " is Invalid");
                invalid++;
            }
        }
        System.out.println("Invalid passports:" + invalid);
        System.out.println(passports.size());
        return stack;
    }

    static boolean advancedValidate(HashMap passportObject) {
        if (Arrays.stream(requiredFields).filter(k -> !passportObject.containsKey(k)).collect(Collectors.toList()).size() != 0) {
//            System.out.println("field error");
            return false;
        }

        String byr = (String)passportObject.get("byr");
        if (byr.length() != 4 || Integer.parseInt(byr) < 1920 || Integer.parseInt(byr) > 2002) {
//            System.out.println("byr error");
            return false;
        }

        String iyr = (String)passportObject.get("iyr");
        if (iyr.length() != 4 || Integer.parseInt(iyr) < 2010 || Integer.parseInt(iyr) > 2020) {
//            System.out.println("iyr error");
            return false;
        }

        String eyr = (String)passportObject.get("eyr");
        if (eyr.length() != 4 || Integer.parseInt(eyr) < 2020 || Integer.parseInt(eyr) > 2030) {
//            System.out.println("eyr error");
            return false;
        }

        String hgt = (String)passportObject.get("hgt");
        if (!((hgt.replace("in", "").matches("\\d+")
                && Integer.parseInt(hgt.replace("in", "")) >= 59 && Integer.parseInt(hgt.replace("in", "")) <= 76) ||
                (hgt.replace("cm", "").matches("\\d+") && Integer.parseInt(hgt.replace("cm", "")) >= 150 && Integer.parseInt(hgt.replace("cm", "")) <= 193))) {
//            System.out.println("hgt error: " + hgt + hgt.replace("cm", "").matches("\\d+"));
            return false;
        }

        String hcl = (String)passportObject.get("hcl");
        if (!(hcl.replace("#", "").length() == 6 && hcl.matches("^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$"))) {
//            System.out.println("hcl error");
            return false;
        }

        String ecl = (String)passportObject.get("ecl");
        List<String> availableColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        if (!availableColors.contains(ecl)) {
//            System.out.println("ecl error " + ecl);
            return false;
        }

        String pid = (String)passportObject.get("pid");
        if (!(pid.length() == 9 && pid.matches("\\d+"))) {
            System.out.println("pid error" + pid);
            return false;
        }

        return true;
    }

    static int getAdvancedValidPassportCount(List<HashMap> passports) {
        int stack = 0;
        int invalid = 0;
        for (HashMap pass: passports) {
            if (advancedValidate(pass)) {
//                System.out.println(pass + " is valid");
                stack++;
            } else {
//                System.out.println(pass + " is Invalid");
                invalid++;
            }
        }
        System.out.println("Invalid passports:" + invalid);
        System.out.println(passports.size());
        return stack;
    }


    static void executePart1(List<HashMap> passports) {
//        String testPass = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm";
//        String testPass = "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929";
//        String testPass = "hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179";
//        String testPass = "hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in";

//        System.out.println(validate(getPassportMap(testPass)));
        System.out.println("Part 1: " + "valid passports count: " + getValidPassportCount(passports));
    }

    static void executePart2(List<HashMap> passports) {
        System.out.println("Part 2: " + "advanced valid passport count: " + getAdvancedValidPassportCount(passports));
    }
}

//181 too hight
