package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This sets up the top strategy which uses the previous human guesses to predict what the player
 * will guess to make a guess that would win.
 */
public class Top implements Strategy {

  // method that will make the guess
  @Override
  public int computerGuess(List<Choice> previousHumanGuesses, Choice choice) {
    // initialising values.
    int evenCount = 0;
    double evenPercentage;
    Choice nextHumanChoice;

    // for loop to count how many human guesses have been even.
    for (int i = 0; i < previousHumanGuesses.size() - 1; i++) {
      if (previousHumanGuesses.get(i).equals(Choice.EVEN)) {
        evenCount++;
      }
    }

    // calculates the percentage of guesses that have been even.
    evenPercentage = ((double) evenCount / (double) (previousHumanGuesses.size() - 1)) * 100;

    // based on percentage of previous even guesses predicts next human guess otherwise produces
    // random output.
    if (evenPercentage > 50) {
      nextHumanChoice = Choice.EVEN;
    } else if (evenPercentage < 50) {
      nextHumanChoice = Choice.ODD;
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }

    // outputs a winning guess based on the human guess prediction and the odd or even choice goal.
    if (nextHumanChoice.equals(choice)) {
      return Utils.getRandomOddNumber();
    } else {
      return Utils.getRandomEvenNumber();
    }
  }
}
