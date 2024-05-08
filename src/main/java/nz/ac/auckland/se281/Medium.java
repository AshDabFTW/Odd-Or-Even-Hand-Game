package nz.ac.auckland.se281;

import java.util.List;

public class Medium implements DifficultyLevel{
  private Strategy strategy;

  public Medium(){
    strategy = new Random();
    return;
  }

  @Override
  public int computerGuess(List<Integer> previousGuesses) {
    return strategy.computerGuess(previousGuesses);
  }

  @Override
  public void setStrategy(Strategy strategy) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setStrategy'");
  }
  
}
