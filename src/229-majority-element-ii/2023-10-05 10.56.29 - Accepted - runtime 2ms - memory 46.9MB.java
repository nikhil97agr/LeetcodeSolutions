class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;

        for(int x : nums){
            if(x==e1) cnt1++;
            else if(x==e2) cnt2++;
            else if(cnt1==0){
                e1 = x;
                cnt1++;
            }else if(cnt2==0){
                e2 = x;
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int x : nums){
            if(x==e1){
                cnt1++;
            }else if(x==e2) cnt2++;
        }

        if(cnt1 > n/3){
            result.add(e1);
        }
        if(cnt2 > n/3){
            result.add(e2);
        }
        return result;
    }

}