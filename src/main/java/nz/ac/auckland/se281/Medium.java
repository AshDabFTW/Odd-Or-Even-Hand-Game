package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Medium implements DifficultyLevel{
  private Strategy strategy;

  public Medium(){
    strategy = new Random();
    return;
  }

  @Override
  public int computerGuess(List<Choice> previousGuesses) {
    if (previousGuesses.size() == 4) {
      this.setStrategy(new Top());
    }
    return strategy.computerGuess(previousGuesses);
  }

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
  
}
