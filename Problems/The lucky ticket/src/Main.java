import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.next());

        System.out.println(isLucky(number));
    }

    private static String isLucky(int number) {
        if (number / 100_000 + (number / 10_000) % 10 + (number / 1_000) % 10 ==
                number % 10 + (number / 10) % 10 + (number / 100) % 10) {
            return "Lucky";
        } else {
            return "Regular";
        }
    }
}