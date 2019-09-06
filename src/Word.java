/*
Is used for each word to play Hangman. Has play function, functions to check if words were used already or if
the user wins, and a function to update the output or display.
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Word
{
    //member variables
    private char[] wordLetters;
    private int numLetters;
    private int guessFailedAttempts;
    private char[] availableLetters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private char[] visibleLetters;
    private char userGuess;
    private boolean win;

    //Initialize number of letters, empty for array of characters for wordLetters, and empty all other variables
    Word(char[] paramWordLetters, int paramNumLetters)
    {
        numLetters = paramNumLetters;
        wordLetters = new char[numLetters];
        visibleLetters = new char[numLetters];
        for (int i=0; i<numLetters; i++)
        {
            wordLetters[i] = paramWordLetters[i];
            visibleLetters[i] = '_';
        }
        guessFailedAttempts = 0;
        win = true;
    }

    //Checks if letter is in word. If found, update displayLetters, if not, put into charUsed
    //and increment the number of failed attempts
    public void updateDisplay()
    {
        boolean foundLetter=false;
        for (int i = 0; i<numLetters; i++)
        {
            if (wordLetters[i] == userGuess)
            {
                visibleLetters[i]=userGuess;
                foundLetter=true;
            }
        }
        if (foundLetter==false)
        {
            for (int i=0; i<26; i++)
            {
                if (userGuess == availableLetters[i])
                {
                    availableLetters[i]='-';
                }
            }
            guessFailedAttempts++;
        }
    }

    //Function to check if word was discovered/game was won, returns boolean
    public boolean winCheck()
    {
        for (int i=0; i<numLetters; i++)
        {
            if (availableLetters[i]=='_')
            {
                return false;
            }
        }
        return true;
    }

    //Function to check if world was already used, and checks for valid inputs, returns boolean
    public boolean alreadyUsed()
    {
        for (int i=0; i<26; i++)
        {
            if (userGuess == availableLetters[i])
                return true;
        }
        return false;
    }

    //no return. Main function used to play hangman.
    public void playHangman()
    {
        Scanner tempScanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman!");
        while (guessFailedAttempts<7) {
            System.out.println("Word to guess: " + Arrays.toString(visibleLetters) + "    ||    Missed Letters (7 attempts max): " + guessFailedAttempts);
            System.out.print("Available letters:");
            for (int i = 0; i < 26; i++) {
                System.out.print(availableLetters[i]);
            }
            System.out.print("    ||    Enter letter: ");
            userGuess = tempScanner.next().charAt(0);
            Character.toLowerCase(userGuess);

            while (!alreadyUsed()) {
                System.out.println("Already used. Enter letter: ");
                userGuess = tempScanner.next().charAt(0);
                Character.toLowerCase(userGuess);
            }

            updateDisplay();
            win = true;
            for (int i = 0; i<numLetters; i++)
            {
                if (visibleLetters[i] != wordLetters[i])
                {
                    win = false;
                }
            }

            if (win)
            {
                System.out.println("Word to guess: " + Arrays.toString(visibleLetters));
                System.out.println("You win!");
                break;
            }
        }
    }
}
