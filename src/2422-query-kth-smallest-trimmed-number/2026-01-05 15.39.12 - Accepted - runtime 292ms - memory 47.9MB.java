class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int q= queries.length;
        int ans[] = new int[q];
        for(int i=0;i<q;i++){
            ans[i] = process(nums, queries[i]);
        }
        return ans;


    }

    private int process(String arr[], int q[]){
        int k = q[0];
        int t = q[1];

        PriorityQueue<Pair> que =new PriorityQueue<>((a,b)->{
            if(a.s.equals(b.s)){
                return b.ind - a.ind;
            }

            return b.s.compareTo(a.s);
        });

        for(int i=0;i<arr.length;i++){
            int len = arr[i].length() - t;

            String sub = arr[i].substring(len);

            que.offer(new Pair(sub, i));
            if(que.size() > k) que.poll();
        }
        return que.peek().ind;
    }

    class Pair{
        String s;
        int ind;
        public Pair(String s, int ind){
            this.s = s;
            this.ind = ind;
        }
    }
}