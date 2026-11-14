package self_crossing_335;

class Solution {
    public boolean isSelfCrossing(int[] distance) {
        int x1, x2, x3, x4, x5;

        boolean up = false;
        if(distance.length < 4) return false;

        x1 = 0;
        x2 = distance[0];
        x3 = distance[1];
        x4 = distance[2];

        if(x2  <x4){
            up = true;
        }

        for(int i=3;i<distance.length;i++){
            x5 = distance[i];

            if(!up && x5 >= x3) return true;

            if(up && x5 <= x3){
                if(x5 + x1 < x3 || (i + 1 < distance.length && distance[i+1] +x2 < x4)){
                    up = false;
                }else if(i + 1 < distance.length){
                    return true;
                }
            }
                    x1 = x2;
        x2 = x3;
        x3 = x4;
        x4 = x5;
        }


        return false;
    }

}