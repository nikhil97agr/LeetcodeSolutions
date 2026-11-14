package earliest_finish_time_for_land_and_water_rides_ii_3967;

import java.util.*;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        new Solution().earliestFinishTime(new int[]{80,71}, new int[]{27,47}, new int[]{45,3,64,7,25,45,6}, new int[]{40,39,66,64,24,74,49});
    }
    public int earliestFinishTime(int[] lStart, int[] lDuration, int[] wStart, int[] wDuration) {
        int n =lStart.length;
        int m = wStart.length;
        int ans = Integer.MAX_VALUE;
        Slide land[] = new Slide[n];
        Slide water[] = new Slide[m];

        for(int i=0;i<n;i++){
            land[i] = new Slide(lStart[i], lStart[i] + lDuration[i], lDuration[i]);
        }



        Arrays.sort(land, (l1,l2)->{
            if(l1.start == l2.start){
                return l1.end - l2.end;
            }

            return l1.start - l2.start;
        });
        for(int i=0;i<m;i++){
            water[i] = new Slide(wStart[i], wStart[i] + wDuration[i], wDuration[i]);

        }

        Arrays.sort(water, (w1, w2)->{
            if(w1.start == w2.start){
                return w1.end - w2.end;
            }

            return w1.start - w2.start;
        });

        int minl[] = minDuration(land);
        int minw[] = minDuration(water);

        int minel[] = minEnd(land);
        int minew[] = minEnd(water);


        for(Slide slide : land){
            int start =0;
            int end = m-1;
            int e = slide.end;
            int ind = -1;
            while(start <= end){
                int mid = (start + end)/2;
                if(water[mid].start >= e){
                    end = mid -1;
                }else{
                    ind = mid;
                    start = mid + 1;
                }
            }

            if(ind != -1){
                ans = Math.min(ans, e + minw[ind]);
            }

            if(ind+1 < m){
                ans = Math.min(ans, minew[ind+1]);
            }
        }

        for(Slide slide : water){
            int start =0;
            int end = n-1;
            int e = slide.end;
            int ind = -1;
            while(start <= end){
                int mid = (start + end)/2;
                if(land[mid].start >= e){
                    end = mid -1;
                }else{
                    ind = mid;
                    start = mid + 1;
                }
            }

            if(ind != -1){
                ans = Math.min(ans, e + minl[ind]);
            }

            if(ind+1 < n){
                ans = Math.min(ans, minel[ind+1]);
            }
        }

        return ans;

    }

    private int[] minDuration(Slide slide[]){
        int n= slide.length;
        int min[] = new int[n];

        min[0] = slide[0].duration;

        for(int i=1;i<n;i++){
            min[i] = Math.min(min[i-1], slide[i].duration);
        }

        return min;
    }

    private int[] minEnd(Slide slide[]){
        int n = slide.length;
        int min[] = new int[n];

        min[n-1] = slide[n-1].end;
        for(int i=n-2;i>=0;i--){
            min[i] = Math.min(min[i+1], slide[i].end);
        }

        return min;
    }

    class Slide{
        int start;
        int end;
        int duration;
        public Slide(int start, int end, int duration){
            this.start = start;
            this.end = end;
            this.duration = duration;
        }
    }
}