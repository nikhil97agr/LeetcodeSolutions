class Solution {
    public String makeLargestSpecial(String s) {
        Queue<Character> que = new LinkedList<>();

        for(char c : s.toCharArray()){
            que.offer(c);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(!que.isEmpty()){
            pq.offer(solve(que));
        }

        StringBuilder res = new StringBuilder();

        while(!pq.isEmpty()){
            res.append(pq.poll());
        }

        return res.toString();
    }

    private String solve(Queue<Character> que){
        char next = que.poll();
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(que.peek() != '0'){
            String s = solve(que);
            pq.offer(s);
        }
        StringBuilder res = new StringBuilder();
        res.append(next);
        while(!pq.isEmpty()){
            res.append(pq.poll());
        }

        res.append(que.poll());

        return res.toString();
    }
}