class Solution {
    public boolean isReachable(int targetX, int targetY) {
        int gcd = gcd(targetX, targetY);
        while(targetX > 1 && targetY > 1){
            if(targetX%2==0){
                targetX/=2;
            }
            else if(targetY%2==0){
                targetY/=2;
            }else if(targetX >= targetY){
                targetX-=targetY;
            }else{
                targetY -= targetX;
            }
        }

        if((targetX == 1 && targetY > 1 ) || (targetY == 1 && targetX > 1)){
            targetX = 1;
            targetY = 1;
        }
        if(targetX < 1 || targetY < 1) return false;
        

        return (gcd & (gcd - 1))==0;
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}