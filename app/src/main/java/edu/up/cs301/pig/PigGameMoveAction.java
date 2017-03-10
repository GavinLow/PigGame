package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;

/**
 * Created by nguyenv19 on 3/9/2017.
 */
public class PigGameMoveAction extends GameAction
{

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public PigGameMoveAction(GamePlayer player) {
        super(player);
    }
    public boolean isHold()
    {
        return false;
    }
    public  boolean isRoll()
    {
        return false;
    }
}
