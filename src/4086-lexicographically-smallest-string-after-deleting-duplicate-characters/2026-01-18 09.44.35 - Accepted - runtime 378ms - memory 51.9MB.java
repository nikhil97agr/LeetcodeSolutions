class Solution {
    public String lexSmallestAfterDeletion(String s) {
        char ch[] = s.toCharArray();
        int cnt[] = new int[26];
        int insert[] = new int[26];
        Stack<Character> stack = new Stack<>();
        for(char c : ch){
            cnt[c-'a']++;
        }

        for(char c : ch){
            cnt[c-'a']--;
            while(!stack.isEmpty()){
                char peek = stack.peek();
                if(peek > c && (cnt[peek-'a']> 0 || insert[peek-'a'] > 1)){
                    stack.pop();
                    insert[peek-'a']--;
                }else{
                    break;
                }
            }

            stack.push(c);
            insert[c-'a']++;
        }

        while(!stack.isEmpty()){
            char peek = stack.peek();
            if(insert[peek-'a'] > 1){
                insert[peek-'a']--;
                stack.pop();
            }else{
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) res.append(stack.pop());
        return res.reverse().toString();
    }
}