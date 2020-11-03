import java.awt.*;

/***
 * This is a Titan class extended from Giant class
 *
 * @author Hla Htun
 * @version October 01 2020
 */
public class Titan extends Giant {

    /**
     * Determines the movement of the titan
     *
     * @param info A CritterInfo object which contains all the information of the Titan
     *
     * @return Returns an action which will either cause the titan to infect, hop or move left
     */
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }
        else
            return Action.LEFT;
    }

    /**
     * Determines the color of the titan
     *
     * @return Returns either black or white color determined by whether the giant is either "fee", "foe" or "fie", "fum"
     */
    public Color getColor() {
        if(toString().equals("fee") || toString().equals("foe")){
            return Color.BLACK;
        }
        else
            return Color.WHITE;
    }

}