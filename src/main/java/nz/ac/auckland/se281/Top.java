package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Top implements Strategy{

  @Override
  public int computerGuess(List<Choice> previousGuesses, Choice choice) {
    int evenCount = 0;
    double evenPercentage;
    Choice nextChoice;

    for (Choice pastChoice : previousGuesses){
      if (pastChoice.equals(Choice.EVEN)) {
        evenCount++;
      }
    }

    evenPercentage = (evenCount / previousGuesses.size()) * 100;

    if (evenPercentage > 50) { 
      nextChoice = Choice.EVEN;
    }

    return 0;
  }
  
}
