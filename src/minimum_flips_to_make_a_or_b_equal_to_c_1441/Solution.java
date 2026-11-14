package minimum_flips_to_make_a_or_b_equal_to_c_1441;

class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while(c!=0){
            int i1 = a%2;
            int i2 = b%2;
            int i3 = c%2;
            a/=2;
            b/=2;
            c/=2;
            if(i3==1){
                if(i1!=1&&i2!=1){
                    count++;
                }
            }else{
                if(i1==1){
                    count++;
                }
                if(i2==1){
                    count++;
                }
            }
        }
        while(a!=0){
            int i = a%2;
            if(i==1){
                count++;
            }
            a/=2;
        }
        while(b!=0){
            int i = b%2;
            if(i==1){
                count++;
            }
            b/=2;
        }
        return count;
    }
}