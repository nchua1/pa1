/*
This program is to play the game hangman
One source I used was found here: https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
The above source I linked in-line as well, showing where I used the method

CPSC 224
Programming Assignment 1
Nick Chua
Version 2 9/5/2019
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //number of words that can be chosen
        final int NUMWORDS=10;

        //Creating an array of strings for the words to be randomly selected and initializing 10 words
        String[] wordList = {"horse", "chicken", "giraffe", "elephant", "leopard", "tiger", "zebra", "lizard", "snake", "penguin"};

        /*
        //Initializing 10 words
        wordList[0] = "horse";
        wordList[1] = "chicken";
        wordList[2] = "giraffe";
        wordList[3] = "elephant";
        wordList[4] = "leopard";
        wordList[5] = "tiger";
        wordList[6] = "zebra";
        wordList[7] = "lizard";
        wordList[8] = "snake";
        wordList[9] = "penguin";
         */

        //Creating an array of numbers in order, to scramble for order of list when playing if you choose to continue
        int[] usedNum = {0,1,2,3,4,5,6,7,8,9};
        //Temp variable for randoming number
        int randomNum = randomNum();

        //Shuffles order of words, with help from https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
        Random numShuffle = new Random();
        for (int i=0; i<10; i++)
        {
            int randomPosition = numShuffle.nextInt(10);
            int temp = usedNum[i];
            usedNum[i]=usedNum[randomPosition];
            usedNum[randomPosition]=temp;
        }


        for (int i=0; i<10; i++)
        {
            //original way of randoming word
            /*
            int numLetters = wordList[randomNum].length();
            char[] wordArray = wordList[randomNum].toCharArray();
            System.out.println();
             */

            //prepping the word to be created into a Word object
            int numLetters = wordList[usedNum[i]].length();
            char[] wordArray = wordList[usedNum[i]].toCharArray();

            //Creation of each Word object
            Word hangmanWord = new Word(wordArray, numLetters);

            //play function
            hangmanWord.playHangman();

            //User input for playing again
            Scanner userPlayAgain = new Scanner(System.in);
            int answerPlayAgain;
            System.out.print("Would you like to play again? (1 to quit, or any key to continue): ");
            answerPlayAgain = userPlayAgain.next().charAt(0);

            //Breaks out of for loop if chosen to quit
            if (answerPlayAgain == '1')
            {
                break;
            }

            //Adds an extra output if all words have been played
            if (i==9)
                System.out.println("There are no more words left to guess.");
        }

        System.out.println("Thanks for playing!");

    }


    //Function to random num, used for shuffling order of array
    public static int randomNum()
    {
        Random randomNum = new Random();

        int randomWordNum = randomNum.nextInt(10);
        return randomWordNum;
    }

}