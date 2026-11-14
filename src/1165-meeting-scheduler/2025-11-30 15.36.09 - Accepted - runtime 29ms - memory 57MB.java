class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a,b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a,b) -> a[0] - b[0]);

        int i=0;
        int j=0;

        while(i < slots1.length && j < slots2.length){
            int s1 = slots1[i][0];
            int s2 = slots2[j][0];
            int e1 = slots1[i][1];
            int e2 = slots2[j][1];

            int m = Math.max(s1, s2);

            if(m + duration <= e1 && m + duration <= e2){
                return List.of(m, m + duration);
            }

            if(s1 <= s2 && e1 >= e2){
                j++;
                continue;
            }
            if(s2 <= s1 && e2 >= e1){
                i++;
                continue;
            }

            if(s1 < s2){
                i++;
            }else{
                j++;
            }
        }

        return new ArrayList<>();
    }
}