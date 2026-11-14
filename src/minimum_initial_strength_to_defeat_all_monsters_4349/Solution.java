package minimum_initial_strength_to_defeat_all_monsters_4349;

class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        long ans = 0;
        var n = monsters.length;
        long start = 0;
        long end = 0;
        for(var x : monsters){
            end += x;
        }
        end++;
        var bonus = new long[n + 1];
        for(var b : boosts){
            bonus[b[0]] += b[2];
            bonus[b[1] +1] -= b[2];
        }
        while(start <= end){
            var mid = (start + end)/2;

            if(check(mid, monsters, bonus)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }


        return ans;

    }

    private boolean check(long curr, int monsters[], long bonus[]){
        long sum = 0;
        for(int i=0;i<monsters.length;i++){
            sum += bonus[i];
            if(sum + curr < monsters[i]){
                return false;
            }
            curr = Math.max(curr - monsters[i], 0);
        }

        return true;
    }
}