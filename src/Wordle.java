/**
 * The Wordle class represents a knock-off version of Wordle where the user guesses the word and is informed about the letters.
 */
public class Wordle {
    /** This is the player's name. */
    private String name;
    /** This is the answer the user will be attempting to guess. */
    private String answer;
    /** This is the level the user prefers to play. */
    private String level;
    /** This is the amount of guesses the user has made. */
    private int guesses;
    /** This will assist in stopping the color change. */
    private static final String RESET = "\u001B[0m";
    /** This will assist in identifying if the letter is correct. */
    private static final String GREEN = "\u001B[32m";
    /** This will assist in identifying if the letter is correct, but in the wrong place. */
    private static final String YELLOW = "\u001B[33m";

    /** A default constructor that initializes the name and level. */
    public Wordle() {
        name = "UNKNOWN";
        level = "EASY";
        answer = wordRandomizer();
    }

    /** A two-parameter constructor that initializes the name and level.
     * @param name - User's preferred name
     * @param level - User's preferred level
     */
    public Wordle(String name, int level) {
        this.name = name;
        if (level == 1) {
            this.level = "EASY";
        } else if (level == 2) {
            this.level = "MEDIUM";
        } else {
            this.level = "HARD";
        }
        answer = wordRandomizer();
    }

    /** Zero-parameter method that selects the answer by chance (three options per level) and returns it.
     * @return String - The answer the user will be attempting to get
     */
    public String wordRandomizer() {
        int num = (int) (Math.random() * 3) + 1;
        if (level.equals("EASY")) { // 4-letter words
            if (num == 1) {
                return "bunt";
            } else if (num == 2) {
                return "trap";
            } else {
                return "acid";
            }
        } else if (level.equals("MEDIUM")) { // 5-letter words
            if (num == 1) {
                return "viper";
            } else if (num == 2) {
                return "study";
            } else {
                return "nacho";
            }
        } else { // 6-letter words
            if (num == 1) {
                return "throne";
            } else if (num == 2) {
                return "answer";
            } else {
                return "volume";
            }
        }
    }

    /** Zero-parameter method that prints out the header for the start of the game. */
    public void start() {
        System.out.println("- - - " + level + " MODE - - -");
    }

    /** One-parameter method that evaluates if the user's guess is the answer.
     * @param guess - User's attempt
     * @return boolean - Only true if the user's guess is the answer.
     */
    public boolean check(String guess) {
        guess = guess.toLowerCase();
        if (guess.equals(answer)) {
            return true;
        } else {
            return false;
        }
    }

    /** Zero-parameter method that increases the amount of guesses taken, for the purpose of stats. */
    public void plusGuess() {
        guesses++;
    }

    public String letterChecker(String guess) {
        String corrections = "";
        for (int i = 0; i < guess.length(); i++) {
            String letter = guess.substring(i, i + 1);
            if (answer.indexOf(letter) == -1) {
                corrections += letter;
            } else if (answer.indexOf(letter) == i) {
                corrections += GREEN + letter + RESET;
            } else {
                corrections += YELLOW + letter + RESET;
            }
        }
        return corrections;
    }

    /** Zero-parameter method that prints out the header and game information for the end of the game. */
    public String toString() {
        String returnString = "- - - - - - - - - - - -";
        returnString += "\nGreat job, " + name + "!";
        returnString += "\nGuesses Taken: " + guesses;
        returnString += "\nCorrect Answer: " + answer;
        return returnString;
    }
}
