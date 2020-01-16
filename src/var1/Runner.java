package var1;

import java.util.Scanner;
import java.util.function.Predicate;

public class Runner {
    public static final String EXIT_WORD = "Y";

    public static void main(String[] args) {
        String inpString;
        Scanner sc = new Scanner(System.in);
        Predicate<String> isWord = x -> x.trim().indexOf(' ') < 0;

        StringBuilder commonString = new StringBuilder();
        while (true) {
            try {
                System.out.println("Type in your word");
                inpString = sc.nextLine();

                if (isWord.test(inpString)) {
                    System.out.println("Nice one");
                    commonString.append(inpString.trim());
                } else {
                    throw new WordInpException();
                }

                System.out.println("Type in '" + EXIT_WORD + "', if you want to stop");
                inpString = sc.nextLine();
                if (inpString.equals(EXIT_WORD)) {
                    countLetters(commonString.toString());
                    break;
                }
            } catch (WordInpException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void countLetters(String string) {
        LetterCounter letterCounter = new LetterCounter(string);
        letterCounter.printMaxLetter();
        letterCounter.printMinLetter();
    }
}
