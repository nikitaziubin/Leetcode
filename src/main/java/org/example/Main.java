package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Main main = new Main();
        nums = main.plusOne(nums);
    }
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int addMore = 1;

        while (i >= 0) {
            if (addMore == 0) {
                break;
            }
            int resultOfSum = digits[i] + addMore;

            if (resultOfSum > 9) {
                digits[i--] = resultOfSum % 10;
                continue;
            }
            addMore--;
            digits[i--] = resultOfSum;
        }
        if (addMore == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public int[] evenOdd(int[] nums) {
        int even = 0; int odd = nums.length - 1;
        while (even < odd) {
            if (nums[even] % 2 == 0) {
                even++;
            }
            else {
                if (nums[odd] % 2 == 0) {
                    int temp = nums[odd];
                    nums[odd] = nums[even];
                    nums[even] = temp;
                }
                else {
                    odd--;
                }
            }
        }
        return nums;
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int dayToSell = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] - dayToSell < 0){
                dayToSell = prices[i];
                continue;
            }
            if (prices[i] - dayToSell > profit)
            {
                profit = prices[i] - dayToSell;
            }
        }
        return profit;
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
        {
            return;
        }
        if (m == 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int num1Counter = m - 1;
        int num2Counter = nums2.length - 1;
        int count = 0;
        int iters = Math.max(m, n);
        int lastIters = Math.min(m, n);
        while (count != iters ) {

            if (num1Counter < 0){
                num1Counter = 0;
            }
            if (num2Counter < 0){
                num2Counter = 0;
            }

            if (nums1[num1Counter] > nums2[num2Counter]) {
                int temp = nums1[num1Counter];
                nums1[num1Counter] = nums2[num2Counter];
                nums2[num2Counter] = temp;
            }
            if (nums1[num1Counter] < nums2[num2Counter]) {

                nums1[nums1.length - 1 - count] = nums2[num2Counter];
                num2Counter--;
                num1Counter--;
                count++;
            }
        }
        num1Counter = (nums1.length - 1) / 2;
        num2Counter = (nums1.length - 1) / 2 + 1;
        for (int i = 0; i < lastIters; i++) {
            if (nums1[num1Counter] > nums1[num2Counter])
            {
                int temp = nums1[num1Counter];
                nums1[num1Counter] = nums1[num2Counter];
                nums1[num2Counter] = temp;
                num2Counter++;
                num1Counter--;
            }
        }
    }
}