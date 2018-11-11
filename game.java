//Logic
public class Game
  public static final int MAX_MISSES = 7;
  private String answer;
  private String hits;
  private Stringn misses;

  //constructor
  public Game(String answer) {
    this.answer = answer.toLowerCase();
    hits = "";
    misses = "";
  }

  public String getAnswer() {
    retrun answer;
  }

  //If user puts in anything besides letter
  private char normalizeGuess(char letter) {
    if (! Character.isLetter(letter)) {
      throw new IllegalArgumentException("A letter is required")
    }
    letter = Character.toLowerCase(letter);
    if (misses.indexOf(letter) != -1 || hits.indexOf(letter) !=-1) {
      throw new IllegalArgumentException(letter + " has already been guessed");
  }
  return letter;

  public boolean applyGuess(String letters) {
    if (letters.length() == 0) {
      throw new IllegalArgumentException("No letter found");
    }
    return applyGuess(letters.charAt(0));

  }

  public boolean applyGuess(char letter) {
    letter = normalizeGuess(letter);
    boolean isHit = answer.indexof(letter) != -1; // is the letter in the answer
    if (isHit) {
      hits += letter;
    } else {
      misses += letter;
    }
    return isHit;
  }

  public int getRemainingTries() {
    return MAX_MISSES - misses.length();
  }

  public String getCurrentProgress() {
    String progress = "";
    //loop through each letter of answer
    for (char letter : answer.toCharArray()) {
      char display = '-'; //sets default to '-'
      if (hits.indexOf(letter) != -1){
        display = letter;
      } //indexOf returns -1 if not found so say != means not -1 do this
      progress += display; //appending each display
    } //toCharArray(); breaks apart a String into an Array of characters
    return progress;
  }

  public boolean isWon() {
    return getCurrentProgress().indexOf('-') == -1;//returns string, checks for '-', and if no they have not won.
  }

}
//jshell /open Game.java
//Game game = new Game("treehouse");
//game.applyGuess('t')
//returns true
//static exposies off the class
//private = only accessable to the class its in
