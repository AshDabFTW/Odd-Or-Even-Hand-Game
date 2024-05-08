package nz.ac.auckland.se281;

public class Easy implements DifficultyLevel{
  private Strategy strategy;

  public Easy(){
    strategy = new Random();
    return;
  };
}
