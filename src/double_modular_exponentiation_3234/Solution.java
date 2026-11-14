package double_modular_exponentiation_3234;

import java.util.*;
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result = new ArrayList<>();

        int n = variables.length;

        for(int i=0;i<n;i++){
            int a = pow(variables[i][0], variables[i][1], 10);
            int b= pow(a, variables[i][2], variables[i][3]);
            if(b==target){
                result.add(i);
            }
        }

        return result;
    }

    private int pow(int a, int b, int mod){
        if(a==0) return 0;

        if(b==0) return 1%mod;
        if(b==1) return a%mod;

        int ans = pow(a,b/2, mod);
        ans = ans*ans;
        ans%=mod;

        if(b%2==1){
            ans *=a;
            ans%=mod;
        }

        return ans;
    }
}