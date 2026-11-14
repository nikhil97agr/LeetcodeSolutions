class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int cnt[] = new int[length + 1];
        for(int i[] : updates){
            cnt[i[0]] += i[2];
            cnt[i[1] + 1] -= i[2];
        }
        int ans[] = new int[length];
        int total = 0;
        for(int i=0;i<length;i++){
            total += cnt[i];
            ans[i] = total;
        }

        return ans;
    }
}