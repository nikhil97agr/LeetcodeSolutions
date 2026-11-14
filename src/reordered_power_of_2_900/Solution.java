package reordered_power_of_2_900;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        int dig[] = new int[10];
        while( n > 0){
            int mod = n%10;
            dig[mod]++;
            n/=10;
        }

        for(int i=1;i<(1<<30);i <<=1){
            if(check(dig, i)) return true;
        }


        return false;
    }

    private boolean check(int dig[], int x){
        int arr[] = dig.clone();

        while(x > 0){
            arr[x%10]--;
            x/=10;
        }

        for(int i=0;i<=9;i++){
            if(arr[i]!=0) return false;
        }

        return true;
    }


}