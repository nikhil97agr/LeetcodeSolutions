class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int max = Math.max(Arrays.stream(nums1).max().getAsInt(), Arrays.stream(nums2).max().getAsInt());
        int cnt[] = new int[max+1];
        for(int x : nums1){
            if(cnt[x] == 0)cnt[x]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int x : nums2){
            if(cnt[x]==1) {
                res.add(x);
                cnt[x]++;
            }
        }
        int ans[] = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
        
    }
}