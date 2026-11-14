package minimum_reverse_operations_2726;

import java.util.*;
class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        int cnt = 0;
        TreeSet<Integer> e = new TreeSet<>();
        TreeSet<Integer> o = new TreeSet<>();
        boolean vis[] = new boolean[n];
        for(int x : banned){
            vis[x] =true;

        }
        vis[p] = true;
        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            if(i%2==0) e.add(i);
            else o.add(i);
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(p);

        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int next = que.poll();
                int min = -1;
                int max = -1;
                ans[next] = cnt;
                if(next < k-1){
                    min = k-1 - next;
                }else{
                    min = next -k + 1;
                }

                if(n-1-next < k-1){
                    max = k-1-(n-1-next);
                }else{
                    max = n-1-next - k + 1;
                }

                max = (n-1) - max;

                TreeSet<Integer> set = min%2==0 ? e : o;
                Integer ind = set.ceiling(min);

                while(ind !=null && ind <= max){
                    set.remove(ind);
                    que.offer(ind);
                    ind = set.ceiling(ind);
                }
            }
            cnt++;
        }



        return ans;
    }
}