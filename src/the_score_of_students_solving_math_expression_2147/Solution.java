package the_score_of_students_solving_math_expression_2147;

import java.util.*;
class Solution {
    Set<Integer> nums[][];
    public int scoreOfStudents(String s, int[] answers) {
        
        int result = 0;
        int n = s.length();
        nums = new HashSet[n][n];
        
        solve(s.toCharArray(), 0, n-1);
        for(int i=1,j=0;i<=n;i+=2){
            if(i == n || s.charAt(i) == '+'){
                int mul = 1;
                while(j < i){
                    mul *= (s.charAt(j) - '0');
                    j+=2;
                }
                result += mul;
            }
        }

        int ans = 0;

        for(int val : answers){
            if(val == result){
                ans += 5;
            }else if(nums[0][n-1].contains(val)){
                ans += 2;
            }
        }

        return ans;


    }

    private void solve(char ch[], int start, int end){
        if(start == end){
            nums[start][end] = new HashSet<>();
            nums[start][end].add(ch[start] - '0');
            return;
        }
        if(nums[start][end] !=null) return;

        nums[start][end] =new HashSet<>();
        for(int i=start+1;i<end;i+=2){
            solve(ch, start, i-1);
            solve(ch, i+1, end);

            for(int a : nums[start][i-1]){
                for(int b : nums[i+1][end]){
                    if(ch[i] == '+' && a + b <= 1000){
                        nums[start][end].add(a+b);
                    }else if(ch[i] == '*' && a * b <= 1000){
                        nums[start][end].add(a*b);
                    }
                }
            }
        }
    }
}