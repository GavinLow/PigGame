package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState state;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame()
    {
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx)
    {
        if (playerIdx < 0 || playerIdx > 1) {
            // if our player-number is out of range, return false
            return false;
        }
        else {
            // player can move if it's their turn, or if the middle deck is non-empty
            // so they can slap
            return playerIdx == state.getTurn() ;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action)
    {
        if(!(action instanceof PigRollAction) || !(action instanceof PigHoldAction))
        {
            return false;
        }



        if(action instanceof  PigRollAction)
        {
            int rand = (int)((6*Math.random())+1);
            state.setDieValue(rand);
            if(state.getDieValue()>1)
            {
                state.setRunningTotal(state.getRunningTotal()+state.getDieValue());
            }
            else
            {
                state.setRunningTotal(0);
                if(state.getTurn()==0)
                {
                    state.setTurn(1);
                }
                else
                {
                    state.setTurn(0);
                }

            }
            return true;
        }


        if(action instanceof  PigHoldAction)
        {
            state.setRunningTotal(0);
            if(state.getTurn()== 0)
            {
                state.setP0Score(state.getRunningTotal()+state.getP0Score());
                state.setTurn(1);
            }
            else
            {
                state.setP1Score(state.getRunningTotal()+state.getP1Score());
                state.setTurn(0);
            }

            return  true;
        }



        return true;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p)
    {
        if(state == null)
        {
            return;
        }
        PigGameState stateForPlayer = new PigGameState(state);
        p.sendInfo((GameState)stateForPlayer);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver()
    {
        if(state.getP0Score() >= 50)
        {
            return "P0 Wins!";
        }
        else if(state.getP1Score() >= 50)
        {
            return "P1 Wins!";
        }
        else
        {
            return null;
        }
    }

}// class PigLocalGame
