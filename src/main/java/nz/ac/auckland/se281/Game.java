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

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    difficultyLevel = DifficultyLevelFactory.creaDifficultyLevel(difficulty);
  }

  public void play() {
    boolean askingLoop = true;
    int fingerInputVal = 0;
    List<Integer> previousGuesses = new ArrayList<Integer>();
    int computerGuess = 0;

    gameCount++;
    MessageCli.START_ROUND.printMessage(String.valueOf(gameCount));
    MessageCli.ASK_INPUT.printMessage();
    
    while (askingLoop) {
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

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingerInputVal));

    computerGuess = difficultyLevel.computerGuess(previousGuesses);

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingerInputVal));
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(computerGuess));
  }

  public void endGame() {}

  public void showStats() {}
}
