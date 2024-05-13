package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Random implements Strategy {

  @Override
  public int computerGuess(List<Choice> previousGuesses, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
