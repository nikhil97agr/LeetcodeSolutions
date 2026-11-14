class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        for(int z[] : grid){
            for(int y : z){
                if(prev == -1){
                    prev = y % x;

                }

                if(y%x!=prev){
                    return -1;
                }
                list.add(y);
            }
        }

        Collections.sort(list);
        if(list.size() == 1) return 0;
        int mid = list.size() / 2;
        int val = list.get(mid);

        int ans = 0;
        for(int y : list){
            int diff = Math.abs(val - y);
            ans += diff/x;
        }

        return ans;
    }
}