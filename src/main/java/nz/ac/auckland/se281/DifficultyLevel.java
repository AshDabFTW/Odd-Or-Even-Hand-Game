package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This is the interface for each difficulty level where they can get a computer guess from the
 * chosen strategy and change strategy
 */
public interface DifficultyLevel {
  public int computerGuess(
      List<Choice> previousHumanGuesses, Choice choice, boolean playerWonPreviousGame);

  public void setStrategy(Strategy strategy);
}
