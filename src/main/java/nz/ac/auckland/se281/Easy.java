package nz.ac.auckland.se281;

import java.util.List;

public class Easy implements DifficultyLevel{
  private Strategy strategy;

  public Easy(){
    strategy = new Random();
    return;
  }

  public void setStrategy (Strategy strategy) {
    this.strategy = strategy;
  }

  public int computerGuess(List<Integer> previousGuesses){
    return strategy.computerGuess(previousGuesses);
  }
}
