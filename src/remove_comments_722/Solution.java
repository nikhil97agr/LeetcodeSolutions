package remove_comments_722;

import java.util.*;
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean block = false;
        StringBuilder sb = new StringBuilder();

        for(String s : source){
            int j= 0;
            char prev = ' ';
            int start =-1;
            int end = -1;
            while( j < s.length()){
                char curr = s.charAt(j);
                if(prev == '*' && curr == '/' && block && j-2 !=start){
                    block = false;
                    end = j;
                }else if(!block){
                    if(prev == '/' && curr == '/' && j-1 != end){
                        sb.setLength(Math.max(0, sb.length() - 1));
                        break;
                    }else if(prev == '/' && curr == '*' && j-1 != end){
                        sb.setLength(Math.max(0, sb.length() - 1));
                        block = true;
                        start = j- 1;
                    }else{
                        sb.append(curr);
                    }
                }
                prev = curr;
                j++;
            }

            if(!block && !sb.isEmpty()){
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}