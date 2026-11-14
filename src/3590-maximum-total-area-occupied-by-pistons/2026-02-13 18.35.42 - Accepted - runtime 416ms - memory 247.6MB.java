class Solution {
    public long maxArea(int height, int[] positions, String directions) {
        long ans = 0;
        List<State> list= new ArrayList<>();
        int n =positions.length;
        long sum = 0;
        long up =0, down =0;

        for(int i=0;i<n;i++){
            sum += positions[i];

            if(directions.charAt(i) == 'U'){
                up++;
                list.add(new State(height - positions[i], 'U'));
                list.add(new State(2 * height - positions[i], 'D'));
            }else{
                down++;
                list.add(new State(positions[i], 'D'));
                list.add(new State(positions[i] + height, 'U'));
            }
        }
        Collections.sort(list, (a,b)->{
            return a.pos - b.pos;
        });
        ans = sum;
        for(int i=1,ind =0; i <= 2 * height && ind <2 * n;i++){
            sum += up - down;
            ans = Math.max(ans, sum);

            while( ind < 2 * n && list.get(ind).pos == i){
                if(list.get(ind).dir == 'U'){
                    up--;
                    down++;
                }else{
                    up++;
                    down--;
                }
                ind++;
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }

    class State{
        int pos;
        char dir;
        public State(int pos, char dir){
            this.pos= pos;
            this.dir = dir;
        }
    }
}