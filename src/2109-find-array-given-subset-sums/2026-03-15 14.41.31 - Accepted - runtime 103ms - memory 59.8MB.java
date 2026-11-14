class Solution {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        List<Integer> result = new ArrayList<>();
        int ind = 0;
        List<Integer> list = new ArrayList<>();
        for(int x : sums){
            list.add(x);
        }
        while(list.size() > 1){
            var left = new ArrayList<Integer>();
            var right = new ArrayList<Integer>();

            int num = list.get(1) - list.get(0);
            boolean leftZero = false;
            for(int i=0,j=0;i<list.size();i++){
                if(list.get(i) != Integer.MIN_VALUE){
                    leftZero |= (list.get(i) == 0);
                    left.add(list.get(i));
                    right.add(list.get(i) + num);
                    for(j=Math.max(i+1, j+1); j < list.size() && list.get(j) != list.get(i) + num;j++);
                        list.set(j, Integer.MIN_VALUE);
                    
                }
            }
            result.add(num * (leftZero ? 1 : -1));
            if(leftZero){
                list= left;
            }else{
                list = right;
            }
        }

        int ans[] = new int[result.size()];
        for(int x : result){
            ans[ind++] =x;
        }
        return ans;
    }
}