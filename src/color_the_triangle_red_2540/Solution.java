package color_the_triangle_red_2540;

import java.util.*;
class Solution {
    public int[][] colorRed(int n) {
        var result = new ArrayList<int[]>();
        result.add(make(1,1));

        for(int i=n;i>1;i-=4){
            for(int j=1;j<2 * i;j+=2){
                result.add(make(i,j));
            }
        }

        for(int i=n-1;i>1;i-=4){
            result.add(make(i, 2));
        }

        for(int i=n-2;i>=1;i-=4){
            for(int j=3;j<2*i;j+=2){
                result.add(make(i,j));
            }
        }

        for(int i=n-3;i>1;i-=4){
            result.add(make(i,1));
        }

        return result.toArray(int[][]::new);
    }

    private int[] make(int a, int b){
        return new int[]{a,b};
    }
}