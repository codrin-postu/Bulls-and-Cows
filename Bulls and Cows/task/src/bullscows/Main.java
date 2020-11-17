package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the secret code's length:");
        int digits = scanner.nextInt();
        long preparedNumber = createSecretNumber(digits);

        System.out.println("Okay, let's start a game!");
        startGame(preparedNumber, digits);
    }

    private static void startGame(long preparedNumber, int digits) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int roundCount = 1;

        while (!gameWon) {
            System.out.println("Turn " + roundCount++ + ":");
            long guessNumber = scanner.nextLong();
            gameWon = bullsAndCows(preparedNumber, guessNumber, digits);
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

    private static long createSecretNumber(int digits) {
        if (digits > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }

        long pseudoRandomNumber = System.nanoTime();

        StringBuilder pseudoRandomString = new StringBuilder().append(pseudoRandomNumber);
        StringBuilder finalRandomString = new StringBuilder();

        for (int i = pseudoRandomString.length() - 1; i >= 0; i--) {
            char digit = pseudoRandomString.charAt(i);
            if (finalRandomString.length() == 0) {
                if (digit != '0' && Character.isDigit(digit)) {
                    finalRandomString.append(digit);
                }
            } else {
                if (Character.isDigit(digit) && finalRandomString.indexOf(String.valueOf(digit)) == -1) {
                    finalRandomString.append(digit);
                }
            }
            if (finalRandomString.length() == digits) {
                break;
            }
        }

        if (finalRandomString.length() < digits) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return 0;
        } else {
            return Long.parseLong(finalRandomString.toString());
        }
    }

    private static boolean bullsAndCows(long preparedNumber, long guess, int digits) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < digits; i++) {
            long guessDigit = guess / (int)Math.pow(10, i) % 10;
            long numDigit = preparedNumber / (int)Math.pow(10, i) % 10;
            if(guessDigit == numDigit) {
                bulls++;
                continue;
            }
            for (int j = 0; j < digits; j++) {
                numDigit = preparedNumber / (int)Math.pow(10, j) % 10;
                if ((guessDigit == numDigit) && (i != j)) {
                    cows++;
                    continue;
                }
            }
        }

        printBullsCows(preparedNumber, cows, bulls);
        if (bulls == digits) {
            return true;
        } else {
            return false;
        }
    }

    private static void printBullsCows(long preparedNumber, int cows, int bulls) {
        System.out.print("Grade: ");
        if (cows > 0 && bulls > 0) {
            System.out.println(bulls + " " + (bulls > 1 ? "bulls" : "bull")
                    +  " and " + cows + (cows > 1 ? "cows" : "cow"));
        } else if (cows > 0) {
            System.out.println(cows + " " + (cows > 1 ? "cows" : "cow"));
        } else if (bulls > 0){
            System.out.println(bulls + " " + (bulls > 1 ? "bulls" : "bull"));
        } else {
            System.out.println("None");
        }
    }
}
