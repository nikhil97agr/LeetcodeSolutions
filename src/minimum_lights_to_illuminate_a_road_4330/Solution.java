package minimum_lights_to_illuminate_a_road_4330;

class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int cnt[] = new int[n + 1];
        for(int i=0;i<n;i++){
            int v = lights[i];

            if(v ==0 ) continue;

            cnt[Math.max(i - v, 0)]++;
            cnt[Math.min(i + v + 1, n)]--;
        }

        int ct = 0;

        int c = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            c+= cnt[i];

            if( c==0 ){
                ct++;
            }else{
                ans += (ct+2)/3;
                ct=0;
            }
        }

        return ans + (ct + 2)/3;
    }
}