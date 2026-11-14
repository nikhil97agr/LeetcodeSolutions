package find_smallest_common_element_in_all_rows_1143;

class Solution {
    public int smallestCommonElement(int[][] mat) {
        int cnt[] = new int[10001];
        int next = 0;
        int m = mat.length;
        int n = mat[0].length;

        for(int i=0;i<m;i++){
            for(int x : mat[i]){
                cnt[x]++;
            }
            while(next < cnt.length && cnt[next] !=(i+1)) next++;

            if(next == cnt.length) return -1;
        }


        return next;
    }
}