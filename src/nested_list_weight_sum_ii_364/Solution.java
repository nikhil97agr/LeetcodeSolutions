package nested_list_weight_sum_ii_364;

import java.util.*;
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list:  NestedInteger()
    // Constructor initializes a single integer:       NestedInteger(int value)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Map<Integer, List<Integer>> map =new HashMap<>();
        int ans = 0;
        int d = 1;
        Queue<NestedInteger> que = new LinkedList<>();
        for(NestedInteger ni : nestedList)
            que.offer(ni);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                NestedInteger integer = que.poll();
                if(integer.isInteger()){
                    list.add(integer.getInteger());
                }else{
                    for(NestedInteger ni : integer.getList()){
                        que.offer(ni);
                    }
                }
            }
            map.put(d, list);
            d++;
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            for(int i : entry.getValue()){
                ans += (i * (d -entry.getKey()));
            }
        }

        return ans;
    }
}