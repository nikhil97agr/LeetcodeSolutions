package cycle_length_queries_in_a_tree_2597;

class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int q = queries.length;
        int ans[] = new int[q];

        for(int i=0;i<q;i++){
            ans[i] = getCnt(queries[i][0], queries[i][1]) + 1;
        }
        return ans;
    }

    private int getCnt(int a, int b){
        int cnt = 0;
        while(a != b){
            if(a > b){
                a/=2;
                cnt++;
            }else{
                b/=2;
                cnt++;
            }
        }

        return cnt;
    }
}