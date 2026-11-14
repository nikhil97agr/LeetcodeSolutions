class Solution {
    public int[] prevPermOpt1(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=arr.length-1;i>=0;i--){
            Integer maxInd = map.lowerKey(arr[i]);

            if(maxInd != null){
                int prev = arr[map.get(maxInd)];
                arr[map.get(maxInd)] = arr[i];
                arr[i]= prev;
                return arr;
            }

            map.put(arr[i], i);
        }

        return arr;
    }
}