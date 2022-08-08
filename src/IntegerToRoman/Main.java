package IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Integer, String> units = new HashMap<>(),
            tens = new HashMap<>(),
            hundreds = new HashMap<>(),
            thousands = new HashMap<>();
    public static String[] unit = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    public static String[] ten = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    public static String[] hundred = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    public static String[] thousand = {"M", "MM", "MMM"};

    public static String intToRoman(int num) {
        String roman = "";
        if (num >= 4000) return "";

        for (int i = 1; i <= unit.length; i++) units.put(i, unit[i - 1]);
        for (int i = 1; i <= ten.length; i++) tens.put(i, ten[i - 1]);
        for (int i = 1; i <= hundred.length; i++) hundreds.put(i, hundred[i - 1]);
        for (int i = 1; i <= thousand.length; i++) thousands.put(i, thousand[i - 1]);

        int count = 1;
        while (num > 0) {
            int digit = num % 10;
            var letter = getPlaceValue(count);
            roman =
        }

        return (thousands.get(num / 1000) == null ? "" : thousands.get(num / 1000)) +
                (hundreds.get(num / 100) == null ? "" : hundreds.get(num / 100)) +
                (tens.get(num / 10) == null ? "" : tens.get(num / 10)) +
                (units.get(num) == null ? "" : units.get(num));
    }

    public static String[] getPlaceValue(int num) {
        switch (num) {
            case 1:
                return unit;
            case 2:
                return ten;
            case 3:
                return hundred;
            case 4:
                return thousand;
            default:
                return new String[]{};
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
