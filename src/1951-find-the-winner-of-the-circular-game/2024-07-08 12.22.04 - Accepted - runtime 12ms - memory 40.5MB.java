class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list= new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int i=0;
        while(list.size() > 1){
            int rem = k;
            n = list.size();

            while(rem-- > 1){
                i++;
                i%=n;
            }
            list.remove(i);
        }

        return list.get(0);
    }
}