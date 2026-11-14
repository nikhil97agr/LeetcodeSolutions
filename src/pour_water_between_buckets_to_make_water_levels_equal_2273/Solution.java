package pour_water_between_buckets_to_make_water_levels_equal_2273;

class Solution {
    public double equalizeWater(int[] buckets, int loss) {
        double ans = 0d;
        double start = 0d;
        double end= 100000d;
        while(end - start > 0.00001){
            double mid = (start+end)/2;
            double req = 0;
            double exist = 0;
            for(double b : buckets){
                if( b >= mid ){
                    exist += (b - mid);
                }else{
                    req += (mid - b);
                }
            }

            double left = exist - (exist*loss)/100;

            if(left >= req){
                ans = mid;
                start = mid;
            }else{
                end = mid;
            }
        }

        return ans;
    }
}