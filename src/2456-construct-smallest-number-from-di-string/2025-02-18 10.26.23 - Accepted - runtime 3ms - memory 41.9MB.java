class Solution {
    public String smallestNumber(String pattern) {
        Deque<Character> que = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        for(char c='1';c<='9';c++){
            que.offerLast(c);
            set.add(c);
            String res = solve( 0, pattern, que, set);
            if(res.isEmpty()){
                set.remove(c);
                que.clear();
            }else{
                return res;
            }
        }

        return "";
    }

    private String solve(int i, String pattern, Deque<Character> que, Set<Character> set){
        if(i == pattern.length()){
            StringBuilder res = new StringBuilder();
            while(!que.isEmpty()){
                res.append(que.pollFirst());
            }
            return res.toString();
        }

        if(pattern.charAt(i) == 'I'){
            for(char c = (char)((int)que.getLast()+1);c<='9';c++){
                if(set.contains(c)) continue;
                que.offer(c);
                set.add(c);
                String res = solve(i+1, pattern, que, set);
                if(!res.isEmpty()) return res;
                que.pollLast();
                set.remove(c);

            }

        }else{
            for(char c = '1';c<que.getLast();c++){
                if(set.contains(c)) continue;
                que.offer(c);
                set.add(c);
                String res = solve(i+1, pattern, que, set);
                if(!res.isEmpty()) return res;
                set.remove(c);
                que.pollLast();
            }

        }

        return "";
    }
}