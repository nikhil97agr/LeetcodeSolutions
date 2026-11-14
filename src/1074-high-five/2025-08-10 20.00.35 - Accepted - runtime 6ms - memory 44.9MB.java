class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i[]: items){
            map.computeIfAbsent(i[0], x -> new ArrayList<>()).add(i[1]);
        }

        int ans[][] = new int[map.size()][2];
        int ind = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int id = entry.getKey();
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            int sum = 0;
            for(int i=list.size()-1;i>=list.size()-5;i--){
                sum += list.get(i);
            }
            ans[ind++] = new int[]{id, sum / 5};
        }

        Arrays.sort(ans, (a1,a2) -> a1[0] - a2[0]);
        return ans;
    }
}