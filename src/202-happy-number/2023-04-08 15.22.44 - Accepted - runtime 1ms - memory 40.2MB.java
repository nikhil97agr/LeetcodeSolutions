class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        set.add(n);
        while(true){
            while(n>0){
                int digit = n%10;
                sum += digit*digit;
                n/=10;
            }

            if(set.contains(sum)){
                break;
            }
            if(sum==1){
                break;
            }
            set.add(sum);
            n = sum;
            sum = 0;
        }

        return sum==1;
    }
}