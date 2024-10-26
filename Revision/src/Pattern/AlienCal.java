package Pattern;

public class AlienCal {

    
    static int[] dim = {36, 39, 26, 29, 31, 29, 33, 34, 35, 27, 43};
    static String[] mn = {"Ra","Ta","Ut","Ip","Ok","Py","Ar","Sy","Du","Fi","Gr"};
    static String[] wd = {"Za","Xo","Cu","Vo","Bi","Ne","Ma","Lu","Ki"};

    public static int monStart(int monNum, int yr) {
        return (yr + monNum) % 9;
    }
    public static void PrintMonth(int year, int month) {
        int days = dayInMon(year, month);
        int dayStart = monStart(month, year);
        
        System.out.printf("+-------------- %s %d -----------------+\n", mn[month], year);
        

        System.out.print("  ");
        for (int i = 0; i < wd.length; i++) {
            System.out.printf("%2s| ", wd[i]);
        }
        System.out.println("|");
        System.out.println("+-------------------------------------------+");

        System.out.print("| ");
        int dow = dayStart;

        for (int i = 0; i < dayStart; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= days; day++) {
            System.out.printf("%2d| ", day);

            dow++;
            if (dow == 9) {
                dow = 0;
                System.out.println("|");
                if (day != days) {
                    System.out.print("| ");
                }
            }
        }
        
        if (dow != 0) {
            for (int i = dow; i < 9; i++) {
                System.out.print("    ");
            }
            System.out.println("|");
        }
    }

    public static int dayInMon(int year, int month) {
        int days = dim[month];
        if (month == 8 && year % 11 == 0) {
            days--;
        }
        
        int monTill = (year * 11 + month);
        if (month == 1 && monTill % 297 == 0) {
            days++;
        }

        return days;
    }
   
    public static void PrintNMonths(int startYear, int startMonth, int numberOfMonths) {
        int monLin = startMonth - 1;
        for (int i = 0; i < numberOfMonths; i++) {
            int cm = (monLin + i) % 11;
            int cy = startYear + (monLin + i) / 11;
            PrintMonth(cy, cm);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        PrintNMonths(2717, 9, 4); 
    }
}
