package nz.ac.auckland.se281;

import java.util.List;
import java.util.ArrayList;

public class Easy implements DifficultyLevel{
  private Strategy strategy;

  public Easy(){
    strategy = new Random();
    return;
  }

  public int computerGuess(List<Integer> previousGuesses){
    return strategy.computerGuess(previousGuesses);
  }
}
