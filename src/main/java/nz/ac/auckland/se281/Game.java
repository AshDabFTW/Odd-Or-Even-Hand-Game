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
    gameCount++;
    MessageCli.START_ROUND.printMessage(String.valueOf(gameCount));
  }

  public void endGame() {}

  public void showStats() {}
}
