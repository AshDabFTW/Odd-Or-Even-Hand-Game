package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int gameCount = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    boolean askingLoop = true;
    int fingerInputVal;

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
  }

  public void endGame() {}

  public void showStats() {}
}
