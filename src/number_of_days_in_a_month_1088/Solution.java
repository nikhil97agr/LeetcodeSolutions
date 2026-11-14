package number_of_days_in_a_month_1088;

class Solution {
    public int numberOfDays(int year, int month) {
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
            return 31;
            case 4:
            case 6:
            case 9:
            case 11:
            return 30;
            default:
            if(year%4==0){
                if(year%100!=0){
                    return 29;
                }else{
                    if(year%400==0) return 29;
                    return 28;
                }
            }else{
                return 28;
            }
        }
    }
}