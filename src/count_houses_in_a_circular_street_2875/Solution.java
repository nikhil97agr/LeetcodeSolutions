package count_houses_in_a_circular_street_2875;

// Definition for a street.
abstract class Street {
    public Street(int[] doors) {}
    public abstract void openDoor();
    public abstract void closeDoor();
    public abstract boolean isDoorOpen();
    public abstract void moveRight();
    public abstract void moveLeft();
}
class Solution {
    public int houseCount(Street street, int k) {
        int cnt = 0;
        while(cnt < k){
            if(street.isDoorOpen()) street.closeDoor();
            cnt++;
            street.moveRight();
        }

        cnt = 1;
        street.openDoor();
        street.moveRight();
        while(!street.isDoorOpen()){
            cnt++;
            street.moveRight();
        }

        return cnt;
    }
}