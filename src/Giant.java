import java.awt.*;

/***
 * This is a giant class extended from Critter class
 *
 * @author Hla Htun
 * @version October 01 2020
 */
public class Giant extends Critter {

    private int moves; //a counter variable to keep track of giant's moves

    public Giant(){
        moves = 0;
    }

    /**
     * Determines the movement of the giant
     *
     * @param info A CritterInfo object which contains all the information of the giant
     *
     * @return Returns an action which will cause the giant to infect other species, hop or turn right
     */
    public Action getMove(CritterInfo info) {
        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        }
        else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }
        else
            return Action.RIGHT;
    }

    /**
     * Determines the color of the giant
     *
     * @return Returns the code which sets the color of giant to gray
     */
    public Color getColor() {
        return Color.GRAY;
    }

    /**
     * Determines how the giant will look in the final simulation
     * @return Returns either "fee", "fie", "foe" or "fum" according to the number of moves the giant is on
     */
    public String toString() {
        if(moves == 24){
            moves = 0; //resets moves to zero when it reaches 24 so it can loop the if statements below
        }

        moves++;

        if(moves<=6){
            return "fee";
        }
        else if(moves>6 && moves<=12){
            return "fie";
        }
        else if(moves>12 && moves<=18){
            return "foe";
        }
        else
            return "fum";
    }
}
