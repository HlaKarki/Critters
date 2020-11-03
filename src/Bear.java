import java.awt.*;

/***
 * This is a bear class extended from Critter class
 *
 * @author Hla Htun
 * @version October 01 2020
 */
public class Bear extends Critter {

    private Color bearColor; //Color object to hold the color of bear
    private int moves = 1; //Counter variable to keep track of bear's moves

    /**
     * Determines the color of the bear
     *
     * @param polar This is a boolean to decide the color of the bear to either white or black
     */
    public Bear(boolean polar){
        if(polar){
            bearColor = Color.WHITE;
        }
        else
            bearColor = Color.BLACK;
    }

    /**
     * Determines the movement of the bear
     *
     * @param info A CritterInfo object which contains all the information of the bear
     * @return Returns an action which will cause the bear to infect other species, hop or turn left
     */
    public Action getMove(CritterInfo info) {
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }
        else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }
        else{
            return Action.LEFT;
        }


    }

    /**
     * Determines the color of the bear
     * @return Returns a Color object which contains either white or black determined in the Bear(boolean) constructor
     */
    public Color getColor() {
        return bearColor;
    }

    /**
     * Determines how the bear will look in the final simulation
     *
     * @return Returns a "/" for odd moves and "\" for even
     */
    public String toString(){
        if(moves%2!=0){
            return "/";
        }
        else
            return "\\";
    }
}
