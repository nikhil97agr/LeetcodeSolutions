class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        long sum = Arrays.stream(technique1).mapToLong(x-> x).sum();
        int n = technique1.length;
        long diff[]= new long[n];
        for(int i=0;i<n;i++){
            diff[i] = technique2[i] - technique1[i];
        }

        Arrays.sort(diff);
        int total = n;
        int i= n-1;
        while(total > k && i >=0 && diff[i] > 0){
            sum += diff[i];
            i--;
            total--;
        }

        return sum;
    }
}