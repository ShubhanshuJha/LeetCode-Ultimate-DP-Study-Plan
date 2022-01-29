/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining. */


// With Array Preprocessing approach that takes O(n) extra space
class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int waterTrapped = 0;
        left[0] = heights[0];
        right[n - 1] = heights[n - 1];
        
        for (int i = 1; i < n; i++)
            left[i] = Integer.max(left[i - 1], heights[i]);
        for (int i = n - 2; i >= 0; i--)
            right[i] = Integer.max(right[i + 1], heights[i]);
        
        for (int i = 0; i < n; i++)
            waterTrapped += Integer.min(left[i], right[i]) - heights[i];
	
	return waterTrapped;
    }
}


// Constant space solution
class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        int left = 0, right = n - 1, waterTrapped = 0;
        int maxLeft = heights[left];
        int maxRight = heights[right];
 
        while (left < right){
            if (heights[left] <= heights[right]){
                left++;
                maxLeft = Integer.max(maxLeft, heights[left]);
                waterTrapped += (maxLeft - heights[left]);
            }
            else {
                right--;
                maxRight = Integer.max(maxRight, heights[right]);
                waterTrapped += (maxRight - heights[right]);
            }
        }
	return waterTrapped;
    }
}
