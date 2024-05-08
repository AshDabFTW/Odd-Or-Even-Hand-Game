package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int gameCount = 0;
  String playerName;
  DifficultyLevel difficultyLevel;
  List<Integer> previousGuesses = new ArrayList<Integer>();
  String choice;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    difficultyLevel = DifficultyLevelFactory.creaDifficultyLevel(difficulty);
    this.choice = choice.name();
  }

  public void play() {
    // initialise values
    boolean askingLoop = true;
    int fingerInputVal = 0;
    int computerGuess = 0;
    int sum = 0;
    String sumOddOrEven;

    // print the current game number
    gameCount++;
    MessageCli.START_ROUND.printMessage(String.valueOf(gameCount));
    
    // gets a valid guess from the human player
    while (askingLoop) {
      MessageCli.ASK_INPUT.printMessage();
      String fingerInput = Utils.scanner.nextLine();
      if (!Utils.isInteger(fingerInput)) {
        MessageCli.INVALID_INPUT.printMessage();
      }
      else {
        fingerInputVal = Integer.valueOf(fingerInput.trim());
        if (fingerInputVal > 5 || fingerInputVal < 0) {
          MessageCli.INVALID_INPUT.printMessage();
        }
        else {
          askingLoop = false;
          previousGuesses.add(fingerInputVal);
        }
      }
    }

    // print the player hand
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingerInputVal));

    // get the computer hand guess
    computerGuess = difficultyLevel.computerGuess(previousGuesses);

    // Prints the player and computer hand
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingerInputVal));
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(computerGuess));

    // calculates sum
    sum = fingerInputVal + computerGuess;

    // checks if sum is even or odd
    if (Utils.isEven(sum)) {
      sumOddOrEven = "EVEN";
    }
    else {
      sumOddOrEven = "ODD";
    }

    // checks if sum matches choice and prints who won the round
    if (sumOddOrEven.equals(choice)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), sumOddOrEven, playerName);
    }
    else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), sumOddOrEven, "HAL-9000"); 
    }
  }

  public void endGame() {}

  public void showStats() {}
}
