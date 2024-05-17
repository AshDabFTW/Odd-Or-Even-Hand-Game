package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** This sets up the random strategy to output a random guess no matter previous guesses. */
public class Random implements Strategy {

  // method that output random value as a guess.
  @Override
  public int computerGuess(List<Choice> previousHumanGuesses, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
