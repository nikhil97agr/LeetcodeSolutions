class Solution {
    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : arr){
            map.merge(x, 1 , Integer::sum);
        }
        int ans = 0;

        for(int x : arr){
            if(map.containsKey(x+1)){
                ans++;
            }
        }

        return ans;
    }
}