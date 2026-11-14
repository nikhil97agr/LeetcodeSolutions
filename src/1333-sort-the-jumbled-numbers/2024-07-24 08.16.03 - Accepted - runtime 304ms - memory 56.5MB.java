class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n= nums.length;
        for(int x : nums){
            int temp = x;
            Stack<Integer> stack= new Stack<>();
            if(temp ==0){
                temp = mapping[0];
                map.computeIfAbsent(temp, t-> new ArrayList<>()).add(x);
                continue;
            }
            while(temp > 0){
               int dig = temp%10;
               stack.push(mapping[dig]);
               temp/=10; 
            }
            while(!stack.isEmpty()){
                temp=temp*10 + stack.pop();
            }
            map.computeIfAbsent(temp, t-> new ArrayList<>()).add(x);
        }

        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2)-> e1.getKey() - e2.getKey());

        int ans[] =new int[n];
        
        int i=0;
        for(Map.Entry<Integer, List<Integer>>entry : list){
            for(int x : entry.getValue()){
                ans[i++] = x;
            }
        }
        return ans;
    }
}