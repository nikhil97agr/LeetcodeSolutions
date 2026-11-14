package moving_stones_until_consecutive_1103;

import java.util.*;
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int ar[] = new int[]{a,b,c};
        Arrays.sort(ar);

        a = ar[0]; b=ar[1]; c=ar[2];

        if(b-a == 1 && c-b ==1) return new int[]{0,0};
        int min = 0;

        if(b-a == 1 || c - b==1 || c-b == 2 || b - a==2) min = 1;
        else min = 2;

        return new int[]{
            min,
            b-1-a + c - (b+1)
        };


    }
}