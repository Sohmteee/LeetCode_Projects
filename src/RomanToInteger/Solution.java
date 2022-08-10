package RomanToInteger;

import java.util.*;

public class Solution {

    public static List<String> separatedRomans = new ArrayList<>();
    public static int romanToInt(String s) {
        s = s.toUpperCase(Locale.ROOT);
        System.out.println("Roman Numeral to convert : " + s);
        Map<Integer, String> units = new HashMap<>(),
                tens = new HashMap<>(),
                hundreds = new HashMap<>(),
                thousands = new HashMap<>();

        String[] unit = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousand = {"", "M", "MM", "MMM"};

        //assign values to the maps
        for (int i = 0; i < unit.length; i++) units.put(i, unit[i]);
        for (int i = 0; i < ten.length; i++) tens.put(i, ten[i]);
        for (int i = 0; i < hundred.length; i++) hundreds.put(i, hundred[i]);
        for (int i = 0; i < thousand.length; i++) thousands.put(i, thousand[i]);

        String finalRoman = s;
        String th, h, t, u;

        System.out.print("Separating the Roman Numerals : ");

        th = getNumeral(s, thousands);
        h = getNumeral(s, hundreds);
        t = getNumeral(s, tens);
        u = getNumeral(s, units);

        System.out.println(separatedRomans);

        String r = "";
        for (String roman : separatedRomans) {
            if (r.contains(roman)) {
                r = r.replace(roman, getLongestRoman(units, roman));
                r = r.replace(roman, getLongestRoman(tens, roman));
                r = r.replace(roman, getLongestRoman(hundreds, roman));
                r = r.replace(roman, getLongestRoman(thousands, roman));
            }
        }

        System.out.println(separatedRomans);

        th = getNumeral(finalRoman, thousands);
        h = getNumeral(finalRoman, hundreds);
        t = getNumeral(finalRoman, tens);
        u = getNumeral(finalRoman, units);

        System.out.println("Separating the digits : " + th + " " + h + " " + t + " " + u);

        finalRoman = th + h + t + u;

        System.out.println("Final Roman : " + finalRoman);

        separatedRomans = new ArrayList<>();

        return Integer.parseInt(finalRoman);

    }

    private static String getLongestRoman(Map<Integer, String> map, String roman) {
        String n = "";
        for (int key : map.keySet()) {
            if (map.get(key).equals(roman) & (roman.length() > n.length())) {
                n = roman;
            }
        }

        return n.equals("") ? roman : n;
    }

    private static String getNumeral(String s, Map<Integer, String> map) {
        String n = "";
        for (String roman : map.values()) {
            if (s.contains(roman)) {
                for (int key : map.keySet()) {
                    if (map.get(key).equals(roman) & (roman.length() > n.length())) {
                        n = roman;
                    }
                }
            }
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue().equals(n)) {
                if (!n.equals("")) {
                    separatedRomans.add(n);
                }
                n = String.valueOf(entry.getKey());
            }
        }

        return (n.equals("")) ? "0" : n;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("III => " + romanToInt("III") + "\n");
        System.out.println("LVIII => " + romanToInt("LVIII") + "\n");
        System.out.println("MCMXCIV => " + romanToInt("MCMXCIV") + "\n");
        System.out.println("IX => " + romanToInt("IX") + "\n");
        System.out.println("MDLXX => " + romanToInt("MDLXX") + "\n");
        long end = System.currentTimeMillis();

        long exec = end - start;
        double inSeconds = (double) exec / 1000;

        System.out.printf("\nIt took %s seconds to run your code%n", inSeconds);
    }
}
