class Solution {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int ans[] = new int[m];

        int q[][] = new int[m][];
        for(int i=0;i<m;i++){
            q[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(q, (a,b) -> a[0] - b[0]);

        int start = 0;
        int end = n;
        int time = 0;
        boolean add = false;
        for(int que[] : q){
            int t = que[0];
            int ind = que[1];
            int i = que[2];

            while(time < t){
                if(!add){
                    if(start < end){
                        start++;
                    }else{
                        add = true;
                        start = 0;
                        end = 1;
                    }
                }else{
                    if(end <n){
                        end++;
                    }else{
                        add = false;
                        start = 1;
                    }
                }
                time++;
            }

            if(end - start <= ind){
                ans[i] = -1;
            }else{
                ans[i] = nums[start + ind];
            }

        }

        return ans;
    }
}