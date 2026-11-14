package minimum_pair_removal_to_sort_array_ii_3772;

import java.util.*;
class Solution {
    class Node{
        long val;
        int ind;
        Node prev;
        Node next;
        boolean isRemove;

        public Node(long val, int ind){
            this.val = val;
            this.ind = ind;
            isRemove = false;
        }
    }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        if(n <= 1 ) return 0;

        Node node[] = new Node[n];
        node[0] = new Node(nums[0], 0);

        for(int i=1;i<n;i++){
            node[i] = new Node(nums[i], i);
            node[i].prev = node[i-1];
            node[i-1].next = node[i];
        }

        PriorityQueue<Pair> que= new PriorityQueue<>((a,b) ->{
            if(a.val == b.val) return a.ind - b.ind;

            return Long.compare(a.val, b.val);
        });
        int ans = 0;
        int count  = 0;

        for(int i=1;i<n;i++){
            que.offer(new Pair(nums[i] + nums[i-1], i-1));

            if(nums[i-1] > nums[i]) count++;
        }

        while(count > 0 && !que.isEmpty()){
            Pair pair = que.poll();
            long total = pair.val;
            int ind = pair.ind;

            Node nd = node[ind];

            if(nd.isRemove || nd.next ==null || nd.val + nd.next.val != total){
                continue;
            }

            Node next = nd.next;

            ans++;

            count = count - check(nd, next) - check(nd.prev, nd) - check(next, next.next);

            nd.val = total;
            nd.next = next.next;
            next.isRemove = true;

            if(next.next !=null){
                next.next.prev = nd;
            }
            count = count + check(nd.prev, nd) + check(nd, nd.next);
            if(nd.prev !=null){
                que.offer(new Pair(nd.prev.val + nd.val, nd.prev.ind));
            }

            if(nd.next !=null){
                que.offer(new Pair(nd.val + nd.next.val, nd.ind));
            }

        }

        return ans;

    }

    private int check(Node left, Node right){
        if(left ==null || right == null) return 0;

        if(left.val > right.val) return 1;
        return 0;
    }

    class Pair{
        long val;
        int ind;
        public Pair(long val, int ind){
            this.val =val;
            this.ind = ind;
        }
    }
}