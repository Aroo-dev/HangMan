package pl.edu.agh.mwo.java1;

import java.util.Scanner;

public class Hangman {

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordReader wordReader = new WordReader();
        wordReader.readFile();

        //System.out.println(randomWordString);
        System.out.println("Welcome to Hangman Game!!!");
        System.out.println("choose how many letters the word should consist of");
        int digit = sc.nextInt();
        RandomWord randomWord = new RandomWord(wordReader.getUppercaseWordWithSpecificAmountOFLetters(digit));
        String randomWordString = randomWord.getRandomWord();
        WordCrypter wordCrypter = new WordCrypter(randomWordString);
        System.out.println("Below is the encoded word.");
        System.out.println(wordCrypter.cryptWord());
        HangManPrinter hangManPrinter = new HangManPrinter(HANGMANPICS);
        WordChecker wordChecker = new WordChecker(randomWordString, wordCrypter.cryptWord());
        while (wordChecker.getHP() > 0 && wordChecker.getNumberOfLettersToGuess() > 0) {
            System.out.println("Provide a letter: ");
            Scanner scan = new Scanner(System.in);
            String choosenLetter = scan.nextLine().toUpperCase();
            if (wordChecker.checkIfLetterUsedBefore(choosenLetter)) {
                System.out.println("You have already chosen this letter!!!");
            } else {
                wordChecker.checkUserChoice(choosenLetter);
                System.out.println("You're left with " + wordChecker.getHP() + " HP");
                System.out.println("Pozostało Ci " + wordChecker.getNumberOfLettersToGuess() + " liter do odgadnięcia");
                hangManPrinter.printHangMan(wordChecker.getHP());
                System.out.println(wordChecker.getWordCrypted());
            }
        }
        if (wordChecker.getHP() == 0) {
            System.out.println("It's time to die. Bye " + " Your secret word is " + randomWordString);

        } else if (wordChecker.getNumberOfLettersToGuess() == 0) {
            System.out.println("You won, pal! ");

        }

    }
}