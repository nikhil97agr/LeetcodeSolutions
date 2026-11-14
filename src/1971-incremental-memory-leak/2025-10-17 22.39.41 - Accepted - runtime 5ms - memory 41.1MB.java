class Solution {
    public int[] memLeak(int m1, int m2) {

        int t = 1;
        while(true){
            if(t > Math.max(m1, m2)){
                return new int[]{t, m1, m2};
            }

            if(m1 >= m2){
                m1 -= t;
            }else{
                m2 -= t;
            }
            t++;
        }
    }
}