package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This sets up the medium difficulty level implementing a random strategy that will switch to top
 * strategy in the forth round.
 */
public class Medium implements DifficultyLevel {
  // initialise strategy type
  private Strategy strategy;

  // setting up constructor with random strategy type
  public Medium() {
    strategy = new Random();
    return;
  }

  // method to call computerguess in strategy class for the selected strategy and will change to top
  // strategy in forth round
  @Override
  public int computerGuess(
      List<Choice> previousHumanGuesses, Choice choice, boolean playerWonPreviousGame) {
    // if it is in game 4, change strategy to top strategy
    if (previousHumanGuesses.size() == 4) {
      this.setStrategy(new Top());
    }
    return strategy.computerGuess(previousHumanGuesses, choice);
  }

  // method to set strategy
  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
