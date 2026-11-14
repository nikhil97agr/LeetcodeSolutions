package maximum_average_pass_ratio_1917;

import java.util.*;
class Solution {
    public double maxAverageRatio(int[][] classes, int x) {
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b)->{
            double diff1 = (1d*(a.a+1)/(1d*(a.b+1))) - a.value;
            double diff2 = (1d*(b.a+1)/(1d*(b.b+1))) - b.value;

            return -Double.compare(diff1, diff2);

        });

        int n = classes.length;
        for(int c[] : classes){
            que.offer(new Pair(c[0], c[1]));
        }

        while(x > 0){
            Pair pair = que.poll();
            pair.a++;
            pair.b++;

            pair.calcValue();
            que.offer(pair);
            x--;
        }

        double res = 0;
        while(!que.isEmpty()){
            res += que.poll().value;
        }

        return res/classes.length;

    }

    class Pair{
        int a;
        int b;
        double value;
        Pair(int a, int b){
            this.a = a;
            this.b = b;

            calcValue();
        }

        public void calcValue(){
            this.value = (1d*a)/(1d*b);
        }

        public String toString(){
            return ""+a+":"+b+":"+value;
        }
    }
}