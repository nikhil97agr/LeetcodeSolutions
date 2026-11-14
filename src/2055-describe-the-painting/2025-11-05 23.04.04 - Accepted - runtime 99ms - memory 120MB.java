class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> result = new ArrayList<>();
        long prevStart = -1;
        Arrays.sort(segments, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });
        PriorityQueue<long[]> que = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }

            return Long.compare(a[0], b[0]);
        });

        for (int seg[] : segments) {
            que.offer(new long[] { seg[0], 1, seg[2] });
            que.offer(new long[] { seg[1], -1, seg[2] });
        }
        long sum = 0;

        while (!que.isEmpty()) {
            long next[] = que.poll();
            if (next[1] == -1) {
                if (prevStart == next[0]) {
                    sum -= next[2];
                    if(sum ==0){
                        prevStart = -1;
                    }
                } else {
                    result.add(Arrays.asList(prevStart, next[0], sum));
                    sum -= next[2];
                    if (sum == 0) {
                        prevStart = -1;
                    } else {
                        prevStart = next[0];
                    }
                }
            } else {
                if (prevStart == -1) {
                    sum += next[2];
                    prevStart = next[0];
                } else if(next[0] == prevStart){
                    sum += next[2];
                }
                else {
                    result.add(Arrays.asList(prevStart, next[0], sum));
                    sum += next[2];
                    prevStart = next[0];
                }
            }
        }

        return result;

    }
}