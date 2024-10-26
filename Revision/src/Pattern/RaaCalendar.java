package Pattern;

public class RaaCalendar {

    
    static int[] dim = {36, 39, 26, 29, 31, 29, 33, 34, 35, 27, 43};
    static String[] monthNames = {"Ra", "Ta", "Ut", "Ip", "Ok", "Py", "Ar", "Sy", "Du", "Fi", "Gr"};
    static String[] weekDays = {"Za", "Xo", "Cu", "Vo", "Bi", "Ne", "Ma", "Lu", "Ki"};

    public static void main(String[] args) {
        PrintNMonths(2618, 9, 4); // Example call based on your provided data
    }

    public static void PrintNMonths(int startYear, int startMonth, int numberOfMonths) {
        int monthIndex = startMonth - 1; // Convert to 0-based index
        for (int i = 0; i < numberOfMonths; i++) {
            int currentMonth = (monthIndex + i) % 11;
            int currentYear = startYear + (monthIndex + i) / 11;
            PrintMonth(currentYear, currentMonth);
            System.out.println(); // Add spacing between months
        }
    }

    // Print a single month's calendar
    public static void PrintMonth(int year, int month) {
        int days = GetDaysInMonth(year, month);
        int startDay = MonthStartsOn(month, year);

        // Print header for the month
        PrintMonthHeader(month, year);

        // Print week day names
        PrintWeekDays();

        // Print the calendar days
        PrintMonthDays(days, startDay);

        // Closing line for the calendar
        PrintCalendarFooter();
    }

    // Get the number of days in a month, considering leap year adjustments
    public static int GetDaysInMonth(int year, int month) {
        int days = dim[month];

        // Adjust for the removed day every 11 years
        if (month == 8 && year % 11 == 0) {
            days--;
        }

        // Adjust for the added day every 297 months
        int monthsSince = (year * 11 + month);
        if (month == 1 && monthsSince % 297 == 0) {
            days++;
        }

        return days;
    }

    // Print header for a specific month
    public static void PrintMonthHeader(int month, int year) {
        System.out.printf("+-------------------------- %s %d --------------------------+\n", monthNames[month], year);
    }

    // Print the names of the days of the week
    public static void PrintWeekDays() {
        System.out.print("| ");
        for (int i = 0; i < weekDays.length; i++) {
            System.out.printf("%3s ", weekDays[i]);
        }
        System.out.println("|");
        System.out.println("+-----------------------------------------------------------+");
    }

    // Print the days of the month in the calendar format
    public static void PrintMonthDays(int days, int startDay) {
        System.out.print("| ");
        int dayOfWeek = startDay;

        // Print spaces for days before the start day
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print all days of the month
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);

            dayOfWeek++;
            if (dayOfWeek == 9) {
                dayOfWeek = 0;
                System.out.println("|");
                if (day != days) {
                    System.out.print("| ");
                }
            }
        }

        // Print trailing spaces if the last week is incomplete
        if (dayOfWeek != 0) {
            for (int i = dayOfWeek; i < 9; i++) {
                System.out.print("    ");
            }
            System.out.println("|");
        }
    }

    // Print footer for the calendar
    public static void PrintCalendarFooter() {
        System.out.println("+-----------------------------------------------------------+");
    }

    // Mock method for MonthStartsOn (replace with actual implementation)
    public static int MonthStartsOn(int monthNum, int year) {
        // Dummy implementation for now
        return (year + monthNum) % 9; // This should be based on real logic
    }
}
