class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int ans = Integer.MAX_VALUE;

        for(int i=1;i<=6;i++){
            int a = 0;
            int b=0;
            int same = 0;
            for(int j=0;j<n;j++){
                if(A[j] == B[j] && A[j] == i){
                    same++;
                }else if(A[j] == i) a++;
                else if(B[j] == i) b++;
            }

            if(a+b+same == n){
                ans = Math.min(ans, Math.min(a, b));
            }


        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}