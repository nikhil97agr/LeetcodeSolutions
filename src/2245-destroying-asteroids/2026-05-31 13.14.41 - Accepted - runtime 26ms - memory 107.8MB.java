class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = mass;
        for(int x : asteroids){
            if(sum >= x){
                sum +=x;
            }else{
                return false;
            }
        }

        return true;
    }
}