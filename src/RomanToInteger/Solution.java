package RomanToInteger;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Solution {
    public static int romanToInt(String s) {
        s = s.toUpperCase(Locale.ROOT);
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

        String rom = "";
        String th, h, t, u;

        u = getString(s, units);
        if (u != "") s = s.replace(units.get(Integer.parseInt(u)), "\0");
        t = getString(s, tens);
        if (t != "") s = s.replace(tens.get(Integer.parseInt(t)), "\0");
        h = getString(s, hundreds);
        if (h != "") s = s.replace(hundreds.get(Integer.parseInt(h)), "\0");
        th = getString(s, thousands);
        if (th != "") s = s.replace(thousands.get(Integer.parseInt(th)), "\0");

        rom = th + h + t + u;

        return Integer.parseInt(rom);

    }

    private static String getString(String s, Map<Integer, String> map) {
        String n = "";
        for (String roman : map.values()) {
            if (s.contains(roman)) {
                for (int key : map.keySet()) {
                    if (map.get(key) == roman & (roman.length() > n.length())) {
                        n = roman;
                    }
                }
            }
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue().equals(n) && !n.equals("")) {
                n = String.valueOf(entry.getKey());
            }
        }


        return n;
    }

    public static void main(String[] args) {
        System.out.println("III : " + romanToInt("III"));
        System.out.println("LVIII : " + romanToInt("LVIII"));
        System.out.println("MCMXCIV : " + romanToInt("MCMXCIV"));
        System.out.println("IX : " + romanToInt("IX"));
        System.out.println("MDLXX : " + romanToInt("MDLXX"));

    }
}
