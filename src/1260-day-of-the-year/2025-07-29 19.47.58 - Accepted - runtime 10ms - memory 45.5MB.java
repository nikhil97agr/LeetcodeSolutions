class Solution {
    public int dayOfYear(String date) {
        int days[] = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

        String d[] = date.split("-");
        int year = Integer.parseInt(d[0]);

        if((year%100 ==0 && year%400==0) || (year%100 !=0 && year%4==0)){
            days[1] = 29;
        }

        int month = Integer.parseInt(d[1]);
        int day = 0;

        for(int i=0;i<month - 1;i++) day += days[i];

        return day + Integer.parseInt(d[2]);
    }
}