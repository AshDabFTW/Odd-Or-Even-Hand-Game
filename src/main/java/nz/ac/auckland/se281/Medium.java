package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Medium implements DifficultyLevel {
  // initialise strategy type
  private Strategy strategy;

  // setting up constructor with random strategy type
  public Medium() {
    strategy = new Random();
    return;
  }

  // method to call computerguess in strategy class for the selected strategy
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
