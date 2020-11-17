import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        String modified = new String();
        int n = scanner.nextInt();

        if(n > input.length()) {
            System.out.println(input);
        } else {
            modified += input.substring(n,input.length());
            modified += input.substring(0,n);
            System.out.println(modified);
        }
    }
}