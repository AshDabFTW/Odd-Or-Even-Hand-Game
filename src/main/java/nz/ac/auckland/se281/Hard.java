package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class Hard implements DifficultyLevel{
  private Strategy currentStrategy;
  private Strategy topStrategy = new Top();
  private Strategy randomStrategy = new Random();

  public Hard(){
    currentStrategy = randomStrategy;
    return;
  }

  @Override
  public int computerGuess(List<Choice> previousHumanGuesses, Choice choice, boolean playerWonPreviousGame) {
    if ((previousHumanGuesses.size() >= 4) && (playerWonPreviousGame)) {
      if (currentStrategy instanceof Top) {
        setStrategy(randomStrategy);
      } else {
        setStrategy(topStrategy);
      }
    }
    return currentStrategy.computerGuess(previousHumanGuesses, choice);
  }

  @Override
  public void setStrategy(Strategy strategy) {
    currentStrategy = strategy;
  }
  
}
