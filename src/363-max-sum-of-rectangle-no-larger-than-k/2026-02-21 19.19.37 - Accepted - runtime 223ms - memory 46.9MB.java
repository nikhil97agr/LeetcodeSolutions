class Solution {
    public int maxSumSubmatrix(int[][] matrix, int req) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int sum[] = new int[m];
            for(int j=i;j<n;j++){
                for(int k=0;k<m;k++){
                    sum[k] += matrix[k][j];
                }

                ans = Math.max(ans, check(sum, req));
                if(ans == req) return ans;
            }
        }


        return ans;

    }

    private int check(int sum[], int req){
        int curr = 0;
        int ans = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for(int x : sum){
            curr += x;

            Integer ceil = set.ceiling(curr - req);
            if(ceil !=null){
                ans = Math.max(ans, curr - ceil);
            }

            set.add(curr);
        }

        return ans;
    }
}