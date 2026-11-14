package count_of_substrings_containing_every_vowel_and_k_consonants_ii_3569;

import java.util.*;
class Solution {
    public long countOfSubstrings(String word, int k) {
        long ans = 0;
        int start =0 ;
        int end = 0;
        int n = word.length();
        char ch[]= word.toCharArray();
        int constInd[] = new int[n];
        int last = n;
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;

        for(int i=n-1;i>=0;i--)
        {
            constInd[i] = last;
            if(!vowel(ch[i])){
                last = i;
            }
        }

        while(end < n){
            if(vowel(ch[end])){
                map.put(ch[end], map.getOrDefault(ch[end], 0)+1);
            }else{
                cnt++;
            }

            if(cnt > k){
                while(cnt > k && start < n){
                    if(vowel(ch[start])){
                        map.put(ch[start], map.get(ch[start]) - 1);
                        if(map.get(ch[start]) == 0) map.remove(ch[start]);
                    }else{
                        cnt--;
                    }
                    start++;
                }
            }

            while(start < n && cnt == k && map.size() == 5){
                ans += (constInd[end] - end);

                if(vowel(ch[start])){
                    map.put(ch[start], map.get(ch[start])-1);
                    if(map.get(ch[start]) == 0){
                        map.remove(ch[start]);
                    }
                }else{
                    cnt--;
                }
                start++;
            }
            end++;
        }

        return ans;
    }

    private boolean vowel(char ch){
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u': 
            return true;

        }

        return false;
    }
}