package check_if_all_the_integers_in_a_range_are_covered_2005;

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int cnt[] = new int[52];

        for(int r[]: ranges){
            for(int i=r[0];i<=r[1];i++) cnt[i]++;
        }

        int c=0;
        for(int i=left;i<=right;i++){
            if(cnt[i] ==0) return false;
        }

        return true;
    }
}