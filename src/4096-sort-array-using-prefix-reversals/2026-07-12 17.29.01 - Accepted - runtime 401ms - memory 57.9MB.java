class Solution {
    public int sortArray(int[] nums, int[] pre) {
        var n = nums.length;
        var sorted = nums.clone();
        Arrays.sort(sorted);

        Set<String>vis = new HashSet<>();

        Queue<int[]> que = new LinkedList<>();
        que.offer(nums);

        vis.add(Arrays.toString(nums));

        int steps= 0;

        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int next[] = que.poll();

                if(Arrays.equals(next, sorted)){
                    return steps;
                }

                for(int x : pre){
                    int rev[] = reverse(next.clone(), x);
                    String str = Arrays.toString(rev);
                    if(!vis.contains(str)){
                        que.offer(rev);
                        vis.add(str);
                    }
                }
            }
            steps++;
        }

        return -1;

    }

    private int[] reverse(int arr[], int len){
        int start = 0;
        int end = len - 1;
        while(start < end){
            int a= arr[start];
            arr[start] = arr[end];
            arr[end] = a;
            start++;
            end--;
        }

        return arr;
    }
}