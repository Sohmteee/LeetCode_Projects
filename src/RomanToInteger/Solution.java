package RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int romanToInt(String s) {
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

        char[] intChar = s.toCharArray();
        String n = "";

        for (String roman : units.values()) {
            if (s.contains(roman)){
                for (int key : units.keySet()) {
                    if (units.get(key) == roman & (roman.length() > n.length())) {
                        n = roman;
                    }
                }
            }
//            s = s.replace(roman, units.keySet());
        }

        System.out.println(n);

        /*s = s.replace("IV", "4");
        s = s.replace("IX", "9");
        s = s.replace("XL", "4");
        s = s.replace("XC", "9");
        s = s.replace("CD", "4");
        s = s.replace("CM", "9");

        s = s.replace("I", "1");
        s = s.replace("V", "5");
        s = s.replace("X", "1");
        s = s.replace("L", "5");
        s = s.replace("C", "1");
        s = s.replace("D", "5");
        s = s.replace("M", "1");*/

        return Integer.parseInt(s);

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XIX"));
    }
}
