class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n =nums.length;
        PriorityQueue<Long> que = new PriorityQueue<>(Collections.reverseOrder());
        long ans[] = new long[n];
        que.offer(0l);
        TreeMap<Integer, Pair> map = new TreeMap<>();

        for(int i=n-1;i>=0;i--){
            int ind = removeQueries[i];
            ans[i] = que.peek();
            int start = ind;
            int end = ind;
            long sum = nums[ind];
            Integer prev = map.lowerKey(ind);
            if(prev != null){
                Pair pair = map.get(prev);
                if(pair.end == ind - 1){
                    map.remove(prev);
                    start = prev;
                    sum += pair.sum;
                }
            }

            Integer next = map.higherKey(ind);
            if(next != null){
                if(next == ind + 1){
                    Pair pair = map.get(next);
                    map.remove(next);
                    end = pair.end;
                    sum += pair.sum;
                }
            }

            que.offer(sum);
            map.put(start, new Pair(end, sum));
        }


        return ans;
    }
    class Pair{
        int end;
        long sum;

        public Pair(int end, long sum){
            this.end = end;
            this.sum = sum;
        }
    }
}