package rotated_digits_804;

class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(valid(i)) ans++;
        }

        return ans;
    }

    private boolean valid(int n){
        boolean found = false;
        while(n > 0){
            int dig = n%10;

            if(dig == 3 || dig==4 || dig==7) return false;

            if(dig==2 || dig == 5 || dig == 6 || dig == 9) found = true;
            n/=10;
        }

        return found;
    }
}