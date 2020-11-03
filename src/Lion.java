import java.awt.*;
import java.util.Random;

/***
 * This is a Lion class extended from Critter class
 *
 * @author Hla Htun
 * @version October 01 2020
 */
public class Lion extends Critter {
    private Color lionColors[]; //Color object to store different colors
    private int moves; //A counter variable to count the number of moves lion has made
    private Random rand = new Random(); // random object rand to create random numbers
    private int randomNumber; //int variable to store the created random numbers
    /**
     * This is a default constructor which stores different colors into a Color object
     */
    public Lion() {
        moves = 0; //setting moves to 0
        lionColors = new Color[]{Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE}; //storing colors in the array

    }

    /**
     * Determines the movement of the Lion
     *
     * @param info A CritterInfo object which contains all the information of the lion
     * @return Returns an action which will cause the lion to either infect, move left, right or hop in the direction they are facing
     */
    public Action getMove(CritterInfo info) {
        if(moves==0){
            randomNumber = rand.nextInt(4); //create a random number every time move counter becomes 0
        }
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }
        else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        }
        else if(info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }
        else{
            return Action.HOP;
        }

    }

    /**
     * Determines the color of the lion
     *
     * @return Returns a color randomly picked from the array of colors stored in the Color object in the default constructor
     */
    public Color getColor() {

        if(moves<2){
            moves++; //increment moves
            return lionColors[randomNumber];

        }
        else{
            moves = 0; //when moves = 3, sets it to zero
            return lionColors[randomNumber];
        }
    }

    /**
     * Determines how the lion will look in the final simulation
     *
     * @return Returns a String "L" to represent lion
     */
    public String toString() {
        return "L";
    }
}
