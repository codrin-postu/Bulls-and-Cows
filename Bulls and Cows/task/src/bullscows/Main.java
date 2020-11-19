package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int roundCount = 1;

        int digits = getNumberLength();

        int symbolCount = getCharCount();

        String preparedString = createSecretString(digits, symbolCount);

        System.out.println("Okay, let's start a game!");
        while (!gameWon) {
            System.out.println("Turn " + roundCount++ + ":");
            String guessString = scanner.next();
            gameWon = bullsAndCows(preparedString, guessString, digits);
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

    private static int getCharCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the number of possible symbols in the code:");
        return scanner.nextInt();
    }

    private static int getNumberLength() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the length of the secret code:");
        return scanner.nextInt();
    }

    private static String createSecretString(int digits, int symbolCount) {

        String symbols = "0123456789abcdefghijklmnopqrstuvwxyz";

        if (digits > symbolCount) {
            System.out.println("Error: can't generate a secret number with a length of " + digits + " because there aren't enough unique symbols.");
        }

        if (symbolCount > symbols.length()) {
            System.out.println("Error: too many symbols");
        }

        StringBuilder finalRandomString = new StringBuilder();
        int i = 0;
        Random rand = new Random();

        System.out.print("The secret code is prepared: ");
        for (int j = 0; j < digits; j++) {
            System.out.print("*");
        }
        System.out.print(" ");
        if (symbolCount <= 10) {
            System.out.println("(0-" + symbols.charAt(symbolCount - 1) + ").");
        } else {
            System.out.println("(0-9, a-" + symbols.charAt(symbolCount - 1) + ").");
        }

        while (i < digits) {
            char symbol = symbols.charAt(rand.nextInt(symbolCount));
            if (finalRandomString.indexOf(Character.toString(symbol)) == -1) {
                finalRandomString.append(symbol);
                i++;
            }
        }

        return finalRandomString.toString();
    }

    private static boolean bullsAndCows(String preparedGuess, String guessString, int digits) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < digits; i++) {
            char guessSymbol = guessString.charAt(i);
            long preparedSymbol = preparedGuess.charAt(i);
            if (guessSymbol == preparedSymbol) {
                bulls++;
                continue;
            }
            for (int j = 0; j < digits; j++) {
                preparedSymbol = preparedGuess.charAt(j);
                if ((guessSymbol == preparedSymbol) && (i != j)) {
                    cows++;
                    continue;
                }
            }
        }

        printBullsCows(preparedGuess, cows, bulls);
        if (bulls == digits) {
            return true;
        } else {
            return false;
        }
    }

    private static void printBullsCows(String preparedNumber, int cows, int bulls) {
        System.out.print("Grade: ");
        if (cows > 0 && bulls > 0) {
            System.out.println(bulls + " " + (bulls > 1 ? "bulls" : "bull")
                    + " and " + cows + (cows > 1 ? "cows" : "cow"));
        } else if (cows > 0) {
            System.out.println(cows + " " + (cows > 1 ? "cows" : "cow"));
        } else if (bulls > 0) {
            System.out.println(bulls + " " + (bulls > 1 ? "bulls" : "bull"));
        } else {
            System.out.println("None");
        }
    }
}
