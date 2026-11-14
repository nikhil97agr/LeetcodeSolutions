class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        int n = words.size();
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(String s : words){
            if(s.equals("prev")){
                cnt++;
                Stack<Integer> temp = new Stack<>();
                int c = cnt;
                while(!stack.isEmpty() && c>0){
                    c--;
                    temp.push(stack.pop());
                }
                if(c==0){
                    result.add(temp.peek());
                }else{
                    result.add(-1);
                }
                while(!temp.isEmpty()){
                    stack.push(temp.pop());
                }
            }else{
                cnt = 0;
                stack.push(Integer.valueOf(s));
            }
        }
        
        return result;
    }
}