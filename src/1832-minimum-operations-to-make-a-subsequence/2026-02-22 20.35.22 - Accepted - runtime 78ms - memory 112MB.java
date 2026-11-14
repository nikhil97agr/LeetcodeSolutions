class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = target.length;
        for(int i=0;i<n;i++){
            map.put(target[i], i);
        }

        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            if(!map.containsKey(val)) arr[i] = -1;
            else arr[i] = map.get(val);
            
        }
        List<Integer> subseq = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            if(val == -1)continue;
            int ind = Collections.binarySearch(subseq, val);
            if(ind < 0){
                ind = -ind -1;
            }

            if(ind == subseq.size()){
                subseq.add(val);
            }else{
                subseq.set(ind, val);
            }
        }


        return n - subseq.size();
    }
}