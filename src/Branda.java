import java.awt.*;
import java.util.Random;

/**
 *
 *
 *@author Brenda Hariyanto
 *@version 10.2.2020
 */
public class Branda extends Critter
{

    private Color myColor;
    private boolean enemy;
    private boolean edge;
    private int move=0;

    public Branda()
    {
    }

    //To know if the critter is infecting other critter or not
    private void infect(CritterInfo info)
    {
        if(info.getFront() == Neighbor.OTHER)
        {
            enemy=true;
        }
        else
        {
            enemy=false;
        }
    }

    //If the critter hit the edge, it will reset the move to 0
    private boolean hitEdge(CritterInfo info)
    {
        if(info.getFront() == Neighbor.WALL && (info.getRight()==Neighbor.WALL || info.getLeft()==Neighbor.WALL))
        {
            move=0;
            return true;
        }

        else
        {
            return false;
        }
    }

    /**
     *Determine the color of the gator
     *
     *@return Color.RED - Set the color of Gator to red if the Gator is attempting to infect other critter.
     *@return Color.GREEN - Set the color of the gator to green
     */
    public Color getColor()
    {
        if(enemy)
        {
            this.myColor=Color.RED;
        }

        else
        {
            this.myColor=Color.GREEN;
        }

        return myColor;
    }

    /**
     *Determine the text that will represent the Gator depending on its color
     *
     *@return "!" if the color of the Gator is red
     *@return "+" if the color of the Gator is green
     */
    public String toString()
    {
        if(myColor==Color.RED)
        {
            return "!";
        }

        else
        {
            return "+";
        }
    }

    public Action getMove(CritterInfo info)
    {
        infect(info);

        if(info.getFront()==Neighbor.OTHER)
        {
            return Action.INFECT;
        }

        else if(info.getFront()==Neighbor.EMPTY)
        {
            if(info.getRight()==Neighbor.WALL)
            {
                move++;
                if(move==25)
                {
                    return Action.LEFT;
                }

                return Action.HOP;
            }

            if(info.getLeft()==Neighbor.WALL)
            {
                move++;

                if(move==25)
                {
                    return Action.RIGHT;
                }

                return Action.HOP;
            }

            return Action.HOP;
        }

        else
        {
            if(hitEdge(info))
            {
                move=0;
            }

            return Action.RIGHT;
        }

    }


}

/*THOUGHT PROCESS
 *At first my main attempt is everytime there is another critter beside the Gator, my Gator should turn to that direction
 *However it did not win because it took 2 steps to turn and then to infect, so most of the time, the critter escapes befor my Gator could infect
 *FAILS

 *Second attempt is trying to
 *After reading the instructions again, I realized that it hops are preferred most of the time
 *"Critters that infect after a hop are slightly favored"
 *"If a critter successfully hops during its turn, it cannot be infected"
 *So my goal now is just to play the defense
 *My goal is to make a pattern of 6 squares trying to
 *
 *COLOR & STRING
 *I also play around with the color and strings, trying to make them related.
 *At first, the problem is that, after it changes to red, it will stay red.
 *I realized that the color changes depends on my enemy boolean, which depends on a parameterized function.
 *Since the only other parameterized func is in getMove, I decided to put the function there
 *eventhough its not at all contribute to the getMove function.
 *and then it works!
 *
 *There are still minor attempts, but overall it is indeed a great practise to get me more comfortable with oop.
 *In the end, my Gator is still weak, and fails to be the winning critter.
 *However, I decided to keep it this way since its very satisfying to see the Gator finally works as I planned them to be.
 *
 */