package ReverseInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverse(
                1534236));
        System.out.println(reverse(
                123));
    }


    private static int reverse(int x) {
        boolean isNegative = false;
        int reverse = 0;

        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        while (x > 0) {
            reverse = (reverse * 10) + x % 10;
            x /= 10;
        }

        return (isNegative) ? -reverse : reverse;

    }
}
