import java.awt.*;
import java.util.Random;

/***
 *
 * This gator class extends Critter class
 *
 * @author Hla Htun
 * @version October 01 2020
 */
public class Gator extends Critter {
    private int moves; //A counter variable to count the number of moves lion has made
    private Color gatorColors[]; //Color object to store different colors
    private Random rand = new Random(); // random object rand to create random numbers
    private int randomNumber; //int variable to store the created random numbers

    /**
     * Default constructor sets moves to 0
     */
    public Gator(){
        moves = 0;
        gatorColors = new Color[]{Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.BLACK, Color.WHITE, Color.GRAY, Color.DARK_GRAY};
    }

    /**
     * Determines the movement of the gator
     *
     * @param info A CritterInfo object which contains all the information of the gator
     * @return Returns an action which can be either to move right, left, hop or infect other species when their respective conditions are met
     */
    public Action getMove(CritterInfo info) {
        moves++;
        //System.out.println(moves);

        if(info.getFront() == Neighbor.OTHER){
            return Action.INFECT; //infect if other species is in front
        }
        else if(info.getLeft() == Neighbor.OTHER){ //if species in left is moving towards gator's direction, run away basically otherwise follow
            if(info.getLeftDirection() == Direction.EAST){
                if(info.getFront() == Neighbor.EMPTY){
                    return Action.HOP;
                }
                else
                    return Action.RIGHT;
            }
            else
                return Action.LEFT;

        }
        else if(info.getBack() == Neighbor.OTHER){ //hop if possible when other species is behind otherwise move left or right
            if(info.getFront() == Neighbor.EMPTY){
                return Action.HOP;
            }
            else if(info.getRight() == Neighbor.EMPTY){
                return Action.RIGHT;
            }
            else
                return Action.LEFT;

        }
        else if(info.getRight() == Neighbor.OTHER){ //if species in right is moving towards gator's direction, run away basically otherwise follow
            if(info.getRightDirection() == Direction.WEST){
                if(info.getFront() == Neighbor.EMPTY){
                    return Action.HOP;
                }
                else
                    return Action.LEFT;
            }
            else
                return Action.RIGHT;

        }
        else if(info.getFront() == Neighbor.OTHER && info.getRight() == Neighbor.OTHER){ //if other species is in front and right, check their directions
            if(info.getFrontDirection() == Direction.SOUTH){                             //if front species is moving toward gator turn right(provided right species direction is not toward gator)
                if(info.getRightDirection() == Direction.WEST){
                    return Action.LEFT;
                }
                else
                    return Action.RIGHT;
            }
            else
                return Action.HOP;
        }

        else if(info.getFront() == Neighbor.OTHER && info.getLeft() == Neighbor.OTHER){ //same thing applied as before but this time for front and left species
            if(info.getFrontDirection() == Direction.SOUTH){
                if(info.getLeftDirection() == Direction.EAST){
                    return Action.RIGHT;
                }
                else
                    return Action.LEFT;
            }
            else
                return Action.HOP;
        }
        else if(info.getFront() == Neighbor.EMPTY){ //hop whenever there is empty space, if not possible, turn right and left accordingly

            if(info.getRight() == Neighbor.OTHER){ //(copied and pasted from the above written code for what to do with getRight information)
                if(info.getRightDirection() == Direction.WEST){
                    if(info.getFront() == Neighbor.EMPTY){
                        return Action.HOP;
                    }
                    else
                        return Action.LEFT;
                }
                else
                    return Action.RIGHT;

            }
            else if(info.getLeft() == Neighbor.OTHER){ //(copied and pasted from the above written code for what to do with getLeft information)
                if(info.getLeftDirection() == Direction.EAST){
                    if(info.getFront() == Neighbor.EMPTY){
                        return Action.HOP;
                    }
                    else
                        return Action.RIGHT;
                }
                else
                    return Action.LEFT;

            }
            else{
                return Action.HOP;
            }
        }
        else if(info.getFront() == Neighbor.WALL){ //when faced with wall, gator will check right and left, if either has species, it will check for directions and move accordingly to ensure safety or infection
            if(info.getRight() == Neighbor.OTHER){
                if(info.getRightDirection() == Direction.WEST){
                    return Action.LEFT;
                }
                else
                    return Action.RIGHT;

            }
            else
                return Action.LEFT;
        }
        else if(info.getFront() == Neighbor.SAME){ //when faced with same species, gator will follow them (idea: if gator moves collectively, they might have less chance of being infected by other species and losing out in numbers )
            if(info.getFrontDirection() == Direction.EAST){
                return Action.RIGHT;
            }
            else if(info.getFrontDirection() == Direction.WEST){
                return Action.LEFT;
            }
            else
                return Action.LEFT;
        }
        else
            return Action.HOP;
    }

    /**
     * Determines the color of the gator
     *
     * @return Returns the color to represent gator
     */
    public Color getColor() {
        if(moves>400 && moves<500){ //idea: start celebrating the win by changing different colors
            randomNumber = rand.nextInt(8); //create a random number between 0-7
            return gatorColors[randomNumber];
        }
        if(moves>500){ //idea: start disappearing because the above celebration has probably annoyed the user
            return Color.CYAN;
        }
        else
            return Color.YELLOW;
    }

    /**
     * Determines how the gator will be represented in the final simulation
     *
     * @return Returns a String "G" which will be the reference for gator
     */
    public String toString() {
        if(moves>400 && moves<500){ //idea: boost your win
            return "I win lets goooo";
        }
        if(moves>500){ //idea: disappear
            return "Byeee";
        }
        else
            return "G";
    }
}