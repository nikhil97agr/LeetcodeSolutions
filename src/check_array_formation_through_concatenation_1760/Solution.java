package check_array_formation_through_concatenation_1760;

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for(int p[] : pieces){
            int i=0;
            int j=0;

            while(j < arr.length  && arr[j] != p[i]) j++;

            while(j < arr.length && i < p.length){
                if(arr[j] != p[i]) return false;
                i++;
                j++;
            }

            if(i!=p.length){
                return false;
            }
        }
        return true;
    }
}