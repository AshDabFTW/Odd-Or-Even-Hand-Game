package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Easy implements DifficultyLevel {
  // initialise strategy type
  private Strategy strategy;

  // setting up constructor with random strategy type
  public Easy() {
    strategy = new Random();
    return;
  }

  // method to set strategy
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  // method to call computerguess in strategy class for the selected strategy
  public int computerGuess(
      List<Choice> previousGuesses, Choice choice, boolean playerWonPreviousGame) {
    return strategy.computerGuess(previousGuesses, choice);
  }
}
