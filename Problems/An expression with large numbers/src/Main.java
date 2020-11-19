import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger result = BigInteger.ZERO;

        result = result.add(new BigInteger(scanner.next()));
        result = result.negate();
        result = result.multiply(new BigInteger(scanner.next()));
        result = result.add(new BigInteger(scanner.next()));
        result = result.subtract(new BigInteger(scanner.next()));

        System.out.println(result);
    }
}