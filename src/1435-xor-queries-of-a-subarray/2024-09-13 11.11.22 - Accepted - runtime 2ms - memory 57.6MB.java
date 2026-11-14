class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int xor[] = new int[arr.length];
        int result[] = new int[queries.length];
        xor[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            xor[i] = xor[i-1]^arr[i];
        }
        for(int i=0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start==0){
                result[i] = xor[end];
            }else{
                result[i] = xor[end]^xor[start-1];
            }
        }
        return result;
    }
}