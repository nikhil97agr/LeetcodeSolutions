class Solution {
    public int[][] averageHeightOfBuildings(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[]{b[0], b[2], 1});   // start
            events.add(new int[]{b[1], b[2], -1});  // end
        }

        // sort by position
        Collections.sort(events, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int sum = 0, cnt = 0;
        int prevX = -1;
        int i = 0;

        while (i < events.size()) {
            int currX = events.get(i)[0];

            // close previous segment
            if (prevX != -1 && prevX < currX && cnt > 0) {
                res.add(new int[]{prevX, currX, sum / cnt});
            }

            // process all events at currX
            while (i < events.size() && events.get(i)[0] == currX) {
                int h = events.get(i)[1];
                int type = events.get(i)[2];

                if (type == 1) {
                    sum += h;
                    cnt++;
                } else {
                    sum -= h;
                    cnt--;
                }
                i++;
            }

            prevX = currX;
        }

        Stack<int[]> stack = new Stack<>();
        for(int x[] : res){
            if(stack.isEmpty()){
                stack.push(x);
                continue;
            }

            if(stack.peek()[2] == x[2] && stack.peek()[1] == x[0]){
                stack.peek()[1] = x[1];
            }else{
                stack.push(x);
            }
        }

        return stack.stream().toArray(int[][]::new);
    }
}
