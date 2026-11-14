class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
         int n = plantTime.length;
        if(n==1){
            return plantTime[0]+growTime[0];
        }
        int plant[][] = new int[n][2];
        for(int i=0;i<n;i++){
            plant[i] = new int[]{plantTime[i], growTime[i]};
        }
        Arrays.sort(plant, (a,b)->{
            if(a[1]>b[1]){
                return -1;
            }else if(a[1]<b[1]){
                return 1;
            }
            return a[0]-b[0];
        });

        int result = 0;
        int currentPlantTime= 0;
        for(int p[] : plant){
            currentPlantTime += p[0];
            result = Math.max(result, currentPlantTime + p[1]);
        }
        return result;
    }
}