package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Top implements Strategy {

  @Override
  public int computerGuess(List<Choice> previousGuesses, Choice choice) {
    int evenCount = 0;
    double evenPercentage;
    Choice nextHumanChoice;

    previousGuesses.remove(previousGuesses.size() - 1);

    for (Choice pastChoice : previousGuesses) {
      if (pastChoice.equals(Choice.EVEN)) {
        evenCount++;
      }
    }

    evenPercentage = ((double) evenCount / (double) previousGuesses.size()) * 100;

    if (evenPercentage > 50) {
      nextHumanChoice = Choice.EVEN;
    } else if (evenPercentage < 50) {
      nextHumanChoice = Choice.ODD;
    } else {
      return Utils.getRandomNumberRange(0, 5);
    }

    if (nextHumanChoice.equals(choice)) {
      return Utils.getRandomOddNumber();
    } else {
      return Utils.getRandomEvenNumber();
    }
  }
}
