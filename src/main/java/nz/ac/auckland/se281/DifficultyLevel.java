package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public interface DifficultyLevel {

  public int computerGuess(List<Choice> previousHumanGuesses, Choice choice);
  public void setStrategy (Strategy strategy);
}

