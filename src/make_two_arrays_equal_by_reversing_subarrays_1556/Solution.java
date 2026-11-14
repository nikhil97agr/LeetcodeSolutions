package make_two_arrays_equal_by_reversing_subarrays_1556;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int cnt[] = new int[1001];

        for(int x : target) cnt[x]++;
        for(int x : arr) cnt[x]--;

        for(int y : cnt){
            if(y!=0) return false;
        }
        return true;
    }
}