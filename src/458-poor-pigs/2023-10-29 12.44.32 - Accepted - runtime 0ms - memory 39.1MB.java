class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if(buckets==1) return 0;

        buckets--;

        int rounds = minutesToTest/minutesToDie + 1;
        int count = 0;

        while(buckets > 0){
            count++;
            buckets /= rounds;
        }
        return count;
    }
}