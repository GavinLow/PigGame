package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    private PigGameState savedState;

    public PigComputerPlayer(String name)
    {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info)
    {
        if (!(info instanceof PigGameState))
        {
            return;
        }


        savedState = (PigGameState)info;


        double rand = Math.random();
        if (rand>.50)
        {
            sleep((int)(2000*Math.random()));
            game.sendAction(new PigHoldAction(this));
        }
        else
        {
            sleep((int)(2000*Math.random()));
            game.sendAction(new PigRollAction(this));
        }


    }//receiveInfo

}
