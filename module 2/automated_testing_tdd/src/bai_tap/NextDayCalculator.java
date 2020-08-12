package bai_tap;

public class NextDayCalculator {

    public static final int FEB = 2;
    public static final int APR = 4;
    public static final int JUN = 6;
    public static final int SEP = 9;
    public static final int NOV = 11;

    public static String NextDayCalculator(int day, int month, int year) {
        int lastDay = getLastDay(month, year);
        boolean isLastMonth = month == 12;
        boolean isLastDay = day == lastDay;
        if (isLastDay) {
            day = 1;
            if (isLastMonth) {
                month = 1;
                year++;
            } else month++;
        } else day++;
        String dayStr = String.valueOf(day);
        String monthStr = String.valueOf(month);
        String yearStr = String.valueOf(year);
        return dayStr + '.' + monthStr + '.' + yearStr;
    }

    public static boolean isLeapYear(int year) {
        boolean isDividedBy400 = year % 400 == 0;
        boolean isDividedBy100 = year % 100 == 0;
        boolean isDividedBy4 = year % 4 == 0;
        return isDividedBy400 || isDividedBy4 && !isDividedBy100;
    }

    public static int getLastDay(int month, int year) {
        boolean isLeapYear = isLeapYear(year);
        switch (month) {
            case FEB:
                return isLeapYear ? 29 : 28;
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
