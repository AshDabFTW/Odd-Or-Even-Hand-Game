package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class Hard implements DifficultyLevel{
  private Strategy strategy;

  public Hard(){
    strategy = new Random();
    return;
  }

  @Override
  public int computerGuess(List<Choice> previousHumanGuesses, Choice choice, boolean playerWonPreviousGame) {
    if (previousHumanGuesses.size() == 4) {
      this.setStrategy(new Top());
    } else if (previousHumanGuesses.size() > 4 && playerWonPreviousGame == false) {
      if (strategy instanceof Top) {
        setStrategy(new Random());
      } else {
        setStrategy(new Top());
      }
    }
    return strategy.computerGuess(previousHumanGuesses, choice);
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
  
}
