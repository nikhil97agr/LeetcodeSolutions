package minimum_cost_to_set_cooking_time_2266;

class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int ans = Integer.MAX_VALUE;
        for(int a=0;a<=9;a++){
            for(int b=0;b<=9;b++){
                for(int c=0;c<=9;c++){
                    for(int d=0;d<=9;d++){
                        int sec = (a * 10 + b)*60 + c*10 + d;
                        if(sec != targetSeconds) continue;

                        int arr[] ={a,b,c,d};
                        int i=0;
                        while(i < arr.length && arr[i]==0) i++;

                        int cost = 0;
                        int curr = startAt;
                        while(i < arr.length){
                            cost += calc(arr[i], curr, pushCost, moveCost);
                            curr = arr[i];
                            i++;
                        }

                        ans = Math.min(ans, cost);
                    }
                }
            }
        }
        return ans;
    }

    int calc(int curr, int prev, int push, int move){
          if(prev == curr){
                return push;
                
            }else{
                return push + move;
            }
    }

}