package add_binary_67;

import java.util.*;
class Solution {
    public String addBinary(String a, String b) {
        ArrayList<Character> result = new ArrayList<Character>();
        int i = a.length()-1;
        int j = b.length()-1;
        boolean carry = false;
        while(i>=0 && j>=0){
            if(carry){
                if(a.charAt(i)=='0' && b.charAt(j)=='0'){
                    result.add('1');
                    carry = false;
                }else if(a.charAt(i)=='1' && b.charAt(j)=='1'){
                    result.add('1');
                }else{
                    result.add('0');
                }
            }else{
                if(a.charAt(i)=='0' && b.charAt(j)=='0'){
                    result.add('0');
                }else if(a.charAt(i)=='1' && b.charAt(j)=='1'){
                    result.add('0');
                    carry = true;
                }else{
                    result.add('1');
                }
            }
            i--;
            j--;
        }
        while(i>=0){
            if(carry){
                if(a.charAt(i)=='1'){
                    result.add('0');
                }else{
                    result.add('1');
                    carry =false;
                }
            }else{
                if(a.charAt(i)=='1'){
                    result.add('1');
                }else{
                    result.add('0');
                }
            }
            i--;
        }
        while(j>=0){
            if(carry){
                if(b.charAt(j)=='1'){
                    result.add('0');
                }else{
                    result.add('1');
                    carry =false;
                }
            }else{
                if(b.charAt(j)=='1'){
                    result.add('1');
                }else{
                    result.add('0');
                }
            }
            j--;
        }
        if(carry){
            result.add('1');

        }

        char ans[] = new char[result.size()];
        i=0;
        for(;i<ans.length;i++){
            ans[i] = result.get(result.size()-1-i);
        }

        return new String(ans);
    }
}