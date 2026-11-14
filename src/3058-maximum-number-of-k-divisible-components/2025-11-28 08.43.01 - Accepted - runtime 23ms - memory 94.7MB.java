class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        int ans[] = new int[]{0};

        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }

        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        solve(ans, adjList, k, -1, 0, values);
        return ans[0];

    }

    private long solve(int ans[], LinkedList<Integer> adjList[], int k, int parent, int curr, int[] values){
        long sum = 0;

        for(int x : adjList[curr]){
            if(x != parent){
                sum += solve(ans, adjList, k, curr, x, values);
            }
        }

        sum += values[curr];
        if(sum%k==0){
            ans[0]++;
            return 0;
        }

        return sum;
    }

}