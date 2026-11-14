class Solution {
    public String rearrangeString(String s, int k) {
        int cnt[] = new int[26];
        for(char c : s.toCharArray()) cnt[c-'a'] ++;
        if(k==0){
            return s;
        }
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b) -> {
            if(a.cnt == b.cnt){
                return a.c - b.c;
            }
            return b.cnt - a.cnt; 
        });
        for(char c = 'a';c<='z';c++){
            int id = c- 'a';
            if(cnt[id] !=0){
                que.offer(new Pair(c, cnt[id]));
            }
        }
        Queue<Pair> q= new LinkedList<>();
        StringBuilder res= new StringBuilder();
        while(res.length() !=s.length()){
            if(q.size() == k){
                while(!q.isEmpty()){
                    Pair next = q.poll();
                    if(next.cnt == 1) continue;
                    next.cnt--;
                    que.offer(next);
                }
                
            }else if(que.isEmpty()){
                return "";
            }

            Pair next = que.poll();
            res.append(next.c);
            q.offer(next);
        }

        return res.toString();
    }

    class Pair{
        char c;
        int cnt;

        public Pair(char c, int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }
}