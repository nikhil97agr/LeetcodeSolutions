class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        List<Integer> list = new ArrayList<>();
        int curr = 0;
        int n = position.length;

        for(int i=1;i<n;i++){
            if(position[i] - position[curr] <= distance){
                curr = i;
            }else{
                list.add(curr);
                curr = i;
                
            }
        }

        list.add(curr);
        Stack<Integer> stack = new Stack<>();
        for(int i : list){


            while(!stack.isEmpty() && (speed[i] < speed[stack.peek()] || position[i] - position[stack.peek()] <= distance)){
                stack.pop();
            }
            stack.push(i);
        }

        return stack.size();
    }
}