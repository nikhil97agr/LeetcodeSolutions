package reconstruct_a_2_row_binary_matrix_1379;

import java.util.*;
class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        boolean result[][] = new boolean[2][colsum.length];
        int n = colsum.length;

        for(int i=0;i<n;i++){
            if(colsum[i] == 2){
                result[0][i] = result[1][i] = true;
                upper--;
                lower--;
            }
        }
        if(upper < 0 || lower < 0){
            return new ArrayList<>();
        }

        for(int i=0;i<n && upper > 0;i++){
            if(colsum[i] == 1){
                colsum[i] = 0;
                upper--;
                result[0][i]= true;
            }
        }

        for(int i=0;i<n;i++){
            if(colsum[i] ==1){
                colsum[i] = 0;
                lower--;
                result[1][i] = true;
            }
        }

        if(upper !=0 || lower!=0) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for(boolean arr[]: result){
            List<Integer> temp = new ArrayList<>();
            for(boolean x : arr){
                if(x) temp.add(1);
                else temp.add(0);
            }
            list.add(temp);
        }

        return list;
    }

}