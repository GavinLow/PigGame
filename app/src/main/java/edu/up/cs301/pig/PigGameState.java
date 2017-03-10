package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by gavinlow on 3/9/17.
 */

public class PigGameState extends GameState
{
    private int turn;
    private int p0Score;
    private int p1Score;
    private int runningTotal;
    private int dieValue;


    //Constructor
    public PigGameState()
    {
        turn = 0;
        p0Score = 0;
        p1Score = 0;
        runningTotal = 0;

    }

    //Copy Constructor
    public PigGameState(PigGameState p)
    {
        turn = p.turn;
        p0Score = p.p0Score;
        p1Score = p.p1Score;
        runningTotal = p.runningTotal;
    }

    //Getter Methods
    public int getTurn()
    {
        return this.turn;
    }

    public int getP0Score()
    {
        return this.p0Score;
    }

    public int getP1Score()
    {
        return this.p1Score;
    }

    public int getRunningTotal()
    {
        return this.runningTotal;
    }

    public int getDieValue()
    {
        return this.dieValue;
    }

    //Setter Methods
    public void setTurn(int turn)
    {
        this.turn = turn;
    }

    public void setP0Score(int p0Score)
    {
        this.p0Score = p0Score;
    }

    public void setP1Score(int p1Score)
    {
        this.p1Score = p1Score;
    }

    public void setRunningTotal(int runningTotal)
    {
        this.runningTotal = runningTotal;
    }

    public void setDieValue(int dieValue)
    {
        this.dieValue = dieValue;
    }
}
