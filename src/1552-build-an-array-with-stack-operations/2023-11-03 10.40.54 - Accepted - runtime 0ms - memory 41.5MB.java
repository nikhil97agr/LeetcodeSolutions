class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int i =1;
        int j = 0;
        while(i<=n && j<target.length){
            if(i == target[j]){
                result.add("Push");
                j++;
                i++;
                continue;
                
            }
                result.addAll(Arrays.asList("Push", "Pop"));
            
            i++;
        }

        return result;
    }
}