package nz.ac.auckland.se281;

import java.util.List;

public class Random implements Strategy{

  @Override
  public int computerGuess(List<Integer> previousGuesses) {
    return Utils.getRandomNumberRange(0, 5);
  }
  
}
