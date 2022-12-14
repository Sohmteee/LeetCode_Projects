package IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String intToRoman(int num) {
        //create a StringBuilder that will hold the final result
        StringBuilder roman = new StringBuilder();

        if (num >= 4000) return "";

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

        char[] intChar = String.valueOf(num).toCharArray();
        char[] reverseChar = new char[intChar.length];

        //reverse the intChar
        for (int i = intChar.length - 1; i >= 0; i--) {
            for (int j = 0; j < intChar.length; j++) {
                if (reverseChar[j] == '\0') {
                    reverseChar[j] = intChar[i];
                    break;
                }
            }
        }

        //insert the respective roman numeral for each digit
        for (int i = 0; i < intChar.length; i++) {
            int digit = Integer.parseInt(String.valueOf(reverseChar[i]));

            Map<Integer, String> map = switch (i) {
                case 0 -> units;
                case 1 -> tens;
                case 2 -> hundreds;
                case 3 -> thousands;
                default -> new HashMap<>();
            };

            roman.insert(0, map.get(digit) == null ? "" : map.get(digit));
        }

        return new String(roman);
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
