package chessroyale;

import java.awt.Color;
import java.awt.Graphics2D;


public class Deck 
{
    public static Piece []deck = new Piece[4];
    public static void reset()
    {
        for(int i = 0;i<deck.length;i++)
        {
            deck[i] = null;
            int rand = (int)(Math.random() * 4) + 1;
            if(rand == 1)
            {
                deck[i] = new Queen(Color.white);
            }
            else if(rand == 2)
            {
                deck[i] = new Knight(Color.white);
            }
            else if(rand == 3)
            {
                deck[i] = new Bishop(Color.white);
            }
            else
            {
                deck[i] = new Rook(Color.white);
            }
        }
    }
    public static void randomize()
    {
        for(int i = 0;i<deck.length;i++)
        {
            deck[i] = null;
            int rand = (int)(Math.random() * 4) + 1;
            if(rand == 1)
            {
                deck[i] = new Queen(Player.getCurrentPlayer().getColor());
            }
            else if(rand == 2)
            {
                deck[i] = new Knight(Player.getCurrentPlayer().getColor());
            }
            else if(rand == 3)
            {
                deck[i] = new Bishop(Player.getCurrentPlayer().getColor());
            }
            else
            {
                deck[i] = new Rook(Player.getCurrentPlayer().getColor());
            }
        }
    }
    
    public static void draw(Graphics2D g,ChessRoyale thisObj)
    {
            deck[0].draw(g, thisObj,0);
            deck[1].draw(g, thisObj,1);
            deck[2].draw(g, thisObj,2);
            deck[3].draw(g, thisObj,3);
        
    }
}
