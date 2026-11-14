class Solution {
    public long minCost(int[] nums, int[] costs) {
        int nge[] = nge(nums);
        int nle[] = nle(nums);
        int n = costs.length;
        Long dp[] = new Long[n];
        return solve(0, nums.length, nge, nle, costs, dp);



    }

    private long solve(int i, int n, int nge[], int nle[], int costs[], Long dp[]){
        if(i==n-1) return 0;
        if(dp[i] !=null) return dp[i];
        long c1 = Long.MAX_VALUE;
        long c2 = Long.MAX_VALUE;

        if(nge[i] !=-1){
            c1 = solve(nge[i], n, nge, nle, costs, dp);
            if(c1 != Long.MAX_VALUE){
                c1 += costs[nge[i]];
            }
        }
        if(nle[i] !=-1){
            c2 = solve(nle[i], n, nge, nle, costs, dp);
            if(c2 !=Long.MAX_VALUE){
                c2 += costs[nle[i]];
            }
        }
        return dp[i] = Math.min(c1, c2);
    }

    private int[] nle(int arr[]){
        int n = arr.length;
        int nle[] = new int[n];
        Arrays.fill(nle, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                nle[stack.pop()] = i;
            }

            stack.push(i);
        }

        return nle;
    }

    private int[] nge(int arr[]){
        int n = arr.length;
        int nge[] = new int[n];
        Arrays.fill(nge, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                nge[stack.pop()] = i;
            }

            stack.push(i);
        }

        return nge;
    }
}
