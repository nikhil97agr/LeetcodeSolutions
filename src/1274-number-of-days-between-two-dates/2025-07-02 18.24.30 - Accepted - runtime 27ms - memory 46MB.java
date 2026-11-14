import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class Solution {
    public int daysBetweenDates(String date1, String date2)  {
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(date1);
            Date end = format.parse(date2);

            if(start.compareTo(end) > 0){
                return daysBetweenDates(date2, date1);
            }

            long diff = end.getTime() - start.getTime();

            return (int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }catch(ParseException ex){
            return 0;
        }

    }
}