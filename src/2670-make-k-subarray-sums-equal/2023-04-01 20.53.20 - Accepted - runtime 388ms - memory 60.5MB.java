class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        if(n==k){
            return 0;
        }
        List<List<Long>> list = new ArrayList<>();
        
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                List<Long> temp = new ArrayList<>();
                int j =i;
                while(true){
                     if(visited[j]){
                         break;
                     }
                    
                    visited[j] = true;
                    temp.add(1l*arr[j]);
                    j+=k;
                    j%=n;
                }
                list.add(temp);
            }
        }
        long total = 0;
        for(List<Long> l : list){
            TreeMap<Long, Long> map = new TreeMap<>();
            long sum = 0;
            for(long x : l){
                map.put(x, map.getOrDefault(x, 0l)+1);
                sum += 1l*x;
            }
            long ans = Long.MAX_VALUE;
            int m = map.size();
            long left[] = new long[m];
            long right[] = new long[m];
            left[0] = 0;
            right[m-1] = 0;
            int cnt = 0;
            List<Long> keys = new ArrayList(map.keySet());
            for(int i=1;i<m;i++){
                left[i] = left[i-1] + 1l*(cnt+map.get(keys.get(i-1)))*(keys.get(i)-keys.get(i-1));
                cnt += map.get(keys.get(i-1));
            }
            cnt = 0;
            for(int i=m-2;i>=0;i--){
                right[i] = right[i+1] + 1l*(cnt+map.get(keys.get(i+1)))*(keys.get(i+1)-keys.get(i));
                cnt += map.get(keys.get(i+1));
            }
            
            for(int i=0;i<m;i++){
                ans = Math.min(ans, left[i] + right[i]);
            }
            
            
            
            
            total += ans;
            
            }
    
            return total;
    }
}