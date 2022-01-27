/* You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
Return the maximum score of a pair of sightseeing spots. */

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int score = values[0]; // values[0] + 0;
        int maxScore = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            maxScore = Integer.max(maxScore, score + values[i] - i); // updating maxScore with a[i] + i + a[j] - j
            score = Integer.max(score, values[i] + i); // updating score with currMax value of a[i] + i;
        }
        return maxScore;
    }
}
