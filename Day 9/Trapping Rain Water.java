/* Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining. */

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
