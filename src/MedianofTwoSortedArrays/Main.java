package MedianofTwoSortedArrays;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {5, 8};
        int[] nums2 = {9, 7};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Double> nums1List = new ArrayList<>();
        ArrayList<Double> nums2List = new ArrayList<>();

        for (double c : nums1) {
            nums1List.add(c);
        }

        for (double c : nums2) {
            nums2List.add(c);
        }

        nums1List.addAll(nums2List);

        Collections.sort(nums1List);

        if (nums1List.size() % 2 == 0) {
            return (nums1List.get(((nums1List.size()) / 2) - 1) + nums1List.get(((nums1List.size()) / 2))) / 2;
        }

        return nums1List.get((nums1List.size() / 2));

    }
}

