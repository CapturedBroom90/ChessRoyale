package chessroyale;
import java.awt.*;
public class Knight extends Piece
{
    private static Image knightBlackImage;
    private static Image knightWhiteImage;
    private static int NUM_ROWS = 8;
    private static int NUM_COLUMNS = 5;
    
    Knight(Color _color)
    {
        super(_color);
    }
    
    public static void Init()
    {
        knightBlackImage = Toolkit.getDefaultToolkit().getImage("./knightblack.GIF");
        knightWhiteImage = Toolkit.getDefaultToolkit().getImage("./knightwhite.GIF");
    }
    
    public String getType()
    {
        return("Knight");
    }
    
    public Color getColor()
    {
        return (super.getColor());
    }

    public boolean isPossibleMove(int ogrow, int ogcol, int row, int col, Piece board[][])
    {
        int xmove = 0;
        int ymove = 0;
        if(ogrow < row && ogcol < col)
        {
            for(int i = ogrow+1; i <= row; i++)
            {
                xmove++;
            }
            for (int j = ogcol+1; j <= col; j++)
            {
                ymove++;
            }
            if(xmove ==  ymove + 1 && xmove == 2|| ymove == xmove + 1 && ymove == 2)
            {
                return true;
            }
        }
        else if(row < ogrow && ogcol > col)
        {
            for(int i = ogrow-1; i >= row; i--)
            {
                xmove++;
            }
            for (int j = ogcol-1; j >= col; j--)
            {
                ymove++;
            }
            if(xmove ==  ymove + 1 && xmove == 2|| ymove == xmove + 1 && ymove == 2)
            {
                return true;
            }
        }
        else if(ogcol < col && ogrow > row)
        {
            for(int i = ogrow-1; i >= row; i--)
            {
                xmove++;
            }
            for (int j = ogcol+1; j <= col; j++)
            {
                ymove++;
            }
            if(xmove ==  ymove + 1 && xmove == 2|| ymove == xmove + 1 && ymove == 2)
            {
                return true;
            }
        }
        else if(col < ogcol && ogrow < row)
        {
            for(int i = ogrow+1; i <= row; i++)
            {
                xmove++;
            }
            for (int j = ogcol-1; j >= col; j--)
            {
                ymove++;
            }
            if(xmove ==  ymove + 1 && xmove == 2|| ymove == xmove + 1 && ymove == 2)
            {
                return true;
            }
        }
        return false;

    }
    
    public void draw(Graphics2D g,ChessRoyale thisObj,int row,int column,int xdelta,int ydelta) {
 
        if(super.getColor() == Color.black)
            g.drawImage(knightBlackImage,column*xdelta+50,row*ydelta+75,xdelta-40,ydelta-10,thisObj);

        if(super.getColor() == Color.white)
            g.drawImage(knightWhiteImage,column*xdelta+50,row*ydelta+75,xdelta-40,ydelta-10,thisObj);
    }
    
    public void draw(Graphics2D g,ChessRoyale thisObj, int spot) {
 
        if(super.getColor() == Color.black && spot == 0)
            g.drawImage(knightBlackImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 1)
            g.drawImage(knightBlackImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 2)
            g.drawImage(knightBlackImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 3)
            g.drawImage(knightBlackImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        
        if(super.getColor() == Color.white && spot == 0)
            g.drawImage(knightWhiteImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 1)
            g.drawImage(knightWhiteImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 2)
            g.drawImage(knightWhiteImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 3)
            g.drawImage(knightWhiteImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
    }
    
}
