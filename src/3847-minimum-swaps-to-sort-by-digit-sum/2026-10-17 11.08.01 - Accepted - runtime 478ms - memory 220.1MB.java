class Solution {
    public int minSwaps(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i] = new int[]{nums[i], sum(nums[i])};
        }
        int sorted[][] = new int[n][2];
        for(int i=0;i<n;i++){
            sorted[i] = arr[i].clone();
        }

        Arrays.sort(sorted, (a,b)->{
            if(a[1] == b[1]){
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i][0], i);
        }

        boolean vis[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            if(arr[i][0] == sorted[i][0]){
                vis[i] = true;
                continue;
            }

            int cnt = 0;

            int ind = i;
            while(!vis[ind]){
                vis[ind] = true;
                ind = map.get(sorted[ind][0]);
                cnt++;
            }

            
            
            ans += (cnt - 1);

        }

        return ans;
    }

    private int sum(int x){
        int sum = 0;
        for(int y=x;y>0;y/=10){
            sum += y%10;
        }

        return sum;
    }

}