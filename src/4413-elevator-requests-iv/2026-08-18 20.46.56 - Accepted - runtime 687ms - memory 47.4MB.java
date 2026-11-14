class Solution {
    public long elevatorRequests(int n, int start, int[][] requests) {
        Map<Integer, Long> map = new HashMap<>();
        for (int r[] : requests) {
            map.merge(r[1], 1l * r[0], (prev, curr) -> {
                if (prev == null)
                    return curr;

                return Math.max(prev, curr);
            });
        }
        int m = map.size();

        List<Integer> floors = new ArrayList<>(map.keySet());
        floors.sort(Integer::compareTo);

        long s = map.values().stream().max(Long::compareTo).get();
        long e = 0;
        long curr = start;
        for (var floor : floors) {
            e = Math.max(e + Math.abs(floor - curr), map.get(floor));
            curr = floor;
        }
        long ans = -1;
        while (s <= e) {
            var mid = (s + e) / 2;

            if (possible(mid, floors, start, map)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;
    }

    private boolean possible(Long mid, List<Integer> floors, int start, Map<Integer, Long> map) {
        if (floors.size() == 1) {
            return Math.abs(floors.get(0) - start) <= mid;
        }

        long max = Long.MAX_VALUE/4;
        var m = floors.size();
        var left = new long[m];
        var right = new long[m];

        for(var i =2;i <= m;i++){
            int total = m - i + 1;

            var nl = new long[total];
            var nr = new long[total];
            Arrays.fill(nl, max);
            Arrays.fill(nr, max);

            for(var l = 0;l < total;l++){
                var r = l + i - 1;

                var leftTime = Math.min(
                    left[l + 1] + floors.get(l + 1) - floors.get(l),
                    right[l + 1] + floors.get(r) - floors.get(l)
                    );
                
                if(leftTime + map.get(floors.get(l)) <= mid){
                    nl[l] = leftTime;
                }

                var rightTime = Math.min(
                    left[l] + floors.get(r) - floors.get(l),
                    right[l] + floors.get(r) - floors.get(r - 1)
                );

                if(rightTime + map.get(floors.get(r)) <= mid){
                    nr[l] = rightTime;
                }
            }
            left = nl;
            right = nr;
        }

        return Math.min(

            left[0] + Math.abs(floors.get(0) - start),
            right[0] + Math.abs(floors.get(m-1) - start)

        ) <= mid;

    }
}
