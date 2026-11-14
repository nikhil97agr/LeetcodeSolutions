package palindrome_rearrangement_queries_3203;

import java.util.*;
import java.util.Arrays;

class Solution {

    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {

        var n = s.length();
        var q = queries.length;
        var ch = s.toCharArray();
        var cnt = new int[26];
        for (var i = 0; i < n / 2; i++) {
            cnt[ch[i] - 'a']++;
            cnt[ch[i + n / 2] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) {
                var res = new boolean[q];
                return res;
            }
        }
        var size = n / 2;
        char c1[] = new char[n / 2];
        char c2[] = new char[n / 2];
        for (int start = 0, end = n - 1; start < end; start++, end--) {
            c1[start] = ch[start];
            c2[start] = ch[end];
        }

        var c1Cnt = new int[size][26];
        var c2Cnt = new int[size][26];

        for (int i = 0; i < size; i++) {
            if (i > 0) {
                c1Cnt[i] = c1Cnt[i - 1].clone();
                c2Cnt[i] = c2Cnt[i - 1].clone();
            }
            c1Cnt[i][c1[i] - 'a']++;
            c2Cnt[i][c2[i] - 'a']++;
        }

        var pre = new int[size];
        for(int i=0;i<size;i++){
            if( i > 0){
                pre[i] = pre[i-1];
            }
            
            if(c1[i] == c2[i]){
                pre[i]++;
            }
        }
        var empty = new int[26];
        var res = new boolean[q];
        for (int i = 0; i < q; i++) {
            var l1 = queries[i][0];
            var r1 = queries[i][1];
            var r2 = n - 1 - queries[i][2];
            var l2 = n - 1 - queries[i][3];

            var ll = Math.min(l1, l2)-1;
            var rr = Math.max(r1, r2);
            
            if(( ll >= 0 && pre[ll] != ll + 1)){
                continue;
            }
            
            if(rr < size && pre[size - 1] - pre[rr] != size - rr -1){
                continue;
            }
            
            


            if (r1 < l2 || l1 > r2) {
                
                if( r1 < l2){
                    if(pre[l2 - 1] - pre[r1] != (l2 - 1) - r1){
                        continue;
                    }
                }else{
                    if(pre[l1-1] - pre[r2] != (l1 -1 ) - r2){
                        continue;
                    }
                }
                
                var d1 = diff(c1Cnt[r1], l1 == 0 ? empty : c1Cnt[l1 - 1]);
                var d2 = diff(c2Cnt[r1], l1 == 0 ? empty : c2Cnt[l1 - 1]);
                if (!Arrays.equals(d1, d2)) {
                    continue;
                }

                d1 = diff(c1Cnt[r2], l2 == 0 ? empty : c1Cnt[l2 - 1]);
                d2 = diff(c2Cnt[r2], l2 == 0 ? empty : c2Cnt[l2 - 1]);
                if (Arrays.equals(d1, d2)) {
                    res[i] = true;
                }
                continue;
            }


            if (l1 <= l2 && r2 <= r1) {

                res[i] = check(diff(c1Cnt[r1], l1 == 0 ? empty : c1Cnt[l1 - 1]),
                        diff(c2Cnt[r1], l1 == 0 ? empty : c2Cnt[l1 - 1]));
                continue;
            }

            if (l2 <= l1 && r1 <= r2) {
                res[i] = check(diff(c1Cnt[r2], l2 == 0 ? empty : c1Cnt[l2 - 1]),
                        diff(c2Cnt[r2], l2 == 0 ? empty : c2Cnt[l2 - 1]));
                continue;
            }

            var d1 = diff(c1Cnt[r1], l1 == 0 ? empty : c1Cnt[l1 - 1]);
            var d2 = diff(c2Cnt[r2], l2 == 0 ? empty : c2Cnt[l2 - 1]);
            if (l1 <= l2) {
                var d3 = diff(l2 == 0 ? empty : c2Cnt[l2 - 1], l1 == 0 ? empty : c2Cnt[l1 - 1]);
                if (!reduce(d1, d3)) {
                    continue;
                }

                var d4 = diff(c1Cnt[r2], c1Cnt[r1]);
                if (!reduce(d2, d4)) {
                    continue;
                }

                res[i] = Arrays.equals(d1, d2);
            } else {
                var d3 = diff(l1 == 0 ? empty : c1Cnt[l1 - 1], l2 == 0 ? empty : c1Cnt[l2 - 1]);
                if (!reduce(d2, d3)) {
                    continue;
                }

                var d4 = diff(c2Cnt[r1], c2Cnt[r2]);
                if (!reduce(d1, d4)) {
                    continue;
                }

                res[i] = Arrays.equals(d1, d2);
            }

        }

        return res;


    }
    
    private boolean reduce(int c1[], int c2[]) {

        for (int i = 0; i < 26; i++) {
            if (c2[i] > c1[i]) {
                return false;
            }

            c1[i] -= c2[i];
        }

        return true;
    }

    private int[] diff(int c2[], int c1[]) {

        int res[] = new int[26];
        for (int i = 0; i < 26; i++) {
            res[i] = c2[i] - c1[i];
        }

        return res;
    }

    private boolean check(int c1[], int c2[]) {

        return Arrays.equals(c1, c2);
    }
}