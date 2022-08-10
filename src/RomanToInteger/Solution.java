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

        String rom;
        String th, h, t, u;

        System.out.print("Separating the Roman Numerals : ");
        System.out.println(separatedRomans);

        th = getString(s, thousands);
        h = getString(s, hundreds);
        t = getString(s, tens);
        u = getString(s, units);

        System.out.println("\nSeparating the digits : " + th + " " + h + " " + t + " " + u);

        rom = th + h + t + u;

        return Integer.parseInt(rom);

    }

    private static String getString(String s, Map<Integer, String> map) {
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
                    System.out.print(n + " ");
                }
                n = String.valueOf(entry.getKey());
            }
        }

        return (n.equals("")) ? "0" : n;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("III => " + romanToInt("III") + "\n");
        separatedRomans = new ArrayList<>();
        System.out.println("LVIII => " + romanToInt("LVIII") + "\n");
        separatedRomans = new ArrayList<>();
        System.out.println("MCMXCIV => " + romanToInt("MCMXCIV") + "\n");
        separatedRomans = new ArrayList<>();
        System.out.println("IX => " + romanToInt("IX") + "\n");
        separatedRomans = new ArrayList<>();
        System.out.println("MDLXX => " + romanToInt("MDLXX") + "\n");
        separatedRomans = new ArrayList<>();
        long end = System.currentTimeMillis();

        long exec = end - start;
        double inSeconds = (double) exec / 1000;

        System.out.printf("\nIt took %s seconds to run your code%n", inSeconds);
    }
}
