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
        t = getString(s, tens);
        h = getString(s, hundreds);
        th = getString(s, thousands);

        System.out.println("\n" + thousands.get(th) + " " + hundreds.get(h) + " " + tens.get(t) + " " + units.get(u));
        System.out.println(th + " " + h + " " + t + " " + u);

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
            if (entry.getValue().equals(n)) {
                System.out.print(n + " ");
                n = String.valueOf(entry.getKey());
            }
        }

        return (n.equals("")) ? "0" : n;
    }

    public static void main(String[] args) {
        System.out.println("\nIII : " + romanToInt("III") + "\n");
        System.out.println("\nLVIII : " + romanToInt("LVIII") + "\n");
        System.out.println("\nMCMXCIV : " + romanToInt("MCMXCIV") + "\n");
        System.out.println("\nIX : " + romanToInt("IX") + "\n");
        System.out.println("\nMDLXX : " + romanToInt("MDLXX") + "\n");

    }
}
