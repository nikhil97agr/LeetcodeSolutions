class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        Pair pair[] = new Pair[n];
        for(int i=0;i<n;i++){
            pair[i] = new Pair(Math.abs(points[i][0]),Math.abs(points[i][1]), s.charAt(i));
        }
        
        Arrays.sort(pair, (p1, p2)->{
            return p1.dist - p2.dist;
        });
        Set<Character> set = new HashSet<>();
        long currDist=0;
        int i=0;
        while(i < n){
            Set<Character> temp = new HashSet<>();
            currDist = pair[i].dist;
            while(i < n && 1L*pair[i].dist <= currDist){
                if(!set.contains(pair[i].c) && !temp.contains(pair[i].c)){
                    temp.add(pair[i].c);
                }else{
                    return set.size();
                }
                i++;
                
            }
            
            set.addAll(temp);
        }
        return set.size();
        
    }
    
    class Pair{
        int x;
        int y;
        char c;
        int dist;
        public Pair(int x, int y, char c)
        {
            this.x = x;
            this.y = y;
            this.c = c;
            dist = Math.max(x, y);
        }
    }
}