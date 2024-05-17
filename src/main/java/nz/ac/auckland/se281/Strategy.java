package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** This an interface to set up the top and random strategies to give a computer guess. */
public interface Strategy {
  // method that takes in list of previous guesses and the choice to output a computer guess.
  int computerGuess(List<Choice> previousHumanGuesses, Choice choice);
}
