package LongestPalindromicSubstring;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String newString = "";
        if (s.length() == 1) return s;

        char[] sl = s.toCharArray();
        ArrayList<Character> al = new ArrayList<>();
        ArrayList<Character> ssl = new ArrayList<>();

        for (char c : sl) {
            al.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            ssl.add(al.get(i));
            for (int j = 1; j < s.length(); j++) {
                if (i < j) {
                    ssl.add(al.get(j));

                    if (arrayListToString(ssl).equals(reverseString(arrayListToString(ssl))) && arrayListToString(ssl).length() > newString.length()) {
                        newString = arrayListToString(ssl);
                    }
                }
            }
            ssl.clear();
        }

        if (s.length() == 2 && sl[0] != sl[1]) return String.valueOf(sl[0]);

        if (newString.equals("")) newString = String.valueOf(sl[0]);

        return newString;
    }

    public static String reverseString(String A) {
        char[] a = A.toCharArray();
        ArrayList<Character> al = new ArrayList<>();

        for (char c : a) {
            al.add(c);
        }

        Collections.reverse(al);

        for (int i = 0; i < A.length(); i++) {
            a[i] = al.get(i);
        }

        return new String(a);
    }

    public static String arrayListToString(ArrayList<Character> al) {
        char[] a = new char[al.size()];

        for (int i = 0; i < al.size(); i++) {
            a[i] = al.get(i);
        }

        return new String(a);
    }
}
