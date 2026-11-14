class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long ans =0;
        int pre[] = new int[n];

        pre[0] = damage[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + damage[i];
        }

        for(int i=0;i<n;i++){
            ans += binarySearch(pre, i, requirement[i], hp);
        }

        return ans;
    }

    private int binarySearch(int pre[], int ind, int req, int hp){
        int total = 0;

        int start = 0;
        int end = ind;
        while(start <= end){
            int mid = (start + end)/2;
            int damage = pre[ind] - (mid ==0 ? 0 : pre[mid-1]);

            if(hp - damage >= req){
                total = (ind - mid + 1);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return total;
    }
}