import java.util.LinkedList;

class Solution {
    public int countHighestScoreNodes(int[] parents) {
        int cnt[] = new int[parents.length];
        int n = parents.length;
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int j=1;j<n;j++){
            adjList[parents[j]].add(j);
        }
        generateCnt(adjList, 0, -1, cnt);
        Map<Long, Integer> map = new HashMap<>();

        long ans = dfs(adjList, 0, -1, cnt, 0, map);
        System.out.println(map);
        return map.get(ans);
    }
    
    private long dfs(LinkedList<Integer> adjList[], int curr, int par, int cnt[], int prevCnt, Map<Long, Integer> map){
        long ans = prevCnt ==0 ? 1 : prevCnt;
        long res = 0;
        
        for(int child : adjList[curr]){
            if(child == par) continue;
            
            int total = cnt[curr] - cnt[child];
            ans *= cnt[child];
            long temp = dfs(adjList, child, curr, cnt, prevCnt + total, map);
            res = Math.max(res, temp);
        }
        map.merge(ans, 1,Integer::sum);
        return Math.max(res, ans);
    }

    private int generateCnt(LinkedList<Integer> adjList[], int curr, int par, int cnt[]){
        int total = 1;

        for(int child :adjList[curr]){
            if(child == par) continue;

            total += generateCnt(adjList, child, curr, cnt);
        }
        cnt[curr] = total;

        return total;
    }
}