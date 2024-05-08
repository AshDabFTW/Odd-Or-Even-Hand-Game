package nz.ac.auckland.se281;
import java.util.ArrayList;
import java.util.List;

public interface Strategy {
  int computerGuess(List<Integer> previousGuesses);
}
