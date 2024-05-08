package nz.ac;
import java.util.ArrayList;
import nz.ac.auckland.se281.Utils;

public class Random implements Strategy{

  @Override
  public int computerGuess(ArrayList<Integer> previousGuesses) {
    return Utils.getRandomNumberRange(0, 5);
  }
  
}
