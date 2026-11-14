package duplicate_zeros_1168;

import java.util.*;
class Solution {
    public void duplicateZeros(int[] arr) {
        List<Integer> res= new ArrayList<>();
        int i=0;
        while(res.size() != arr.length){
            if(arr[i] == 0){
                res.add(0);
                if(res.size() == arr.length) break;

                res.add(0);
            }else{
                res.add(arr[i]);
            }
            i++;
        }

        for( i=0;i<arr.length;i++){
            arr[i] = res.get(i);
        }
    }
}