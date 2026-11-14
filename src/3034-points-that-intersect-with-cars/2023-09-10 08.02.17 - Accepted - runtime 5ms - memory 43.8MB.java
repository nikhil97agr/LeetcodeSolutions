class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> ans = new HashSet<>();
        for(List<Integer> num : nums){
            for(int i=num.get(0);i<=num.get(1);i++){
                ans.add(i);
            }
        }
        return ans.size();
    }
}