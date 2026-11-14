class Solution {
    class Monster{
        double time;
        int ind;
        public Monster(double time, int ind){
            this.time = time;
            this.ind = ind;
        }
    }
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Monster> que = new PriorityQueue<>((a,b)->Double.compare(a.time, b.time));

        for(int i=0;i<dist.length;i++){
            que.add(new Monster((1d*dist[i])/(1d*speed[i]), i));
        }

        double next = 0;
        int count = 0;
        while(!que.isEmpty()){
            if(next < que.peek().time){
                que.poll();
                next++;
                count++;
            }else{
                return count;
            }
        }

        return dist.length;

    }
}