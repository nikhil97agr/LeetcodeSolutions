package divide_players_into_teams_of_equal_skill_2581;

import java.util.*;
class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long ans = 0;

        int start =0;
        int end = skill.length-1;
        int n = skill.length;

        int sum = skill[start] + skill[end];

        while(start < end){
            if(skill[start] + skill[end]!=sum) return -1;

            ans = ans + 1L*skill[start]*skill[end];
            start++;
            end--;
        }
        return ans;
    }
}