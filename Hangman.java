public class Hangman {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: java Hangman <answer>");
      System.err.println("answer is required");
      System.exit(1);
      }

    Game game = new Game(args[0]);
    Prompter prompter = new Prompter(game); //(game) is putting the Game.java code

    while (game.getRemainingTries() > 0 && !game.isWon()) { //While tries are reamaining you can keep playing
      prompter.displayProgress();
      prompter.promptForGuess(); // runs code in Prompter for guess
    }
    prompter.displayOutCome();
  }
}
//Console: Compile by running javac Hangman.java did not compile Prompter
//because Prompter was not added like Game.
//Char letter = 'D'; Char is short for character. "" are for strings '' are for char var
