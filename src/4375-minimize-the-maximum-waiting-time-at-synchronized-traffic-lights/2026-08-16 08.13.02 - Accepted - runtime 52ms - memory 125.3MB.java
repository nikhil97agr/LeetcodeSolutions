class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n= lights.length;
        int m = arrivalTime.length;

        int r[] = new int[m];
        for(int i=0;i<m;i++){
            r[i] = arrivalTime[i]%period;
            
        }
        Arrays.sort(lights);
        Arrays.sort(r);

        int start = 0;
        int end = Integer.MAX_VALUE;
        int ans = 0;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(check(mid, r, lights, n, m,  period)){
                ans= mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int mid, int r[], int lights[], int n, int m, int period){
        int i=0;
        int j=0;

        while(i < n && j < m){
            if(r[j] < lights[i]){
                j++;
                continue;
            }
            int wait =period - r[j];

            if(wait <= mid){
                j++;
                continue;
            }

            i++;

            
            
        }
        while( j < m && period - r[j] <= mid){
            j++;
        }

        if(j == m) return true;

        return false;
    }
}