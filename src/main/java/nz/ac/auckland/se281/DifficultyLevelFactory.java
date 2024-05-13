package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/** This class creates on instance of a difficulty level based on the input difficulty enum. */
public class DifficultyLevelFactory {
  // This static method creates on instance of a difficulty level based on the input difficulty
  // enum.
  public static DifficultyLevel creaDifficultyLevel(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new Easy();
      case MEDIUM:
        return new Medium();
      case HARD:
        return new Hard();
      default:
        return null;
    }
  }
}
