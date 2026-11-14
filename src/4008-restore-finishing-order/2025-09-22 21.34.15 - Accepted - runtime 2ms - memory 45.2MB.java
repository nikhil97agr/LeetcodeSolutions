class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = friends.length;
        Set<Integer> set = new HashSet<>();
        for(int x : friends){
            set.add(x);
        }
        int i=0;
        int ans[] = new int[n];
        for(int x : order){
            if(set.contains(x)){
                ans[i++] = x;
            }
        }

        return ans;
    }
}