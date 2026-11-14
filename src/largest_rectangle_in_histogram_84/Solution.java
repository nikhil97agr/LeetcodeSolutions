package largest_rectangle_in_histogram_84;

import java.util.*;
class Solution {
    class Bar{
        int height;
        int index;
        public Bar(int height, int index){
            this.height = height;
            this.index = index;
        }

        public String toString(){
            return ""+height+":"+index;
        }
    }
    public int largestRectangleArea(int[] height) {
        int ans = 0;
        int n = height.length;
        Stack<Bar> stack = new Stack<>();
        stack.push(new Bar(-1, -1));

    for(int i=0;i<n;i++){
        if(stack.peek().height < height[i]){
            stack.push(new Bar(height[i], i));
            continue;
        }

        while(stack.peek().height > height[i]){
            Bar bar = stack.pop();
            int area = bar.height * (bar.index - stack.peek().index + (i - bar.index-1));
            ans = Math.max(ans, area);
        }
        stack.push(new Bar(height[i], i));
    }
    while(stack.peek().height != -1){
        Bar bar = stack.pop();
        int area = bar.height * (bar.index - stack.peek().index + (n- bar.index-1));
         ans = Math.max(ans, area);
    }
    return ans;
    }
}