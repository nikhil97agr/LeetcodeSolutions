package mini_parser_385;

import java.util.*;
// This is the interface that allows for creating nested lists.
// On LeetCode this type is supplied by the judge; the minimal stand-in below keeps
// this file self-contained, since the solution builds NestedInteger values itself.
class NestedInteger {
    private Integer value;
    private final List<NestedInteger> list = new ArrayList<>();

    // Constructor initializes an empty nested list.
    public NestedInteger() {}

    // Constructor initializes a single integer.
    public NestedInteger(int value) { this.value = value; }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() { return value != null; }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() { return value; }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) { this.value = value; }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) { value = null; list.add(ni); }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() { return list; }
}
class Solution {
    public NestedInteger deserialize(String s) {
        Queue<Character> que = new LinkedList<>();

        for(char c : s.toCharArray()) que.offer(c);
        
        return solve(que);
    }

    private NestedInteger solve(Queue<Character> que){
        NestedInteger ni = null;
        if(que.peek() == '['){
            que.poll();
            ni = new NestedInteger();

            while(!que.isEmpty()){
                if(que.peek() == ']'){
                    que.poll();
                    break;
                }
                if(que.peek() == ','){
                    que.poll();
                    
                }

                ni.add(solve(que));
            }
        }else{
            int num = 0;
            boolean neg =false;
            if(que.peek() == '-'){
                neg = true;
                que.poll();
            }
            while(!que.isEmpty() && Character.isDigit(que.peek())){
                int dig = que.poll() - '0';
                num = num * 10 + dig;
            }
            if(neg){
                num = -num;
            }
             ni = new NestedInteger(num);
        }

        return ni;
    }
}