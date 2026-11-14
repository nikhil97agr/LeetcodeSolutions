package tag_validator_591;

import java.util.*;

class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int n = code.length();

        while( i < n){
            if(i > 0 && stack.isEmpty()) return false;

            if(code.startsWith("<![CDATA[", i)){
                int end = code.indexOf("]]>", i);
                if(end < 0) return false;
                i = end + 3;
                continue;
            }
            
            if(code.startsWith("</", i)){
                int end = code.indexOf(">", i);
                if(end < 0) return false;
                String tag = code.substring(i+2, end);
                if(tag.isEmpty() || tag.length() > 9) return false;
                if(stack.isEmpty() || !stack.peek().equals(tag)) return false;
                
                stack.pop();
                i= end + 1;
                continue;
            }
            
            if(code.startsWith("<", i)){
                int end = code.indexOf(">", i);
                if(end < 0) return false;
                String tag = code.substring(i + 1, end);
                for(char c : tag.toCharArray()){
                    if( c >= 'A' && c <= 'Z'){
                        continue;
                    }
                    return false;
                }
                stack.push(tag);
                i = end + 1;
                continue;
            }
            i++;
        }

        return stack.empty();
    }
}