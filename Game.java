/**
 * Main class of the game.
 * This class `Game` handles are the opeations necessary for the successfull
 * exectution of the game.
 * @author 124k3
 * @version 1.0
 *
 */

import java.util.Random;
import java.util.Scanner;

public class Game {

    private static int chances;
    private int targetRandomNumber;

    public Game(int chances, int targetRandomNumber) {
        this.chances = chances;
        this.targetRandomNumber = targetRandomNumber;
    }

    public static int getChances() {
        return chances;
    }

    public static void setChance(int chances) {
        Game.chances = chances;
    }

    public int getTargetRandomNumber() {
        return targetRandomNumber;
    }

    public static void main(String[] args) {
        AsciiArt asciiArt = new AsciiArt();
        System.out.println(asciiArt.getAsciiArt());

        GameUI gameUI = new GameUI();
        System.out.println(gameUI.getWelcomeMessage());
        System.out.println(gameUI.getGameRules());
        System.out.println(gameUI.getDifficultyMessage());

        GameLogic gameLogic = new GameLogic();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int difficultyLevel = gameLogic.getValidIntInput(
            scanner,
            "Enter Your Choice: ",
            "\t~Invalid Choice, Try Again!"
        );
        System.out.println(gameUI.getSelectedDifficultyStatus(difficultyLevel));
        Game game = new Game(
            gameLogic.getChances(difficultyLevel),
            gameLogic.getRandomNumber(random, 0, 100)
        );

        while (game.getChances() != 0 && !gameLogic.getStopGame()) {
            int inputGuess = gameLogic.getValidIntInput(
                scanner,
                "Enter your guess: ",
                "Bruh! only use number's"
            );
            System.out.println(
                gameLogic.guessMessage(
                    inputGuess,
                    game.targetRandomNumber,
                    chances
                )
            );
        }
    }
}
