import java.util.*;

class Solution {
    public static void main(String[] args) {
        new Solution().permuteUnique(new int[]{1,1,2});
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Queue<Pair> que =new LinkedList<>();

        int cnt[] = new int[21];
        for(int x : nums){
            cnt[10 + x]++;
        }
        for(int i=0;i<=20;i++){
            if(cnt[i] !=0){
                que.offer( new Pair(new ArrayList<>(), cnt, i-10));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        while(!que.isEmpty()){
            Pair pair = que.poll();
            List<Integer> list = pair.list;
            cnt = pair.cnt;
            if(list.size() == n){
                res.add(list);
                continue;
            }

            for(int i=0;i<=20;i++){
                if(cnt[i]!=0){
                    que.offer(new Pair(list, cnt, i-10));
                }
            }
        }

        return res;
    }

    class Pair{
        List<Integer> list;
        int cnt[];

        public Pair(List<Integer>list, int cnt[], int val){
            this.list = new ArrayList<>(list);
            this.cnt = cnt.clone();
            this.list.add(val);
            this.cnt[val + 10]--;
        }
    }
}