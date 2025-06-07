package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //int[] nums = {-1};
        int[] nums = {1,2,3,4,5};
        Main main = new Main();
        int a = main.maxProfit122(nums);
        System.out.println(a);
    }

    public int maxProfit122(int[] prices) {
        int minPrice = prices[0];
        int totalProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            else if (minPrice < prices[i]) {
                totalProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return totalProfit;
    }

    public int maxSubArray(int[] nums) {
        int currResult = nums[0];
        int bestResult = currResult;
        for (int i = 1; i < nums.length; i++) {
            currResult = Math.max(currResult + nums[i], nums[i]);
            if (currResult > bestResult) {
                bestResult = currResult;
            }
        }
        return bestResult;
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int currMinPrice = prices[0];
        int currMaxPrice = prices[1];
        int currProfit = currMaxPrice - currMinPrice;

        int bestProfit = currProfit;
        int i = 2;
        while (i < prices.length ) {
            if (currProfit < 0){
                currMinPrice = currMaxPrice;
                currMaxPrice = prices[i];
            }
            else if (prices[i] > currMaxPrice) {
                currMaxPrice = prices[i];
            }
            else if (prices[i] < currMinPrice && i + 1 != prices.length) {
                currMinPrice = prices[i];
                currMaxPrice = prices[++i];
            }
            currProfit = currMaxPrice - currMinPrice;

            if (currProfit > bestProfit) {
                bestProfit = currProfit;
            }
            i++;
        }
        if (bestProfit < 0)
            bestProfit = 0;
        return bestProfit;
    }
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int insertPos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[insertPos++] = nums[i];
            }
        }
        return insertPos;
    }

    public String multiply(String num1, String num2) {
        int firstNumCount = 0;
        int SecondNumCount = 0;
        int firstNumLength = num1.length();
        int SecondNumLength = num2.length();
        int result = 0;
        int carry = 0;
        while (firstNumCount < firstNumLength + SecondNumLength) {

        }


        return null;
    }
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        int carry = 1;
        int i = digits.length - 1;

        while (i >= 0 && carry > 0) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            i--;
        }

        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }

        return digits;
    }

    public int[] evenOdd(int[] nums) {
        int even = 0;
        int odd = nums.length - 1;
        while (even < odd) {
            if (nums[even] % 2 == 0) {
                even++;
            } else {
                if (nums[odd] % 2 == 0) {
                    int temp = nums[odd];
                    nums[odd] = nums[even];
                    nums[even] = temp;
                } else {
                    odd--;
                }
            }
        }
        return nums;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
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
        while (count != iters) {

            if (num1Counter < 0) {
                num1Counter = 0;
            }
            if (num2Counter < 0) {
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
            if (nums1[num1Counter] > nums1[num2Counter]) {
                int temp = nums1[num1Counter];
                nums1[num1Counter] = nums1[num2Counter];
                nums1[num2Counter] = temp;
                num2Counter++;
                num1Counter--;
            }
        }
    }
}