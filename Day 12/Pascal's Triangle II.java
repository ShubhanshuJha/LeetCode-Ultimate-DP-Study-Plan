/* Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
Input: rowIndex = 3
Output: [1,3,3,1] */


class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(new Integer[]{1}));
        if (rowIndex > 1)
            res.add(Arrays.asList(new Integer[]{1, 1}));
        
        for(int i = 2; i <= rowIndex + 1; i++) {
            Integer[] list = new Integer[i];
            list[0] = list[i - 1] = 1;
            for (int j = 1; j < i - 1; j++) {
                List<Integer> temp = res.get(i - 1);
                list[j] = temp.get(j - 1) + temp.get(j);
            }
            res.add(Arrays.asList(list));
        }
        if (rowIndex > 1)
            res.remove(1);
        return res.get(rowIndex);
    }
}
