import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int ans = 0;
        int n= tasks.length;
        int m = workers.length;

        Arrays.sort(tasks);
        Arrays.sort(workers);

        int low = 0;
        int high = Math.min(n, m);

        while(low <= high){
            int mid = (low+high)/2;

            if(check(mid, tasks, workers, pills, strength)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return ans;
    }

    private boolean check(int k, int tasks[], int workers[], int pills, int strength){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int m = workers.length;
        for(int i=m-k;i<m;i++){
            add(map, workers[i]);
        }

        for(int i=k-1;i>=0;i--){
            int t = tasks[i];
            int last = map.lastKey();
            
            if(tasks[i] <= last){
                remove(map, last);
            }else{
                if(pills==0) return false;
                Integer next = map.ceilingKey(tasks[i] - strength);
                
                if(next==null) return false;
                remove(map, next);
                pills--;
            }
        }

        return true;
    }
    
    private void add(Map<Integer, Integer> map, int val)
    {
        int cnt = map.getOrDefault(val, 0);
        map.put(val, cnt+1);
    }
    
    private void remove(Map<Integer, Integer> map , int val){
        int cnt = map.get(val);
        if(cnt == 1) map.remove(val);
        else map.put(val, cnt-1);
    }
}