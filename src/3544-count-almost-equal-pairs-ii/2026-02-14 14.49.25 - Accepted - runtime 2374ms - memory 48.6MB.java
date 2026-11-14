class Solution {
    public int countPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        Arrays.sort(nums);
        for(int x : nums){
            for(int num : getNums(x)){
                ans += map.getOrDefault(num, 0);
            }
            map.merge(x, 1, Integer::sum);
        }

        return ans;
    }

    private Set<Integer> getNums(int x){
        Set<Integer> set = new HashSet<>();
        char ch[]= Integer.toString(x).toCharArray();
        int n = ch.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                swap(ch, i, j);
                for(int k=0;k<n;k++){
                    for(int l=k;l<n;l++){
                        swap(ch, k, l);
                        set.add(Integer.parseInt(new String(ch)));
                        swap(ch, k, l);
                    }
                }
                swap(ch, i ,j);
            }
        }

        return set;

    }

    private void swap(char ch[], int i, int j){
        char temp = ch[i];
        ch[i]= ch[j];
        ch[j] = temp;
    }

}