/* Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer. A subarray is a contiguous subsequence of the array. */

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int currProd = 1;
        int kadanes = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            currProd *= nums[i];
            kadanes = Integer.max(kadanes, currProd);
            if (currProd == 0)
                currProd = 1;
        }
        currProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            currProd *= nums[i];
            kadanes = Integer.max(kadanes, currProd);
            if (currProd == 0)
                currProd = 1;
        }
        return kadanes;
    }
}
