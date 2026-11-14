package perfect_number_507;

class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        if(num==1) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                sum += num/i;
                sum += i;
            }
            if(sum > num) return false;
        }

        return sum == num;
    }
}