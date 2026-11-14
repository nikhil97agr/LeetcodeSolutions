class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int x[] : nums1){
            int id = x[0];
            int val = x[1];
            int curr = map.getOrDefault(id, 0);

            map.put(id, curr + val);
        }
                for(int x[] : nums2){
            int id = x[0];
            int val = x[1];
            int curr = map.getOrDefault(id, 0);

            map.put(id, curr + val);
        }

        int res[][] = new int[map.size()][2];
        int ind = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            res[ind] = new int[]{entry.getKey(), entry.getValue()};
            ind++;
        }
        return res;
    }
}