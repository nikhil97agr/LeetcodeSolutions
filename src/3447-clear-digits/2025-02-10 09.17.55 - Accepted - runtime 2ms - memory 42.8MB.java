class Solution {
    public String clearDigits(String s) {
        Stack<Integer> stack = new Stack<>();
        char ch[] = s.toCharArray();
        
        for(int i=0;i<s.length();i++){
            if(ch[i]>='0' && ch[i] <='9'){
                ch[i] = ' ';
                if(!stack.isEmpty()){
                    ch[stack.pop()] = ' ';
                }
            }else{
                stack.push(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for(char c : ch){
            if(c!=' '){
                res.append(c);
            }
        }
        return res.toString();
    }
}