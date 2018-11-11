// All input output
import java.util.Scanner; //Allows access to class name Scanner

public class Prompter {
  private Game game;

  public Prompter(Game game) { //Calling Game.java code
    this.game = game; //this. stops name conflict
  }

  //prompt for guess and return if guess was right or not
  public boolean promptForGuess() {
    Scanner scanner = new Scanner(System.in); //Where is input coming from? Lot of methods to help read input
    boolean isHit = false;
    boolean isAcceptable = false;

    do { //get input, pull off input, returns String we must use charAt()
      System.out.print("Enter a letter:  ");
      String guessInput = scanner.nextLine();//nextLine() read a line

      //char guess = guessInput.charAt(0);//Pulling first letter of guess

      try { //takes guess and normalizes guess
        isHit = game.applyGuess(guessInput);//returns a true or flase from guess correct letter or not
        isAcceptable = true;
      }catch(IllegalArgumentException iae) {
        System.out.printf("%s. Please try agian. %n",
                          iae.getMessage());
      }
    } while (! isAcceptable);
      return isHit;

  }

  public void displayProgress() {
    System.out.printf("You have %d tries left to solve: %s%n",
                      game.getRemainingTries(),
                      game.getCurrentProgress());
  }

  public void displayOutCome() {
    if (game.isWon()) {
      System.out.printf("Congrats you had %d tries left",
                        game.getRemainingTries());
    } else {
      System.out.printf("Bummer the word was %s. :( %n",
                        game.getAnswer());
    }
  }

}
//String example = "hello"
//example.charAt(0) returns postion in "hello" "h"
//%d = decimal


//==========Things About Strings==========
// Primitives use double equals
// Objects reference use double equals to check if they refer to the same object in memory, seemingly equal objects are not equals
// Object references must refer to the same object to ue the same object
// String literals are actually referring to the same objects
// String objects that contain the same characters but point to different objects cannot use double equals
// String Interning adds to the same String Pool where literals live, so you get back the same reference
// All Objects should use equals to check equality
