package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int gameCount = 0;
  String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);

  }

  public void play() {
    boolean askingLoop = true;
    int fingerInputVal = 0;

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
        }
      }
    }

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingerInputVal));
  }

  public void endGame() {}

  public void showStats() {}
}
