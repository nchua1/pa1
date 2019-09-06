import java.util.Arrays;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        //number of words that can be chosen
        final int NUMWORDS=10;

        //Creating an array of strings for the words to be randomly selected
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

        int[] usedNum = new int[10];
        int randomNum = randomNum();

        int numLetters = wordList[randomNum].length();
        char[] wordArray = wordList[randomNum].toCharArray();
        System.out.println();



        Word hangmanWord = new Word(wordArray, numLetters);

        boolean playAgain = false;

        while (!playAgain)
        {
            hangmanWord.playHangman();
            playAgain=true;
        }

    }

    public static int randomNum()
    {
        Random randomNum = new Random();

        int randomWordNum = randomNum.nextInt(10);
        return randomWordNum;
    }

}
