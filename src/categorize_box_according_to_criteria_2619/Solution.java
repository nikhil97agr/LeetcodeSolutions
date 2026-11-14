package categorize_box_according_to_criteria_2619;

class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false;
        boolean heavy = false;
        if(length>=10000 || width >= 10000 || height>=10000){
            bulky = true;
        }
        long vol = (long)length * (long)width *(long)height;
        if(vol>=1000000000){
            bulky = true;
        }
        
        if(mass>=100){
            heavy = true;
        }
        
        return bulky&&heavy ? "Both" : (!bulky && !heavy? "Neither" : (bulky ?  "Bulky" : "Heavy")) ;
    }
}