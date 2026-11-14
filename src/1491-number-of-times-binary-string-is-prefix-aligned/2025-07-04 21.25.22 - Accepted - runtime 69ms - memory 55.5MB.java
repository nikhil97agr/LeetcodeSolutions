class Solution {
    public int numTimesAllBlue(int[] flips) {
        TreeSet<Integer> set = new TreeSet<>();
        int ans = 0;
        for(int x : flips){
            set.add(x);
            int first = set.first();
            int last = set.last();
            if(first == 1 && last == set.size()) ans++;
        }

        return ans;
    }
}