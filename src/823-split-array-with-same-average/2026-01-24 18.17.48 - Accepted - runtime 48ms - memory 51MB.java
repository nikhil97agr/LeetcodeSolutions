class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int s = Arrays.stream(nums).sum();
        int a[] = IntStream.range(0, n/2).map(x -> nums[x]).toArray();
        int b[] = IntStream.range(n/2, n).map(x-> nums[x]).toArray();

        Map<Integer, Set<Integer>> m1 = new HashMap<>();
        Map<Integer, Set<Integer>> m2 = new HashMap<>();
        subsetSum(m1, a, 0,0, a.length, 0);
        subsetSum(m2, b, 0,0, b.length, 0);
        
        for(int len : m1.keySet()){
            Set<Integer> set = m1.get(len);

            for(int sum : set){
                for(int i=0; (n - (i+len)) > 0;i++){
                    int l = i+ len;
                    if(l ==0) continue;
                    if((s * l)%n!=0) continue;

                    int y = (s * l)/n - sum;
                    if(m2.getOrDefault(i, new HashSet<>()).contains(y)) return true;
                }
            }
        }
        return false;
    }

    private void subsetSum(Map<Integer, Set<Integer>> map, int a[], int i,int sum, int n, int len){
        if(i==n){
            map.computeIfAbsent(len, x-> new HashSet<>()).add(sum);
            return;
        }
        subsetSum(map, a, i+1, sum + a[i], n, len + 1);
        subsetSum(map, a, i+1, sum, n, len);
    }
}





// a * n = s * n1

//x + y = (s*n1)/n 