class Solution {
    public long sumOfAncestors(int n, int[][] edges, int[] nums) {
        LinkedList<Integer> adjList[] = new LinkedList[n];
        int max = 0;
        for(int i=0;i<n;i++) {
            adjList[i] = new LinkedList<>();
            max= Math.max(max, nums[i]);
        }

        for(int e[]: edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }

        return solve(adjList, nums, -1, 0, new int[max+1]);
    }

    private long solve(LinkedList<Integer> adjList[], int nums[], int par, int curr, int cnt[]){
        int score = score(nums[curr]);
        long sum = cnt[score];
        cnt[score]++;

        for(int child : adjList[curr]){
            if(child != par){
                sum += solve(adjList, nums, curr, child, cnt);
            }
        }

        cnt[score]--;

        return sum;
    }

    private int score(int x){
        int score = 1;

        for(int i=2;i<=Math.sqrt(x);i++){
            int cnt = 0;
            while(x%i==0){
                x/=i;
                cnt++;
            }

            if(cnt%2==1){
                score *=i;
            }
        }

        if(x > 1){
            score *=x;
        }

        return score;
    }
}