import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static Long doDateDifference(Date startDate, Date endDate) {

        long diff = endDate.getTime() - startDate.getTime();
        diff = diff / (1000L * 60L * 60L * 24L);
        return diff;
    }

    public static boolean isAWeekday(Date dt) {

        int day = dt.getDay();
        if (day == 0 || day == 6) {
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {

        findweekdays();
    }

    private static void findweekdays() {

        Scanner scanner = new Scanner(System.in);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Enter two date's , first start date, then end in the format yyyy-MM-dd");
        System.out.println("For example, it is now " + format.format(new Date()));
        Date startDate = null;
        Date endDate = null;
        do  {
                String date1 = scanner.nextLine();
                String date2 = scanner.nextLine();
            try {
                startDate = format.parse(date1);
                endDate = format.parse(date2);
                if ((doDateDifference(startDate,endDate))<0 ){
                    startDate = null;
                    endDate = null;
                    System.out.println("That's not valid, first start date, then end date");
                }
            } catch (ParseException e) {
                System.out.println("Sorry, that's not valid. Please try again.");
            }
        } while (startDate == null || endDate == null);
        ArrayList theList = new ArrayList();

        long len = doDateDifference(startDate, endDate);
        int i = 1;

        Calendar c = new GregorianCalendar();
        c.setTime(startDate);
        for (i = 1; i <= len; i++) {

            if (isAWeekday(getNextDay(c))) {
                theList.add(getNextDay(c));
                c = incrementCalendar(c);
            } else {
                c = incrementCalendar(c);
            }
        }
        for (int j = 0; j < theList.size(); j++)
            System.out.println(theList.get(j));
    }

    private static Calendar incrementCalendar(Calendar c) {

        c.add(Calendar.DATE, 1);
        return c;
    }

    private static Date getNextDay(Calendar c) {
        Date dt = c.getTime();
        return dt;
    }
}
