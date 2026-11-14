class Solution {
    public int binaryGap(int n) {
        List<Integer> list = new ArrayList<>();
        int ind = 0;
        while(n > 0){
            int dig = n%2;
            if(dig==1){
                list.add(ind);
            }

            n/=2;
            ind++;
        }

        int ans = 0;
        for(int i=1;i<list.size();i++){
            ans = Math.max(list.get(i) - list.get(i-1), ans);
        }
        return ans;
    }
}