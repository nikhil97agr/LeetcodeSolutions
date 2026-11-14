package count_houses_in_a_circular_street_ii_2897;

// Definition for a street.
abstract class Street {
    public Street(int[] doors) {}
    public abstract void closeDoor();
    public abstract boolean isDoorOpen();
    public abstract void moveRight();
}
class Solution {
    public int houseCount(Street street, int k) {
        int ans = 0;
        while(!street.isDoorOpen()) street.moveRight();

        for(int i=1;i<=k;i++){
            street.moveRight();
            if(street.isDoorOpen()) ans= Math.max(ans, i);
            street.closeDoor();
        }

        return ans;
        
    }
}