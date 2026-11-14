class Solution {
    public long minPartitionScore(int[] nums, int k) {
        var n = nums.length;
        var pre = new long[n + 1];
        for(var i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
        }
        var res = Long.MAX_VALUE;
        var dp = new long[n+1][k+1];
        for(var d : dp){
            Arrays.fill(d, Long.MAX_VALUE);
        }
        var max = Long.MAX_VALUE;
        dp[0][0]=0;

        for(int i=1;i<=k;i++){
            var que = new ArrayDeque<long[]>();
            for(var j = i - 1;j<n;j++){
                if(dp[j][i-1] != max){
                    var sum = pre[j];
                    que.offer(new long[]{-sum, val(-sum) + dp[j][i-1]});

                    while(que.size() >= 3){
                        var last = que.pollLast();
                        var secondLast = que.pollLast();
                        var thirdLast = que.pollLast();
                        if(check(thirdLast, secondLast, last)){
                            que.offer(thirdLast);
                            que.offer(last);
                        }else{
                            que.offerLast(thirdLast);
                            que.offerLast(secondLast);
                            que.offerLast(last);
                            break;
                        }
                    }
                }
                var sum = pre[j + 1];
                while(que.size() >= 2){
                    var a = que.pollFirst();
                    var b = que.pollFirst();
                    if(a[0] * sum + a[1] >= b[0] * sum + b[1]){
                        que.offerFirst(b);
                    }else{
                        que.offerFirst(b);
                        que.offerFirst(a);
                        break;
                    }

                }


                dp[j+1][i] = que.peekFirst()[0] * sum + que.peekFirst()[1] + val(sum);

            }
        }

        return dp[n][k];
    }

    private boolean check(long a[], long b[], long c[]){
        var s1 = (c[1] - a[1]) * (a[0] - b[0]);
        var s2 = (b[1] - a[1]) * (a[0] - c[0]);
        return s1 <= s2;
    }


    private long val(long sum){
        return (sum * (sum + 1))/2;
    }
}