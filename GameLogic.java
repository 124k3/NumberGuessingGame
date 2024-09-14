
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
     *
     */
    public int getRandomNumber(Random random, int lowerLimit, int upperLimit)
    {
        return random.nextInt(lowerLimit, upperLimit);

    }

}
