package time_to_cross_a_bridge_2642;

import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {

        Comparator<Worker> c1 = (a,b) ->{
            if(a.time == b.time){
                if(a.left + a.right == b.left + b.right){
                    return b.ind - a.ind;
                }

                return b.left + b.right - a.left - a.right;
            }

            return a.time - b.time;
        };

        Comparator<Worker> c2 = (a,b)->{
            int s1 = a.left + a.right;
            int s2 = b.left + b.right;

            if(s1 == s2) return b.ind - a.ind;
            return s2 - s1;
        };
        PriorityQueue<Worker> left = new PriorityQueue<>(c2);
        PriorityQueue<Worker> right =new PriorityQueue<>(c2);

        PriorityQueue<Worker> leftAvailable = new PriorityQueue<>(c1);
        PriorityQueue<Worker> rightAvailable = new PriorityQueue<>(c1);

        for(int i=0;i<k;i++){
            left.offer(new Worker(time[i][0], time[i][1], time[i][2], time[i][3], i, 0));
        }

        int currTime = 0;
        int ans = 0;
        while(n > 0 || !right.isEmpty() || !rightAvailable.isEmpty()){
            while(!leftAvailable.isEmpty() && leftAvailable.peek().time <= currTime) {
                left.offer(leftAvailable.poll());
            }
            while(!rightAvailable.isEmpty() && rightAvailable.peek().time <= currTime) {
                right.offer(rightAvailable.poll());
            }

            if(right.isEmpty() && (left.isEmpty() || n==0)){
                int next= Integer.MAX_VALUE;
                if(!leftAvailable.isEmpty()) next = Math.min(next, leftAvailable.peek().time);
                if(!rightAvailable.isEmpty()) next = Math.min(next, rightAvailable.peek().time);
                currTime= next;
                continue;
            }

            if(!right.isEmpty()){
                Worker worker = right.poll();
                currTime += worker.left;
                ans = currTime;
                worker.time = currTime + worker.put;
                leftAvailable.offer(worker);
                continue;
            }

            if(n > 0 && !left.isEmpty()){
                Worker worker = left.poll();
                currTime += worker.right;
                worker.time = currTime + worker.pick;
                rightAvailable.offer(worker);
                n--;
            }
        }

        return ans ;

    }
    class Worker{
        int right;
        int left;
        int pick;
        int put;
        int ind;
        int time;

        public Worker(int right, int pick, int left, int put, int ind, int time) {

            this.right = right;
            this.left = left;
            this.pick = pick;
            this.put = put;
            this.ind = ind;
            this.time = time;
        }
    }
}