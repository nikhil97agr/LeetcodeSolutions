class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int mid = (n-1)/2;
        mid = arr[mid];
        int nums[][] = new int[n][2];
        for(int i=0;i<n;i++){
            nums[i] = new int[]{Math.abs(arr[i] - mid), arr[i]};
        } 

        Arrays.sort(nums, (a,b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(int x [] : nums){
            int sum = x[0];
            int val = x[1];

            int cnt = bs(sum, val, nums);
            que.offer(new int[]{cnt, val});
            if(que.size() > k) que.poll();
        }

        int ans[] =new int[k];

        for(int i=0;i<k;i++){
            ans[i] = que.poll()[1];
        }

        return ans;



    }

    private int bs(int sum, int val, int nums[][]){
        int cnt = 0;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid][0] > sum){
                end= mid - 1;
            }else if(nums[mid][0] == sum){
                if(nums[mid][1] >= val){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                    cnt = mid + 1;
                }
            }else{
                cnt = mid + 1;
                start = mid + 1;
            }
        }

        return cnt;
    }
}