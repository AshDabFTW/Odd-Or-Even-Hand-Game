package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // itialises variable fields for class to be used by all methods.
  private int gameCount;
  private String playerName;
  private DifficultyLevel difficultyLevel;
  private List<Choice> previousHumanGuesses;
  private Choice choice;
  private boolean gameMade = false;
  private int playerWins;
  private int compWins;

  /**
   * method which is ran whenever a new game is run and defines the variable fields.
   *
   * @param difficulty difficulty enum selected by user.
   * @param choice odd or even choice selected by user.
   * @param options features player name.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    gameMade = true;
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    difficultyLevel = DifficultyLevelFactory.creaDifficultyLevel(difficulty);
    previousHumanGuesses = new ArrayList<Choice>();
    this.choice = choice;
    gameCount = 0;
    playerWins = 0;
    compWins = 0;
  }

  /** Method which is run everytime the player runs the play command to play against computer. */
  public void play() {
    // initialise values
    boolean askingLoop = true;
    int fingerInputVal = 0;
    int computerGuess;
    int sum;
    Choice sumOddOrEven;
    boolean playerWonPreviousGame = true;

    // check if a game has been made otherwise print error message.
    if (!gameMade) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // print the current game number.
    gameCount++;
    MessageCli.START_ROUND.printMessage(String.valueOf(gameCount));

    // gets a valid guess from the human player.
    while (askingLoop) {
      MessageCli.ASK_INPUT.printMessage();
      String fingerInput = Utils.scanner.nextLine();
      if (!Utils.isInteger(fingerInput)) {
        MessageCli.INVALID_INPUT.printMessage();
      } else {
        fingerInputVal = Integer.valueOf(fingerInput.trim());
        if (fingerInputVal > 5 || fingerInputVal < 0) {
          MessageCli.INVALID_INPUT.printMessage();
        } else {
          askingLoop = false;
        }
      }
    }

    // adds even or odd guesse to previous guess array list.
    previousHumanGuesses.add(convertNumToEvenOrOdd(fingerInputVal));

    // get the computer hand guess.
    computerGuess =
        difficultyLevel.computerGuess(previousHumanGuesses, choice, playerWonPreviousGame);

    // Prints the player and computer hand.
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingerInputVal));
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(computerGuess));

    // calculates sum.
    sum = fingerInputVal + computerGuess;

    // checks if sum is even or odd.
    sumOddOrEven = convertNumToEvenOrOdd(sum);

    // checks if sum matches choice and prints who won the round.
    if (sumOddOrEven.equals(choice)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          String.valueOf(sum), sumOddOrEven.name(), playerName);
      playerWonPreviousGame = true;
      playerWins++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          String.valueOf(sum), sumOddOrEven.name(), "HAL-9000");
      playerWonPreviousGame = false;
      compWins++;
    }
  }

  /** method that converts a number to Even or Odd choice enum type. */
  public Choice convertNumToEvenOrOdd(int value) {
    if (Utils.isEven(value)) {
      return Choice.EVEN;
    } else {
      return Choice.ODD;
    }
  }

  /** method that will run everytime the player wanted to end their current game. */
  public void endGame() {
    // firstly checks to see if a game was made in the first place.
    if (!gameMade) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // will use showStats method to show final stats of game.
    showStats();

    // displays the winner's name.
    if (playerWins > compWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (compWins > playerWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // finally sets the boolean value to false when no game is running
    gameMade = false;
  }

  /** method that can show the user the current stats of the game. */
  public void showStats() {
    // checks if a game has been made
    if (!gameMade) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // prints the stats of each of player
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.valueOf(playerWins), String.valueOf(gameCount - playerWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(compWins), String.valueOf(gameCount - compWins));
  }
}
