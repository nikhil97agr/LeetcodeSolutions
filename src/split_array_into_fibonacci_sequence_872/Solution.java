package split_array_into_fibonacci_sequence_872;

import java.util.*;
class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        Stack<Integer> stack = new Stack<>();
        int n = num.length();
        for(int i=0;i<n;i++){
            String s1 = num.substring(0, i+1);
            if(outOfRange(s1)) break;
            if(!valid(s1) )continue;
            for(int j=i+1;j<n;j++){
                String s2 = num.substring(i+1, j+1);
                if(outOfRange(s2)) break;
                if(!valid(s2)) continue;

                if(check(s1, s2, stack, num, j+1)) return new ArrayList<>(stack);
            }
        }

        return new ArrayList<>();
    }

    private boolean check(String s1, String s2, Stack<Integer> stack, String num, int i){
        if(i == num.length()){
            if(stack.size() + 2 >= 3){
                stack.push(Integer.parseInt(s1));
                stack.push(Integer.parseInt(s2));
                return true;
            }

            return false;

        }

        for(int j=i;j<num.length();j++){
            String sub = num.substring(i, j+1);
            if(valid(sub) && check(s1, s2, sub)){
                stack.push(Integer.parseInt(s1));
                if(check(s2, sub, stack, num, j+1)) return true;
                stack.pop();
            }
            if(outOfRange(sub)){
                break;
            }
        }

        return false;
    }

    private boolean check(String s1, String s2, String s3){
        return Integer.parseInt(s1) + Integer.parseInt(s2) == Integer.parseInt(s3);
    }

    private boolean outOfRange(String s){
        long val = Long.parseLong(s);
        return val >= (1l<<31);
    }


    private boolean valid(String s){
        if(s.startsWith("0") && s.length() ==1) return true;

        if(s.startsWith("0")) return false;

        Long val = Long.parseLong(s);
        if(val >= (1l << 31)) return false;
        return true;
    }
}