package simplify_path_71;

import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        String paths[] = path.split("/");
        StringBuilder result = new StringBuilder("");
        Stack<String> stack = new Stack<>();
        for(String p : paths){
            if(stack.isEmpty()){
                if(!p.equals("")&&!p.equals(".")&&!p.equals("..")){
                    stack.push(p);
                }
            }else{
                if(p.equals("..")){
                    stack.pop();
                }else if(!p.equals("")&&!p.equals(".")){
                    stack.push(p);
                }
            }
        }
        if(stack.isEmpty()){
            return "/";
        }

        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
            result.insert(0,"/");
        }
        return String.valueOf(result);
    }
}