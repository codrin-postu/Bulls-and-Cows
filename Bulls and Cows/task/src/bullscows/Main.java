package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game bullsAndCows = new Game();
        bullsAndCows.prepareGame();

        System.out.println("Okay, let's start a game!");
        while (!bullsAndCows.isGameWon()) {
            bullsAndCows.playRound(getGuess(bullsAndCows));
        }
    }

    private static String getGuess(Game game) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.length() != game.getCodeLength()) {
            System.out.println("Error: \"" + input + "\" is not a valid code");
            System.exit(1);
        }
        return input;

    }
}
