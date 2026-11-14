package finding_3_digit_even_numbers_2215;

import java.util.*;
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int cnt[] = new int[10];
        for(int d : digits) cnt[d]++;

        int ans[] = new int[1000];

        int ind = 0;

        for(int i=1;i<10;i++){
            if(cnt[i] ==0) continue;
            cnt[i]--;

            for(int j=0;j<10;j++){
                if(cnt[j] ==0) continue;
                cnt[j]--;

                for(int k=0;k<10;k+=2){
                    if(cnt[k] ==0) continue;

                    ans[ind++] = i*100 + j*10 + k;


                }
                cnt[j]++;
            }
            cnt[i]++;
        }


        return Arrays.copyOf(ans, ind);
    }
}