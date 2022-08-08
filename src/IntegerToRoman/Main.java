package IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String intToRoman(int num) {
        String roman = "";
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


        return thousands.get(num % 1000) + hundreds.get(num % 100) + tens.get(num % 10) + units.get(num % 1);
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1));
    }
}
