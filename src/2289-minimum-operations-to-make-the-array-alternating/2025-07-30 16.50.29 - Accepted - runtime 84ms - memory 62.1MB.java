class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
                if(n==1) return 0;

        if(n==2){
            if(nums[0] == nums[1]) return 1;
            return 0;
        }

        int oddCnt = n/2;
        int evenCnt = (n+1)/2;
        int even[][] = getCnt(nums, n, 0);
        int odd[][] = getCnt(nums, n , 1);

        if(odd[0][0] == even[0][0]){
            if(odd[0][0] == -1){
                return 0;
            }
            int ans1 = oddCnt - odd[0][1] + evenCnt - even[1][1];
            int ans2 = oddCnt - odd[1][1] + evenCnt - even[0][1];
            System.out.println(ans1+":"+ans2);
            return Math.min(ans1, ans2);
        }

        return oddCnt - odd[0][1] + evenCnt - even[0][1];
    }

    private int[][] getCnt(int nums[], int n, int start){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=start;i<n;i+=2){
            map.merge(nums[i], 1, Integer::sum);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (e1,e2)-> e2.getValue() - e1.getValue());
        Map.Entry<Integer,Integer> entry = list.get(0);
        if(list.size() ==1){
            return new int[][]{{entry.getKey(), entry.getValue()}, {-1, 0}};
        }

        Map.Entry<Integer, Integer> entry1 = list.get(1);
        return new int[][]{{entry.getKey(), entry.getValue()}, {entry1.getKey(), entry1.getValue()}};

    }
}