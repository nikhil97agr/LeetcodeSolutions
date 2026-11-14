class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0), list.get(1));
        }

        Queue<Character> que = new LinkedList<>();
        for(char c : s.toCharArray()){
            que.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            char c = que.poll();
            if(c == '('){
                sb.append(parse(que, map));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String parse(Queue<Character> que, Map<String, String> map){
        StringBuilder sb = new StringBuilder();
        while(que.peek() != ')'){
            sb.append(que.poll());
        }
        que.poll();
        return map.getOrDefault(sb.toString(), "?");
    }
}