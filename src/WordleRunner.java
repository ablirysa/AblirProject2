import java.util.Scanner;

public class WordleRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to off-brand Wordle!");
        System.out.print("Do you want the default version (yes/no)? ");
        String def = scan.nextLine();
        if (def.equals("yes")) {
            Wordle defGame = new Wordle();

            System.out.println();
            System.out.print("Do you want to know how to play (yes/no)? ");
            String choice = scan.nextLine();
            if (choice.equals("yes")) {
                String instructions = "The only things you need to understand are the meaning of the colors, and the only rule.";
                instructions += "\nCOLORS: \n     - Green = The right letter and in the right place \n     - Yellow = The right letter, but in the wrong place \n     - Grey = Not in the word";
                instructions += "\nRULE: \n     - DON'T use double letters, no word has two of the same letter";
                System.out.println(instructions);
            }
            System.out.println();

            System.out.print("Are you ready to start (yes/no)? ");
            String choice2 = scan.nextLine();
            while (!(choice2.equals("yes"))) {
                System.out.print("Are you ready to start (yes/no)? ");
                choice2 = scan.nextLine();
            }
            System.out.println();
            defGame.start();

            System.out.print("Guess: ");
            String guess = scan.nextLine();
            defGame.plusGuess();
            while (!defGame.check(guess)) {
                defGame.plusGuess();
                System.out.println(defGame.letterChecker(guess));
                System.out.print("Guess: ");
                guess = scan.nextLine();
            }

            System.out.print(defGame);
        } else {
            System.out.print("What's your name? ");
            String name = scan.nextLine();

            System.out.print("So, " + name + ", do you want to know how to play (yes/no)? ");
            String choice = scan.nextLine();
            if (choice.equals("yes")) {
                String instructions = "The only things you need to understand are the levels, the meaning of the colors, and the only rule.";
                instructions += "\nCOLORS: \n     - Green = The right letter and in the right place \n     - Yellow = The right letter, but in the wrong place \n     - Grey = Not in the word";
                instructions += "\nLEVELS: \n     - 1 = Four letter words \n     - 2 = Five letter words \n     - 3 = Six letter words";
                instructions += "\nRULE: \n     - DON'T use double letters, no word has two of the same letter";
                System.out.println(instructions);
            }
            System.out.println();

            System.out.print("Alright, so what mode do you want to do (1 to 3)? ");
            int mode = scan.nextInt();
            while (!(mode >= 1 && mode <= 3)) {
                System.out.print("That wasn't in the range... Try again: ");
                mode = scan.nextInt();
            }
            scan.nextLine(); // buffer line
            System.out.println();

            Wordle game = new Wordle(name, mode);

            System.out.print("Are you ready to start, " + name + " (yes/no)? ");
            String choice2 = scan.nextLine();
            while (!(choice2.equals("yes"))) {
                System.out.print("Are you ready to start, " + name + " (yes/no)? ");
                choice2 = scan.nextLine();
            }
            System.out.println();
            game.start();

            System.out.print("Guess: ");
            String guess = scan.nextLine();
            game.plusGuess();
            while (!game.check(guess)) {
                game.plusGuess();
                System.out.println(game.letterChecker(guess));
                System.out.print("Guess: ");
                guess = scan.nextLine();
            }
            System.out.print(game);
        }
    }
}