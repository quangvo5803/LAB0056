package Common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Validation {
    static final Scanner sc = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();
        while (s.isEmpty()) {
            System.out.print("Enter again(Can not blank): ");
            s = sc.nextLine();
        }
        return s;
    }

    public static int getInt(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(prompt);
            if (i < min)
                System.out.println("Error! Number must be equal or greater  than " + min + ".");
            else if (i > max) {
                System.out.println("Error! Number must be equal or less than " + max + ".");
            } else
                isValid = true;
        }
        return i;
    }

    public static double getDouble(String prompt) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value.Try again");
            }
            sc.nextLine();
        }
        return d;
    }

    public static double getDouble(String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(prompt);
            if (d < min)
                System.out.println("Error! Number must be greater than " + min + ".");
            else if (d > max) {
                System.out.println("Error! Number must be less than " + max + ".");
            } else
                isValid = true;
        }
        return d;
    }

    public static String getYesNo(String str) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(str);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty() && (tmp.equalsIgnoreCase("Y") || tmp.equalsIgnoreCase("N"))) {
                result = tmp;
                check = false;
            } else {
                System.out.println("Enter the wrong type, please re-enter (Y/N)!");
            }

        } while (check);
        return result;
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
