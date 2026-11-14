/**
 * Definition for a street.
 * class Street {
 *     public Street(int[] doors);
 *     public void closeDoor();
 *     public boolean isDoorOpen();
 *     public void moveRight();
 * }
 */
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