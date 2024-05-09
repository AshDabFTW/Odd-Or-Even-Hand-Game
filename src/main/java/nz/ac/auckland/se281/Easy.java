package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Easy implements DifficultyLevel{
  private Strategy strategy;

  public Easy(){
    strategy = new Random();
    return;
  }

  public void setStrategy (Strategy strategy) {
    this.strategy = strategy;
  }

  public int computerGuess(List<Choice> previousGuesses, Choice choice, boolean playerWonPreviousGame){
    return strategy.computerGuess(previousGuesses, choice);
  }
}
