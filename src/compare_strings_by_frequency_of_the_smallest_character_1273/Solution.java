package compare_strings_by_frequency_of_the_smallest_character_1273;

import java.util.*;
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        List<Integer> freq = new ArrayList<>();
        for(String w : words){
            freq.add(cnt(w.toCharArray()));
        }

        Collections.sort(freq);
        int ans[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i] = find(queries[i].toCharArray(), freq);
        }

        return ans;

    }


    private int find(char ch[], List<Integer> freq){
        int cnt = cnt(ch);

        int ind= -1;

        int start = 0;
        int end= freq.size() - 1;
        while(start <= end){
            int mid= (start + end)/2;

            if(freq.get(mid) <= cnt){
                start = mid + 1;
            }else{
                ind = mid;
                end = mid - 1;
            }
        }

        if(ind==-1) return 0;

        return freq.size() - ind;
    }

    private int cnt(char ch[]){
        int cnt[] = new int[26];

        for(char c : ch){
            cnt[c-'a']++;
        }
        

        for(int i=0;i<26;i++){
            if(cnt[i] !=0){
                return cnt[i];
            }
        }
        return 0;
    }
}