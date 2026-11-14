package minimum_window_substring_76;

import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        int n =  s.length();
        int m = t.length();
        if(m>n){
            return "";
        }
        if(s.equals(t)){
            return s;
        }
        if(n==1){
            if(s.equals(t)){
                return s;
            }
            else{
                return "";
            }
        }
        int c1[] = new int[255];
        int c2[] = new int[255];
        Arrays.fill(c1, 0);
        Arrays.fill(c2,0);
        for(char c : t.toCharArray()){
            c1[c]++;
        }
        
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c1[c]!=0){
                c2[c]++;
                if(check(c1, c2)){
                    int len = i-left+1;
                    if(len<min){
                        start = left;
                        end = i;
                        min = len;
                    }
                    while(left<=i&&check(c1,c2)){
                        len = i-left+1;
                        if(len<min){
                            start = left;
                            end = i;
                            min = len;
                        }
                      
                        char ch = s.charAt(left);
                        if(c2[ch]>0){
                            c2[ch]--;
                        }
                        left++;
                        
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(start, end+1);

    }
    
    public boolean check(int []c1, int [] c2){
        for(int i=0;i<255;i++){
            if(c2[i]<c1[i]){
                return false;
            }
            
        }
        return true;
    }
}