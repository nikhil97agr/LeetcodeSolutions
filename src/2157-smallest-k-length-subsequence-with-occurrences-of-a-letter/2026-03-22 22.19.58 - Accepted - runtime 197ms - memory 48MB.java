class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int cnt =0;
        for(char c : s.toCharArray()){
            if(c == letter) cnt++;
        }
        int added = 0;
        int n = s.length();
        var stack = new Stack<Character>();
        
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            while(!stack.isEmpty() && stack.peek() > c ){
                int l1 = stack.size();
                int left = n - i;
                if(l1 -1 + left < k) break;

                char peek = stack.peek();
                if(peek == letter){
                    if(added -1 + cnt < repetition) break;
                    added--;
                }
                stack.pop();
            }
            if(stack.size() < k){
                if( c == letter){
                    added++;
                    stack.push(c);
                }else{
                    int req = repetition - added;
                    int size = stack.size();
                    int additionalChars = k - size;
                    if( additionalChars > req){
                        stack.push(c);
                    }
                }
            }

            if( c == letter){
                cnt--;
            }
        }


        StringBuilder res = new StringBuilder();
        for(char c : stack){
            res.append(c);
        }

        return res.toString();

    }
}