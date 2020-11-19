import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();

        Random random = new Random(k);

        for (int i = 0; i < n; i++) {
            double pseudorandom = random.nextGaussian();

            if(pseudorandom > m) {
                random = new Random(++k);
                i = -1;
            }
        }

        System.out.println(k);

    }
}