package maximum_product_of_the_length_of_two_palindromic_substrings_1336;

import java.util.*;
class Solution {
    public long maxProduct(String s) {
        ManacherAlgorithm algo = new ManacherAlgorithm(s);
        int p[] = algo.p;
        int n = s.length();
        int left[] = new int[n];
        int right[] = new int[n];
        int radius[] = new int[n];
        for(int i=1,j=0;j < n;i+=2,j++){
            radius[j] = p[i];
        }

        for(int i=0;i<n;i++){
            int len = radius[i] - 1;
            int half = len / 2;
            left[i + half] = Math.max(left[i + half],len);
            if(i > 0){
                left[i] = Math.max(left[i], left[i-1]);
            }
        }
        for(int i=n-1;i>=0;i--){
            int len = radius[i] - 1;
            int half = len / 2;
            right[i - half] = Math.max(right[i-half], len);
            if(i + 1 < n){
                right[i] = Math.max(right[i], right[i + 1]);
            }
        }

        for(int i=n-2;i>=0;i--){
            left[i] = Math.max(left[i], left[i + 1] -2);
        }

        for(int i=1;i<n;i++){
            right[i]= Math.max(right[i-1] -2, right[i]);
        }


        long ans = 0;
        for(int i=0;i<n-1;i++){
            ans = Math.max(ans, 1l * left[i] * right[i+1]);
        }
        return ans;
    }
}


class ManacherAlgorithm {

    String t;
    int p[];

    public ManacherAlgorithm(String s) {

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }

        t = sb.toString();
        p = new int[t.length()];
        Arrays.fill(p, 1);

        build();
    }

    public void build() {

        int n = t.length();
        int l = 1;
        int r = 1;
        for (int i = 1; i < n; i++) {
            if (r - i + l< 0){
                p[i] = Math.max(0, r - i);
            }else{

            p[i] = Math.max(0, Math.min(r - i, p[r - i + l]));
            }
            while (i + p[i] < n && i - p[i] >= 0 && t.charAt(i + p[i]) == t.charAt(i - p[i])) {
                p[i]++;
            }
            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }
    }


}