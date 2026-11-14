class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int s1 = 0;
        int s2 = 0;
        int n = nums1.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            s1 += nums1[i];
            s2 += nums2[i];

            int diff = s1 - s2;
            if(map.containsKey(diff)){
                ans = Math.max(ans, i - map.get(diff));
            }else{
                map.put(diff, i);
            }
            

        }

        return ans;
    }
}