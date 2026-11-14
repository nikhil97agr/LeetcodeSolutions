class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int left[] = new int[n+1];
        int right[] = new int[n+1];
        int count = 0;
        for(int i=1;i<=n;i++){
            left[i] = count;
            if(customers.charAt(i-1)=='N'){
                count++;
            }
            
        }
        count = 0;
        for(int i=n-1;i>=0;i--){
            if(customers.charAt(i)=='Y'){
                count++;
            }
            right[i] = count;
        }
        int result[] = new int[n+1];
        for(int i=0;i<=n;i++){
            result[i] = left[i]+right[i];
        }
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
            if(result[i]<min){
                min = result[i];
                ans = i;
            }
        }

        return ans;
    }
}