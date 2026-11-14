package nested_list_weight_sum_339;

import java.util.*;
// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {
    // Constructor initializes an empty nested list:  NestedInteger()
    // Constructor initializes a single integer:       NestedInteger(int value)

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // The result is undefined if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // The result is undefined if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int ans = 0;
        for(NestedInteger integer: nestedList){
            if(integer.isInteger()){
                ans += integer.getInteger();
            }else{
                ans += solve(integer, 2);
            }
        }

        return ans;
    }

    private int solve(NestedInteger integer, int depth){

        int ans = 0;

        for(NestedInteger ni : integer.getList()){
            if(ni.isInteger()){
                ans += depth * ni.getInteger();
            }else{
                ans += solve(ni, depth + 1);
            }
        }

        return ans;
    }
}