package IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public String intToRoman(int num) {
        String roman = "";
        Map<Integer, String> units = new HashMap<>(),
                tens = new HashMap<>(),
                hundreds = new HashMap<>(),
                thousands = new HashMap<>();

        String [] unit = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String [] ten = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String [] hundred = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String [] thousand = {"M", "MM", "MMM"};

        for (int i = 1; i <= unit.length; i++) units.put(i, unit[i]);

        return roman;
    }
}
