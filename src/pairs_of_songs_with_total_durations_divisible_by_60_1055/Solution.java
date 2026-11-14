package pairs_of_songs_with_total_durations_divisible_by_60_1055;

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        long freq[] = new long[60];
        for(int x : time){
            int rem = x%60;
            
            freq[(60-rem)%60]++;
        }
        for(int i=0;i<60;i++){
            if(freq[i]!=0){
                System.out.println(i+":"+freq[i]);
            }
        }
        long total = 0;
        for(int i=0;i<=30;i++){
            if(i==0 || i==30){
                if(freq[i]>1){
                    
                    total += (freq[i]*(freq[i]-1))/2;
                }
            }
            else{
                    total += (freq[i]*freq[60-i]);
                }
        }
        return (int)(total);
    }
}