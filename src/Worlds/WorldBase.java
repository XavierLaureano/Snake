package Worlds;

import Game.Entities.Dynamic.Player;
import Game.Entities.Dynamic.Tail;
import Game.Entities.Static.Apple;
import Game.GameStates.State;
import Main.Handler;

import java.awt.*;
import java.util.LinkedList;

import com.sun.glass.events.KeyEvent;


/**
 * Created by AlexVR on 7/2/2018.
 */
public abstract class WorldBase {

    //How many pixels are from left to right
    //How many pixels are from top to bottom
    //Must be equal
    public int GridWidthHeightPixelCount;

    //automatically calculated, depends on previous input.
    //The size of each box, the size of each box will be GridPixelsize x GridPixelsize.
    public int GridPixelsize;

    public Player player;

    protected Handler handler;


    public Boolean appleOnBoard;
    protected Apple apple;
    public Boolean[][] appleLocation;

    public Boolean[][] playerLocation;

    public LinkedList<Tail> body = new LinkedList<>();


    public WorldBase(Handler handler){
        this.handler = handler;

        appleOnBoard = false;


    }
    public void tick()
    {
    	if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_P)) 
    	{
    		State.setState(handler.getGame().pauseState);
    	}
    }

    public void render(Graphics g){

        for (int i = 0; i <= 480; i = i + GridPixelsize) {

            g.setColor(Color.YELLOW);
            g.drawLine(0, i, handler.getWidth() , i);
            g.drawLine(i,0,i,handler.getHeight()-20);
        }



    }

}
