import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] stats = input.split("[=&?]");

        String existsPass = new String();

        for (int i = 1; i < stats.length - 1; i += 2) {
            if (existsPass.length() == 0) {
                existsPass = printValue(stats[i], stats[i + 1]);
            } else {
                printValue(stats[i], stats[i + 1]);
            }
        }

        if (existsPass.length() > 0) {
            printValue("password", existsPass);
        }




    }

    private static String printValue(String stat, String stat1) {
        if (stat1.length() == 0) {
            System.out.println(stat + " : " + "not found");
        } else {
            System.out.println(stat + " : " + stat1);
            if (stat.compareTo("pass") == 0) {
                return stat1;
            }
        }
        return "";
    }
}