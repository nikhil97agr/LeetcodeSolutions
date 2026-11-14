class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean arr[] = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for(int i=2;i<=n;i++){
            if(arr[i]){
                int j = i+i;
                while(j<=n){
                    arr[j] = false;
                    j+=i;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(i> n-i) break;
            if(arr[i] && arr[n-i]){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(n-i);
                result.add(temp);
            }
        }
        return result;
    }
    
}