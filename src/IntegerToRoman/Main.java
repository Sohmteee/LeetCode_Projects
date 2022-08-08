package IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        if (num >= 4000) return "";
        Map<Integer, String> units = new HashMap<>(),
                tens = new HashMap<>(),
                hundreds = new HashMap<>(),
                thousands = new HashMap<>();

        String[] unit = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] ten = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundred = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousand = {"M", "MM", "MMM"};

        for (int i = 1; i <= unit.length; i++) units.put(i, unit[i - 1]);
        for (int i = 1; i <= ten.length; i++) tens.put(i, ten[i - 1]);
        for (int i = 1; i <= hundred.length; i++) hundreds.put(i, hundred[i - 1]);
        for (int i = 1; i <= thousand.length; i++) thousands.put(i, thousand[i - 1]);

        System.out.println(units);
        System.out.println(tens);
        System.out.println(hundreds);
        System.out.println(thousands);
        System.out.println();

        char[] intChar = String.valueOf(num).toCharArray();

        for (int i = intChar.length - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(intChar[i]));
            Map<Integer, String> map = new HashMap<>();

            switch (i) {
                case 0:
                    map = units;
                    break;
                case 1:
                    map = tens;
                    break;
                case 2:
                    map = hundreds;
                    break;
                case 3:
                    map = thousands;
                    break;
            }

            roman.append(map.get(digit) == null ? "" : map.get(digit) + " ");
        }

        return new String(roman);
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
