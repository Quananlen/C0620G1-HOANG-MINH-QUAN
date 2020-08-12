package bai_tap;

public class NextDayCalculator {

    public static final int FEB = 2;
    public static final int APR = 4;
    public static final int JUN = 6;
    public static final int SEP = 9;
    public static final int NOV = 11;

    public static String NextDayCalculator(int day, int month, int year) {
        String result = "";
        int lastDay = getLastDay(month, year);
        int newDay;
        int newMonth = month;
        int newYear = year;
        boolean isLastMonth = month == 12;
        boolean isLastDay = day == lastDay;
        if (isLastDay) {
            newDay = 1;
            if (isLastMonth) {
                newMonth = 1;
                newYear = year + 1;
            } else {
                newMonth = month + 1;
            }
        } else {
            newDay = day + 1;
        }
        String dayStr = String.valueOf(newDay);
        String monthStr = String.valueOf(newMonth);
        String yearStr = String.valueOf(newYear);
        return dayStr + '.' + monthStr + '.' + yearStr;
    }

    public static boolean isLeapYear(int year) {
        boolean isDividedBy400 = year % 400 == 0;
        boolean isDividedBy100 = year % 100 == 0;
        boolean isDividedBy4 = year % 4 == 0;
        if (isDividedBy400) return true;
        return isDividedBy4 && !isDividedBy100;
    }

    public static int getLastDay(int month, int year) {
        boolean isLeapYear = isLeapYear(year);
        switch (month) {
            case FEB:
                if (isLeapYear) return 29;
                else return 28;
            case APR:
            case JUN:
            case SEP:
            case NOV:
                return 30;
            default:
                return 31;
        }
    }
}
