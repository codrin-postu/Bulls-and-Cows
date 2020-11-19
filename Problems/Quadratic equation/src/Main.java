import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double[] results = new double[2];

        results[0] = (- b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        results[1] = (- b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);

        if (results[0] > results[1]) {
            System.out.println(results[1] + " " + results[0]);
        } else {
            System.out.println(results[0] + " " + results[1]);
        }
    }
}