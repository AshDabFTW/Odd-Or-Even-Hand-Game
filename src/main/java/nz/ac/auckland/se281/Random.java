package nz.ac.auckland.se281;
import java.util.ArrayList;

public class Random implements Strategy{

  @Override
  public int computerGuess(ArrayList<Integer> previousGuesses) {
    return Utils.getRandomNumberRange(0, 5);
  }
  
}
