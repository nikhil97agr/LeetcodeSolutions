class Solution {
    public int[] findPermutation(String s) {
        int n = s.length() + 1;
        int res[] = new int[n];

        int next = 1;

        List<Stack<Integer>> list =new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == 'D'){
                stack.push(next++);
            }else{
                stack.push(next++);
                list.add(stack);
                stack = new Stack<>();
            }
        }

        stack.push(next);
        list.add(stack);

        int i=0;
        for(Stack<Integer> st : list){
            while(!st.isEmpty()){
                res[i] = st.pop();
                i++;
            }
        }

        return res;
    }


}