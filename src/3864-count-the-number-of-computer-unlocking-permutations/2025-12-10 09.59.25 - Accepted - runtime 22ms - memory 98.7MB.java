class Solution {
    public int countPermutations(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=1;i<n;i++){
            que.offer(arr[i]);
        }
        long ans =1;

        if(arr[0] < que.peek()){
            int cnt= n-1;
            for(int i=1;i<n;i++){
                ans = multi(ans, cnt);
                cnt--;
            }

            return (int)ans;
        }

        return 0;
        
    }

    private long multi(long a, long b){
        long mod = (long)1e9 + 7;

        return ((a%mod)*(b%mod))%mod;
    }
}