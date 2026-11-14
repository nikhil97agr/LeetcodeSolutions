class Solution {
    public int minimumTime(int[] hens, int[] grains) {
        Arrays.sort(hens);
        Arrays.sort(grains);

        int ans =-1;
        int start = 0;
        int end = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(check(mid, hens, grains)){
                ans= mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int time, int hens[], int grains[]){
        int i =0;
        int j=0;
        int n = hens.length;
        int m = grains.length;
        if(time <= 4){
            System.out.println("THIS");
        }
        while( i < n && j <m){
            int startPos = hens[i] - time;
            if(grains[j] < startPos){
                return false;
            }
            int max= Math.max(startPos, grains[j]);
            int left = (hens[i] - max);
            while( j < m && grains[j] <= hens[i]){
                j++;
            }
            int t1 = time- Math.max(left, 0)*2;
            int t2 = time - Math.max(left, 0);
            if(t2/2 > t1){
                int end = hens[i] + t2/ 2;
                while(j < m && grains[j] <= end ){
                    j++;
                }
            }else{
                int end = hens[i] + Math.max(t1, 0);
                while(j < m && grains[j] <= end){
                    j++;
                }
            }
            i++;
        }

        return j == m;
    }
}