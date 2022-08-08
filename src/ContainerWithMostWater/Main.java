/*
* You are given an integer array height of length n.
* There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
*
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
* In this case, the max area of water (blue section) the container can contain is 49.
* */

package ContainerWithMostWater;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int width = right - left;
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * width);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}


