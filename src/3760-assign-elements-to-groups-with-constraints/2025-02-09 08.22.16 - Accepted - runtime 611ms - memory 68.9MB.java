class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = elements.length;
        int m = groups.length;

        for(int i=n-1;i>=0;i--) map.put(elements[i], i);

        int ans[] = new int[m];

        for(int i=0;i<m;i++){
            ans[i] = assign(groups[i], map);
        }

        return ans;
    }

    private int assign(int ele, Map<Integer, Integer> map){
        int ans = Integer.MAX_VALUE;

        for(int i=1;i<=Math.sqrt(ele);i++){
            if(ele%i==0){
                int x = i;
                int y = ele/i;

                ans = Math.min(ans, Math.min(map.getOrDefault(x, Integer.MAX_VALUE),map.getOrDefault(y, Integer.MAX_VALUE)));
            }
        }

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}