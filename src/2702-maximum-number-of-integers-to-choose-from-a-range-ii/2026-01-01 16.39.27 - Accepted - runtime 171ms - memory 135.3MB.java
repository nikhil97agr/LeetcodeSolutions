class Solution {
    public int maxCount(int[] banned, int n, long maxSum) {
        int ans = 0;
        TreeMap<Integer, Long> map = new TreeMap<>();
        Set<Integer> set = Arrays.stream(banned).boxed().collect(Collectors.toSet());
        banned = new int[set.size()];
        int ind = 0;
        for(int x : set){
            banned[ind] = x;
            ind++;
        }
        Arrays.sort(banned);
        

        long sum =0;
        for(int x : banned){
            sum += x;
            map.put(x, sum);
        }
        int start = 1;
        int end = n;
        while(start <= end){
            int mid  = start + (end - start)/2;

            Integer lower = map.floorKey(mid);
            long total = getSum(mid);
            
            long dec = 0;
            if(lower != null){
                dec = map.get(lower);
            }

            long left = total - dec;
            
            if(left <= maxSum){
                int cnt = lower == null ? 0 : getInd(banned, lower);
                ans = Math.max(ans, mid - cnt);
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }

        return ans;
    }

    private int getInd(int arr[], int val){
        int ans = 0;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end)/2;

            if(arr[mid] <= val){
                ans = mid + 1;
                start =mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }

    private long getSum(int n){
        return (1l*n*(1 + n) )/ 2;
    }
}