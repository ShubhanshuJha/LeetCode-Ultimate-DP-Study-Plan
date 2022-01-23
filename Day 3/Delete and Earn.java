/* You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
    Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times. */

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            max = Integer.max(nums[i], max);
        }
        
        int freq[] = new int[max + 1];
        int inc[] = new int[max + 1];
        int exc[] = new int[max + 1];
        
        for(int i = 0; i < n; i++){
            freq[nums[i]]++;
        }
        inc[0] = 0;
        exc[0] = 0;
        for(int i = 1; i < freq.length; i++){
            if(freq[i] == 0) {
                inc[i] = Integer.max(inc[i-1], exc[i-1]);
                exc[i] = inc[i];
            } else {
                inc[i] = i * freq[i] + exc[i - 1];
                exc[i] = Integer.max(inc[i - 1], exc[i - 1]);
            }
        }
        return Integer.max(inc[freq.length - 1], exc[freq.length - 1]);
    }
}
