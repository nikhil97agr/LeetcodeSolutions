package day_of_the_week_1289;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int months[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String dayName[] = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        int sum = 4;

        for(int i=1971;i<year;i++){
            sum+= 365;
            if(isLeap(i)){
                sum++;
            }

        }

        for(int i=1;i<month;i++){
            sum+= months[i];
            if(i==2 && isLeap(year)){
                sum++;
            }
        }

        sum+=day;
        return dayName[sum%7];

    }

    private boolean isLeap(int year){
        return year%400 ==0 || (year%4==0 && year%100!=0);
    }
}