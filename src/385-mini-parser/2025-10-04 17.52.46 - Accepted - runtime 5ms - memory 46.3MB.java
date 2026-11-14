/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
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