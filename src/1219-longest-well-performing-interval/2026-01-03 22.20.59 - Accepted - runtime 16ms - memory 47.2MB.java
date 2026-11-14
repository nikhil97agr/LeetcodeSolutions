class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = hours[i] > 8 ? 1 : -1;
        }

        Map<Integer, Integer> map =new HashMap<>();

        int sum =0;
        int ans =0;

        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum > 0){
                ans = Math.max(ans, i + 1);
            }
            int req = sum - 1;
            if(map.containsKey(req)){
                int ind = map.get(req);
                ans = Math.max(ans, i - ind );
            }

            if(!map.containsKey(sum)){
                map.put(sum ,i);
            }
        }

        return ans;

    }
}