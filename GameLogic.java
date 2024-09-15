
import java.util.Scanner;
import java.util.Random;

/**
 * All the logic related to {@code Number Gussing Game} resides here.
 * 
 * The following class handles all the logical operations realated to the 
 * gameplay. 
 *
 */
public class GameLogic
{
    public GameLogic() {}

    /**
     * provides a random integer within the specified limit.
     * 
     * The random integer is generated via the {@code java.util.Random}
     * @param lowerLimit integer which specifies the starting point of 
     * the random number {@code randomNumber >= lowerLimit}
     * @param upperLimit integet with which the ending point of the random 
     * limit is determined {@code randomNumber < upperLimit}
     * @return {@code random.nextInt()} a random integet within the range 
     * {@code lowerLimit >= randomNumber <upperLimit}
     *
     */
    public int getRandomNumber(
            Random random, int lowerLimit, int upperLimit)
    {
        return random.nextInt(lowerLimit, upperLimit);

    }

    
    /**
     * only return(s) a valid integet input
     * 
     * If the input obtained isn't valid it will again prompt the same
     * untill and unless the suitable (valid) input is obtained.
     * @param scanner the scanner object of the class 
     * {@code java.util.Scanner}
     * @param prompt the prompt(message) to be shown 
     * while asking for the input. The prompt supports {@code C} style text
     * formatting {@code %d, %n, %f..}
     * @param errMessage the message to be shown if the input 
     * obtained is of invalid type. The errMessage supports {@code C} style 
     * textformatting {@code %d, %n, %f..}
     * @return returns a valid integer (gauranteed).
     *
     */
    public int getValidIntInput(
            Scanner scanner, String prompt, String errMessage)
    {
        int validIntInput = 0;
        boolean invalidInput = true;
        // assuming that the input obtained is invalid from the begining

        while (invalidInput)
        {
            System.out.printf(prompt);
            try
            {
                validIntInput = scanner.nextInt();
                invalidInput = false;
            }
            catch (Exception e)
            {
                System.out.println(errMessage);
                // consumens the invalid input (the string with spaces)
                scanner.nextLine();
            }
        }
        return validIntInput;
    }


    /**
     * according to the choice returns the chances of playing the game
     *
     * The method in accordance to the input assign(s) difficulty level
     * which is just how many chances the user is alllowed to play one game
     * before the game terminates.
     *
     * @param difficultyLevel the values can be {@code 1 or 2 or 3} 
     * 1 being the easy and 3 beight the hard
     * @return {@code chances} the number of chances (times) a player is 
     * allowed to guess.
     */
    public int gameDifficultyLevel(int difficultyLevel)
    {
        int chances = 0; 

        switch (difficultyLevel)
        {
            case 1:
                // easy level difficulty
                chances +=10;
                break;
            case 2:
                // medium level difficulty
                chances +=5;
                break;
            case 3:
                // hard level difficulty
                chances +=3;
                break;
        }
        return chances;
    }


    /**
     *
     *
     *
     */
    public String guessMessage(
            int guessedNumber, int actualNumber, int attempts)
    {
        String message = null;
       
        if (guessedNumber == actualNumber)
        {

            attempts -= 1;
            message = String.format(
            "Congratulations! you guessed the correct Number in %d attempts",
            attempts);
        }
        else
        {
            if (guessedNumber < actualNumber)
            {
                attempts -= 1; // decrement as one attempt is being used
                message = String.format(
"Incorrect! The number is Grater than %d (remaining Attempt's: %d)",
                    guessedNumber,
                    attempts);
            }

            if (guessedNumber > actualNumber)
            {
                attempts -= 1;
                message = String.format(
"Incorrect! The number is Smaller than %d (remaining Attempt's: %d)",
                    guessedNumber,
                    attempts);
            }

        }
        return message; 
    }


}
