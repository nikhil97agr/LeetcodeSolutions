class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n==2){
            return true;
        }
        for(int i=0;i<n-2;i++){
            int l1[] = coordinates[i];
            int l2[] = coordinates[i+1];
            int l3[] = coordinates[i+2];
            if((l1[1]-l2[1])*(l3[0]-l2[0])!=(l3[1]-l2[1])*(l1[0]-l2[0])){
                return false;
            }
        }

        return true;

    }
}