package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This sets up the hard difficulty level implementing a random strategy that will, after the forth
 * round, switch strategy if it has lost the previous round.
 */
public class Hard implements DifficultyLevel {
  // initialise strategy types
  private Strategy currentStrategy;
  private Strategy topStrategy = new Top();
  private Strategy randomStrategy = new Random();

  // setting up constructor with random strategy type
  public Hard() {
    currentStrategy = randomStrategy;
    return;
  }

  // method to call computerguess in strategy class for the selected strategy and will switch
  // strategy if it has lost the previous round after the forth round
  @Override
  public int computerGuess(
      List<Choice> previousHumanGuesses, Choice choice, boolean playerWonPreviousGame) {
    // if more than 3 games played, it will switch strategy if lost previous game
    if ((previousHumanGuesses.size() >= 4) && (playerWonPreviousGame)) {
      if (currentStrategy.equals(topStrategy)) {
        setStrategy(randomStrategy);
      } else {
        setStrategy(topStrategy);
      }
    }
    // run strategy to get computer guess
    return currentStrategy.computerGuess(previousHumanGuesses, choice);
  }

  // method to set strategy
  @Override
  public void setStrategy(Strategy strategy) {
    currentStrategy = strategy;
  }
}
