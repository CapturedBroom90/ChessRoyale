package chessroyale;

import java.awt.Color;
import java.awt.Font;
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
        if(deck[0] != null)
            deck[0].draw(g, thisObj,0);
        if(deck[1] != null)
            deck[1].draw(g, thisObj,1);
        if(deck[2] != null)
            deck[2].draw(g, thisObj,2);
        if(deck[3] != null)
            deck[3].draw(g, thisObj,3);

        g.setFont (new Font ("Times New Roman",Font.PLAIN, 50));
        g.setColor(Color.BLACK);
        g.drawString("1", Window.getWidth2()/10+39,Window.WINDOW_HEIGHT*5/6+75);
        g.drawString("2", Window.getWidth2()/3+39,Window.WINDOW_HEIGHT*5/6+75);
        g.drawString("3", Window.getWidth2()*35/60+39,Window.WINDOW_HEIGHT*5/6+75);
        g.drawString("4", Window.getWidth2()*9/11+39,Window.WINDOW_HEIGHT*5/6+75);
        
        g.setColor(Color.white);
        if(ChessRoyale.pressed1)
        {
            g.fillRect(Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150);
        }
        if(ChessRoyale.pressed2)
        {
            g.fillRect(Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150);
        }
        if(ChessRoyale.pressed3)
        {
            g.fillRect(Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150);
        }
        if(ChessRoyale.pressed4)
        {
            g.fillRect(Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150);
        }
        
    }
}
