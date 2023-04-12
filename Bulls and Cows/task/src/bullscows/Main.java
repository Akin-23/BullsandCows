package bullscows;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    int bulls;
    int cows;
    boolean GameOn;

    public Main() {
        GameOn = true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main code = new Main();

        int length = 0 ;
        int characters = 0;


        try {
            length = code.getLength(scanner);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

            try {
                characters = code.getRangeOfSymbols(scanner, length);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            String predefinedCode = code.generateSecretCode(length, characters);
            code.printSecret(length, characters);
            System.out.println(predefinedCode);
            code.process(scanner, predefinedCode, length);
        }



    public void process (Scanner scanner, String predefinedCode, int length) {

        int i = 1;
        System.out.println("Okay, let's start a game!");

        while (GameOn) {
            System.out.println("Turn " + i + ":");
            String input = scanner.next();
            checkCode(predefinedCode, input);
            printScore(length);
            System.out.println("");
            checkingIfGameOn(length);
            setBullsToZero();
            setCowsToZero();
            i++;

        }

    }


    public int getLength(Scanner scanner) throws IllegalArgumentException, InputMismatchException {
        System.out.println("Please, enter the secret code's length:");

        int length = 0;
        try {
            length = scanner.nextInt();


            if (length < 1) {
                throw new IllegalArgumentException("Error: minimum length in the code is 1.");
            }


        } catch (InputMismatchException e) {
            throw new InputMismatchException("Error: " + scanner.next() + " isn't a valid number.");
        }

        return length;

    }

    public int getRangeOfSymbols (Scanner scanner, int length) throws InputMismatchException, IllegalArgumentException {

        System.out.println("Input the number of possible symbols in the code:");
        int symbols = 0;
        try {
            symbols = scanner.nextInt();
            if (length > symbols) {
                throw new IllegalArgumentException("Error: it's not possible to generate a code with a length of " + length + " with " + symbols + " unique symbols.");
            }
            if (symbols > 36) {
                throw new IllegalArgumentException("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");

            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Error: " + scanner.next() + " isn't a valid number.");
        }
          return symbols;


    }

    public void printSecret (int length,int characters) {
        int  numOfSymbols = characters - 10;

        if (numOfSymbols < 0){
            numOfSymbols = 0;
        }
        int  num = numOfSymbols + 96 ;
        char letter = (char) num;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++ ) {
            sb.append("*");
        }

          if (num == 96) {
            System.out.println("The secret is prepared: " + sb.toString() + " (0-9)");
        }
          else if (num == 97 ){
            System.out.println("The secret is prepared: " + sb.toString()+ " (0-9, a)");
        } else {
            System.out.println("The secret is prepared: " + sb.toString()+ " (0-9, a-" + letter + ")");

        }

    }

    public void setBullsToZero () {
        this.bulls = 0;
    }

    public void setCowsToZero () {
        this.cows = 0;
    }


    public String generateSecretCode(int length, int totalCharacters) {


        String digits = "0123456789";

        StringBuilder sb = new StringBuilder(digits);

        int lastLetter = 97 + (totalCharacters-10);


        for (int i = 97 ; i < lastLetter; i++)
        {
            sb.append((char)i);
        }

        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();


        while (secretCode.length() < length) {
            int index = random.nextInt(sb.length());
            secretCode.append(sb.charAt(index));
            sb.deleteCharAt(index);
        }

        return secretCode.toString();

    }


    void checkCode(String predefinedCode, String input) {
        char[] predefinedArray = predefinedCode.toCharArray();
        char[] inputArray = input.toCharArray();

        for (int i = 0; i < predefinedArray.length; i++) {
            if (inputArray[i] == predefinedArray[i]) {
                incrementBulls();
            }
        }

        for (char x : inputArray) {
            if (predefinedCode.contains(String.valueOf(x))) {
                incrementCows();
            }
        }

    }

    private void incrementBulls() {

        this.bulls++;
    }

    private void incrementCows() {

        this.cows++;
    }

    private boolean checkingIfGameOn(int length) {

        if (this.bulls == length) {
            System.out.println("Congratulations! You guessed the secret code.");
            return GameOn = false;
        } else return GameOn;
    }

    private void printScore(int length) {

        if (bulls == length) {
            System.out.println("Grade: " + bulls + " bulls");

        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s)", bulls, cows);

        }

    }
}
