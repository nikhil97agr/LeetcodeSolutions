class Solution {
    public boolean isDecomposable(String s) {
        Stack<String> stack =new Stack<>();
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        for(char c : s.toCharArray()){
            if(prev == c){
                sb.append(c);
            }else{
                stack.push(sb.toString());
                prev = c;
                sb = new StringBuilder();
                sb.append(c);
            }
        }

        stack.push(sb.toString());

        boolean found = false;
        while(!stack.isEmpty()){
            String next = stack.pop();
            int len = next.length();
            if(len%3==0) continue;

            if(len % 3 ==2){
                if(found) return false;
                found = true;
                continue;
            }
            
            return false;

        }

        return found;
    }
}