import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        getInput();

    }

    private static void getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = new String();

        while (!scanner.hasNext("0")) {
            input = scanner.next();
            try {
                convertToInteger(input);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + input);
            }
        }

    }

    private static void convertToInteger(String input) {
        int value = Integer.parseInt(input);

        System.out.println(value * 10);
    }
}