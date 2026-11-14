import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        generate(res,target, num, 0, num.length(), new StringBuilder());

        return res;
    }

    private long getSum(String s){
        Stack<Long> stack = new Stack<>();

        long num =0;
        char op = '+';

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }else{
                if(op == '+'){
                    stack.push(num);
                }else if(op =='-'){
                    stack.push(-num);
                }else {
                    stack.push(stack.pop()*num);
                }

                op = c;
                num = 0;
            }
        }

        if(op == '+') stack.push(num);
        else if(op == '-') stack.push(-num);
        else stack.push(stack.pop()*num);

        return stack.stream().reduce(0l, Long::sum);
    }

    private void generate(List<String> list, int target, String num, int i, int n, StringBuilder sb){
        if(i==n-1){
            sb.append(num.charAt(i));
            long sum = getSum(sb.toString());
            if(sum ==1l*target){
                list.add(sb.toString());
            }
            sb.deleteCharAt(sb.length()-1);
            return;
        }




        sb.append(num.charAt(i));
        int len = sb.length();
        if(sb.charAt(len-1) !='0' || (i !=0 && Character.isDigit(sb.charAt(len-2)))){
            generate(list, target, num, i+1, n, sb);

        }

        sb.append('*');
        generate(list, target,num, i+1, n, sb);
        sb.setCharAt(len, '+');
        generate(list, target,num, i+1, n, sb);
        sb.setCharAt(len, '-');
        generate(list, target,num, i+1, n, sb);
        sb.deleteCharAt(len);
        sb.deleteCharAt(len-1);
    }
}