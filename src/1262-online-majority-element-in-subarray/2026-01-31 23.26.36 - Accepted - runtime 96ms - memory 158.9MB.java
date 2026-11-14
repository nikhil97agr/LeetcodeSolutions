class MajorityChecker {
    int pre[][];
    Map<Integer, List<Integer>> map;
    public MajorityChecker(int[] arr) {
        map = new HashMap<>();
        int n = arr.length;
        pre = new int[n][26];
        for(int i=0;i<n;i++){
            pre[i] = new int[26];
            if(i!=0){
                pre[i] = pre[i-1].clone();
            }
            map.computeIfAbsent(arr[i], x-> new ArrayList<>()).add(i);
            for(int j=25;j>=0;j--){
                if((arr[i] & (1<<j)) !=0){
                    pre[i][j]++;
                }
            }
        }
    }
    
    public int query(int left, int right, int threshold) {
        int r[] = pre[right];
        int l[] = (left ==0 ? new int[26] : pre[left-1]);
        
        int ans = 0;

        for(int j=0;j<26;j++){
            int cnt = r[j] - l[j];
            if(cnt >= threshold){
                ans |= (1<<j);
            }
        }

        if(ans ==0 ) return -1;
        if(!map.containsKey(ans)) return -1;
        int c1 = bs1(map.get(ans), right);
        int c2 = bs2(map.get(ans), left);

        if(c1 < c2) return -1;

        if(c1 - c2 + 1 >= threshold) return ans;

        return -1;
    }

    private int bs2(List<Integer> list, int val){
        int ans = list.size();
        int start =0;
        int end = ans - 1;
        while(start <= end){
            int mid = (start +end)/2;
            if(list.get(mid) >= val){
                ans = mid;
                end = mid- 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private int bs1(List<Integer> list, int val){
        int ans = 0;
        int start =0;
        int end = list.size()-1;
        while(start <= end){
            int mid = (start+end)/2;

            if(list.get(mid) <= val){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */