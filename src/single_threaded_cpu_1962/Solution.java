package single_threaded_cpu_1962;

import java.util.*;
class Solution {
    class Task{
        int enque;
        int process;
        int index;

        public Task(int enque, int process, int index){
            this.enque = enque;
            this.process = process;
            this.index = index;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int ans[] = new int[n];
        Comparator<Task> comparator = (a,b)->{
            if(a.enque == b.enque){
                if(a.process == b.process) return a.index - b.index;
                return a.process - b.process;
            }

            return a.enque - b.enque;
        };
        PriorityQueue<Task> que = new PriorityQueue<>(comparator);
        for(int i=0;i<n;i++){
            que.offer(new Task(tasks[i][0], tasks[i][1], i));
        }
        int ind = 0;

        int nextProcessTime = 0;
        PriorityQueue<Task> que2 = new PriorityQueue<>(comparator);
        while(!que.isEmpty()){
            while(!que.isEmpty() && que.peek().enque <= nextProcessTime){
                Task task = que.poll();
                task.enque = 0;
                que2.offer(task);
            }

            if(!que2.isEmpty()){
                Task task = que2.poll();
                ans[ind++] = task.index;
                nextProcessTime += task.process;
            }else{
                Task task = que.poll();
                ans[ind++] = task.index;
                nextProcessTime = task.enque + task.process;
            }



        }
        while(!que2.isEmpty()){
            ans[ind++] = que2.poll().index;
        }
        return ans;

    }
}