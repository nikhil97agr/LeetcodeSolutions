class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;
        int ans[] = new int[m];

        long pre[] = new long[n];
        pre[0] = tasks[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i - 1] + tasks[i];
        }

        boolean partial = false;
        long left = 0;
        int ind = 0;
        long full = pre[n-1];
        for(int i=0;i<m;i++){
            long rem = shifts[i];
            long sum = 0;
            if(partial){
                 sum = left + get(pre, ind + 1, n - 1);
            }else{
                sum = get(pre, ind, n - 1);
            }


            
            
            if(sum < rem){
                partial =false;
                ans[i] = 0;
                left = 0;
                ind = 0;
                continue;
            }
            
            if(partial){
                
                if(rem == left){
                    ans[i] = (n - 1) - ind;
                    partial = false;
                    left = 0;
                    ind = (ind + 1)%n;
                    continue;
                }
                
                if(rem < left){
                    ans[i] =  n - ind;
                    left -= rem;
                    partial = true;
                    continue;
                }
                
                rem -= left;
                ind++;
                int endInd = binarySearch(pre, rem, ind, n);
                long s = get(pre, ind, endInd);

                if(s == rem){
                    partial = false;
                    ind =(endInd + 1)%n;
                    ans[i] = (n-1) - endInd;
                    left = 0;
                }else{
                    ind = endInd;
                    left = s - rem;
                    ans[i] = n - endInd;
                }
            }else{
                int endInd = binarySearch(pre, rem, ind, n);
                long s = get(pre, ind, endInd);
                if(s == rem){
                    ind =(endInd + 1)%n;
                    ans[i] = (n-1) - endInd;
                }else{
                    partial = true;
                    ind = endInd;
                    left = s - rem;
                    ans[i] = n - endInd;
                }
            }
            
        }
        

        return ans;
    }
    
    private int binarySearch(long pre[], long value, int start, int n){
        int end = n- 1;
        int s = start;
        int ind = -1;
        while(start <= end){
            int mid = (start + end)/2;
            
            long sum = get(pre,s, mid);
            
            if(sum >= value){
                ind = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return ind;
        
    }

    private long get(long pre[], int start, int end){
        if(start > end){
            return 0;
        }
        if(start == 0) return pre[end];
        return pre[end] - pre[start - 1];
    }
}