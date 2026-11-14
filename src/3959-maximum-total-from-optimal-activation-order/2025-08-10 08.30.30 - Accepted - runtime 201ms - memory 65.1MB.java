class Solution {
    public long maxTotal(int[] value, int[] limit) {
        long ans = 0;
        PriorityQueue<Element> que = new PriorityQueue<>((e1,e2) ->{
            if(e1.limit == e2.limit){
               return e2.value - e1.value;
            }

            return e1.limit - e2.limit;
        });
        for(int i=0;i<value.length;i++){
            que.offer(new Element(limit[i], value[i]));
        }
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        while(!que.isEmpty()){
            Element element = que.poll();
            if(cnt < element.limit){
                ans += element.value;
                cnt++;
                q.offer(element.limit);
                while(!que.isEmpty() && que.peek().limit <= cnt){
                    que.poll();
                }
            }
            int c = cnt;
            while(!q.isEmpty() && q.peek() <= cnt){
                c--;
                q.poll();
            }
            cnt = c;
            
        }

        return ans;
    }

    class Element{
        int limit;
        int value;

        public Element(int limit, int value){
            this.limit= limit;
            this.value = value;
        }
    }
}