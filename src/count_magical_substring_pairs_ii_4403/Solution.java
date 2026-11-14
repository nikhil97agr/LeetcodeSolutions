package count_magical_substring_pairs_ii_4403;

import java.util.*;
class Solution {
    public long countMagicalPairs(String s) {
        long ans = 0;
        TreeSet<Integer>set[] = new TreeSet[26];
        for(int i=0;i<26;i++) set[i] = new TreeSet<>();
        char ch[]= s.toCharArray();
        int n = s.length();
        for(int i=0;i<n;i++){
            int ind = ch[i] - 'a';
            set[ind].add(i);
        }

        for(int j=0;j< n -1;j++){
  

            int i = j;
            int k= j+ 1;

            List<Integer> left = new ArrayList<>();
            left.add(-1);
            List<Integer> right= new ArrayList<>();
            right.add(n);
            for(int ind =0;ind < 26;ind++){
                Integer index = set[ind].floor(i);
                if(index!= null){
                    left.add(index);
                }
                index = set[ind].ceiling(k);
                if(index !=null){
                    right.add(index);
                }
            }

            Collections.sort(left);
            Collections.sort(right);

            i = left.size() - 1;
            k = 0;

            while( i > 0 && k < right.size() - 1){
                long cl = left.get(i) - left.get(i-1);
                long cr = right.get(k+1) - right.get(k);
                ans += cl * cr;
                i--;
                k++;

            }

        }

        return ans;
    }

    private int get(char ch){
        return ch-'a';
    }
}