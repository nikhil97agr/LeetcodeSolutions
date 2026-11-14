package find_beautiful_indices_in_the_given_array_i_3245;

import java.util.*;
class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer>l1 =  check(s, a);
        List<Integer>l2 =  check(s, b);

        List<Integer> result = new ArrayList<>();
        for(int l : l1){
            if(check(l - k, l, l2) || check(l, l + k, l2)){
                result.add(l);
            }
        }

        return result;
    }

    private boolean check(int s, int e,List<Integer> list){
        int start = 0;
        int end= list.size() - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid) >= s && list.get(mid) <= e){
                return true;
            }

            if(list.get(mid) < s){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }

    private List<Integer> check(String s, String a){
        int lps[] =lps(a.toCharArray());

        List<Integer> list = new ArrayList<>();

        int i=0;
        int j=0;
        while( i < s.length()){
            if(s.charAt(i) == a.charAt(j)){
                i++;
                j++;

                if(j == a.length()){
                    list.add(i-j);
                    j = lps[j-1];
                }
            }else{
                if(j==0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }

        return list;
    }

    private int[] lps(char arr[]){
        int lps[] = new int[arr.length];

        int i=1;
        int len = 0;
        while( i < arr.length){
            if(arr[i] == arr[len]){
                len++;
                lps[i] =len;
                i++;
            }else{
                if(len==0) i++;
                else len =lps[len- 1];
            }
        }

        return lps;
    }
}