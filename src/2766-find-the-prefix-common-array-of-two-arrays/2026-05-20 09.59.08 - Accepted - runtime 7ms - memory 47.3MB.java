class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int ans[] = new int[n];

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> common =new HashSet<>();
        for(int i=0;i<n;i++){
            s1.add(A[i]);
            s2.add(B[i]);
            if(s1.contains(A[i]) && s2.contains(A[i])){
                common.add(A[i]);
            }

            if(s1.contains(B[i]) && s2.contains(B[i])){
                common.add(B[i]);
            }

            ans[i] = common.size();
        }


        return ans;
    }
}