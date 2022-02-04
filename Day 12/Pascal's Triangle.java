/* Given an integer numRows, return the first numRows of Pascal's triangle. 
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] */


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(new Integer[]{1}));
        if (numRows >= 2)
            res.add(Arrays.asList(new Integer[]{1, 1}));
        
        for(int i = 2; i <= numRows; i++) {
            Integer[] list = new Integer[i];
            list[0] = list[i - 1] = 1;
            for (int j = 1; j < i - 1; j++) {
                List<Integer> temp = res.get(i - 1);
                list[j] = temp.get(j - 1) + temp.get(j);
            }
            res.add(Arrays.asList(list));
        }
        if (numRows > 1)
            res.remove(1);
        return res;
    }
}
