import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        new Solution().minTime(
                7,
                new int[][]{
                        {0, 1},
                        {0, 2},
                        {1, 4},
                        {1, 5},
                        {2, 3},
                        {2, 6}
                },
        Arrays.asList(false,false,true,false,true,true,false)
        );
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        LinkedList<Integer> adjList[] = new LinkedList[n];

        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        return solve(0, adjList, -1, hasApple, 0);
    }

    private int solve(int src, LinkedList<Integer> adjList[], int parent, List<Boolean> hasApple, int total){

        int ans = 0;

        for(int child : adjList[src]){
            if(child != parent){
                int temp = solve(child, adjList, src, hasApple,  1);

                if(temp !=0){
                    ans += temp;
                }
            }
        }

        if(ans ==0 && ! hasApple.get(src)){
            return 0;
        }

        return ans+ (src ==0 ? 0 : 1) + total;
    }
}