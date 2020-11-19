package bullscows;

import java.text.DateFormatSymbols;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private StringBuilder preparedString = new StringBuilder();
    private int roundCount;
    private Scanner scanner = new Scanner(System.in);

    private int codeLength;
    private int symbolCount;

    private int bulls;
    private int cows;

    private boolean gameWon;

    private final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyz";
    private final int MAX_SYMBOLS = 36;

    public Game() {
        this.roundCount = 1;
        this.gameWon = false;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    private void setGameWon(boolean value) {
        this.gameWon = value;

        System.out.println("Congratulations! You guessed the secret code.");
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void prepareGame() {
        askCodeLength();
        askSymbolCount();
        announceCodeCreation();
        createCode();
    }

    private void askCodeLength() {
        System.out.println("Input the length of the secret code:");
        int input = checkInputIsInt();

        if (input <= 0 || input > 36) {
            System.out.println("Error: The code can be between 1 and 36 characters long.");
            System.exit(1);
        }
        codeLength = input;
    }

    private void askSymbolCount() {
        System.out.println("Input the number of possible symbols in the code:");
        int input = checkInputIsInt();

        if (input < codeLength) {
            System.out.println("Error: It is not possible to generate a code with a length of " + codeLength
                    + " with " + input + " unique symbols.");
            System.exit(1);
        } else if (input > 36) {
            System.out.println("Error: Maximum number of possible symbols in the code is " + MAX_SYMBOLS + ".");
            System.exit(1);
        }
        symbolCount = input;
    }

    private int checkInputIsInt() {
        String inputString = scanner.next();
        try {
            Integer.parseInt(inputString);
        } catch (Exception e) {
            System.out.println("Error: \"" + inputString + "\" isn't a valid number.");
            System.exit(1);
        }

        return Integer.parseInt(inputString);
    }


    private void announceCodeCreation() {
        System.out.print("The secret code is prepared: ");
        for (int j = 0; j < codeLength; j++) {
            System.out.print("*");
        }
        System.out.print(" ");
        if (symbolCount <= 10) {
            System.out.println("(0-" + SYMBOLS.charAt(symbolCount - 1) + ").");
        } else {
            System.out.println("(0-9, a-" + SYMBOLS.charAt(symbolCount - 1) + ").");
        }
    }


    private void createCode() {
        int i = 0;
        Random rand = new Random();

        while (i < codeLength) {
            char symbol = SYMBOLS.charAt(rand.nextInt(symbolCount));
            if (preparedString.indexOf(Character.toString(symbol)) == -1) {
                preparedString.append(symbol);
                i++;
            }
        }
    }

    public void playRound(String guessString) {
        bulls = cows = 0;                                               // resetting the bulls/cows counter

        for (int i = 0; i < codeLength; i++) {
            char guessSymbol = guessString.charAt(i);
            char preparedSymbol = preparedString.charAt(i);
            if (guessSymbol == preparedSymbol) {
                bulls++;
                continue;
            }
            for (int j = 0; j < codeLength; j++) {
                preparedSymbol = preparedString.charAt(j);
                if ((guessSymbol == preparedSymbol) && (i != j)) {
                    cows++;
                    continue;
                }
            }
        }
        if (bulls == codeLength) {
            setGameWon(true);
        }
        printBullsCows();
    }

    private void printBullsCows() {
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