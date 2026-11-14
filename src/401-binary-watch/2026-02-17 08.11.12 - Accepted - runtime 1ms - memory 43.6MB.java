class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        int top[] = new int[]{8, 4, 2,1};
        int bottom[] = new int[]{32,16,8,4,2,1};

        List<String> res = new ArrayList<>();

        for(int i=0;i<=turnedOn;i++){
            Set<Integer> setT = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            generate(top, 0, top.length, i, 11, 0, 0, setT);
            generate(bottom, 0, bottom.length, turnedOn - i, 59, 0, 0, setB);

            for(int t : setT){
                for(int b : setB){
                    
                        StringBuilder sb = new StringBuilder();
                        sb.append(t);
                        sb.append(":");
                        if(b < 10)
                            sb.append("0");
                        sb.append(b);
                    res.add(sb.toString());
                }
            }
        }

        return res;
    }

    private void generate(int arr[], int i, int n, int limit, int max, int cnt, int number, Set<Integer> set){
        if(number > max) return;
        if(cnt == limit){
             set.add(number);
             return;
        }

        if(i ==n ) return;

        generate(arr, i+1, n, limit, max, cnt, number, set);
        generate(arr, i+1, n, limit, max, cnt+1, number + arr[i], set);
    }
}