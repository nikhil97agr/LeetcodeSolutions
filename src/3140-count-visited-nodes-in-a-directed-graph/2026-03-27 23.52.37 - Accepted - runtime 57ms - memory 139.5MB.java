import java.util.LinkedList;
import java.util.List;

class Solution {

    List<Integer> edges;
    int ans[];
    int n;

    public int[] countVisitedNodes(List<Integer> edges) {

        this.edges = edges;
        n = edges.size();
        ans = new int[n];

        var indegree = new int[n];
        for (int i = 0; i < n; i++) {
            indegree[edges.get(i)]++;
        }

        var que = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }
        
        while(!que.isEmpty()){
            int next = edges.get(que.poll());
            indegree[next]--;
            
            if(indegree[next] ==0) {
                que.offer(next);
            }
        }
        
        for(int i=0;i<n;i++){
            if(indegree[i] > 0 && ans[i] == 0){
                int size = 0;
                int curr = i;
                do{
                    curr = edges.get(curr);
                    size++;
                }while(curr != i);
                
                do{
                    ans[curr] = size;
                    curr = edges.get(curr);
                    
                }while(curr != i);
            }
        }
        
        for(int i=0;i<n;i++){
            if(ans[i] == 0){
                dfs(i);
            }
        }
        
        return ans;
    }
    
    private int dfs(int curr){
        if(ans[curr] !=0) return ans[curr];
        return ans[curr] = 1 + dfs(edges.get(curr));
    }
}