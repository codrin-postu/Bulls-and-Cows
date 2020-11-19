import java.awt.desktop.SystemSleepEvent;
import java.math.BigInteger;
import java.text.BreakIterator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger input = new BigInteger(scanner.next());

        BigInteger factorialResult = BigInteger.ONE;

        BigInteger increment = BigInteger.ONE;

        long factorial = 1;

        while (factorialResult.compareTo(input) == -1) {
            factorial += 1;
            factorialResult = factorialResult.multiply(increment.valueOf(factorial));

        }

        System.out.println(factorial);
    }
}