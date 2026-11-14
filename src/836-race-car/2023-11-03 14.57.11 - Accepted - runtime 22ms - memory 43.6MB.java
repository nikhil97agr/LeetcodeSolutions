class Solution {
    class Pair{
        int pos;
        int speed;

        public Pair(int pos, int speed){
            this.pos = pos;
            this.speed = speed;
        }

        public boolean equals(Object obj){
            Pair p = (Pair)obj;

            return p.pos == pos && p.speed == speed;
        }

        public int hashCode(){
            return (""+pos+":"+speed).hashCode();
        }
    }
    public int racecar(int target) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 1, 0});
        Set<Pair> visited = new HashSet<>();
        while(!que.isEmpty()){
            int []p = que.poll();

            if(p[0]==target) return p[2];
            Pair pair = new Pair(p[0], p[1]);
            if(visited.contains(pair)){
                continue;
            }
            visited.add(pair);
            int curr = p[0];
            int speed = p[1];
            int move = p[2];
            que.add(new int[]{curr + speed, speed*2, move+1});
            if((curr+speed > target && speed>0 ) || (curr +speed< target && speed<0)){
                speed = speed>0 ? -1 : 1;
                que.add(new int[]{curr, speed, move+1});
            }


        }
        return -1;
    }
}