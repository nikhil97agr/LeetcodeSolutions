class Solution {
    class Point{
        int start;
        int end;
        public Point(int s, int e){
            this.start = s;
            this.end = e;
        }

        public int hashCode(){
            return (""+start+":"+end).hashCode();
        }

        public boolean equals(Object obj){
            Point p = (Point)obj;

            return p.start==start && p.end == end;
        }
    }
    public int visibleMountains(int[][] peaks) {
        Stack<Point> stack = new Stack<>();
        int n = peaks.length;
        int i = 0;
        Point point[] = new Point[n];
        Map<Point, Integer> map = new HashMap<>();
        for(int p[] : peaks){
            int start =p[0] - p[1];
            int end = p[0] + p[1];

            point[i] = new Point(start, end);

            map.put(point[i], map.getOrDefault(point[i], 0)+1);
            i++;
        }
        Arrays.sort(point, (a,b) ->{
            if(a.start==b.start) return a.end - b.end;
            return a.start - b.start;
        });

        stack.push(point[0]);
        i=1;
        while(i<n){
            boolean inserted = true;
            if(stack.isEmpty()){
                stack.push(point[i]);
                i++;
                continue;
            }

            Point p = point[i++];

            while(!stack.isEmpty()){
                if(inside(stack.peek(), p)){
                    stack.pop();
               }else if(inside(p, stack.peek())){
                   inserted = false;
                   break;
               }else{
                   break;
               }
            }

            if(inserted){
                
                stack.push(p);
            }


        }
        int ans = stack.size();
        while(!stack.isEmpty()){
            if(map.get(stack.pop())>1) ans--;
        }
        return ans;
    }

    private boolean inside(Point child, Point parent){
        if(child.start == parent.start && child.end==parent.end) return true;
        if(child.start==parent.start) return child.end < parent.end;

        if(child.end==parent.end) return child.start > parent.start;
       return child.start > parent.start && child.end < parent.end;
    }

}