package chessroyale;
import java.awt.*;
public class Rook extends Piece
{
    private static Image rookBlackImage;
    private static Image rookWhiteImage;
    private static int NUM_ROWS = 8;
    private static int NUM_COLUMNS = 5;
    Rook(Color _color)
    {
        super(_color);
    }
    
    public static void Init()
    {
        rookWhiteImage = Toolkit.getDefaultToolkit().getImage("./rookwhite.GIF");
        rookBlackImage = Toolkit.getDefaultToolkit().getImage("./rookblack.GIF");
    }
    
    public String getType()
    {
        return("Rook");
    }
    
    public Color getColor()
    {
        return (super.getColor());
    }
    
    public boolean isPossibleMove(int ogrow, int ogcol, int row, int col, Piece board[][])
    {
        if(ogrow < row && ogcol == col)
        {
            int count = 0;
            for(int i = ogrow+1; i <= row; i++)
            {
                if(board[i][col] == null || board[i][col].getColor() != Player.getCurrentPlayer().getColor())
                {
                    count++;
                }
            }
            if(count == row-ogrow)
            {
                return true;
            }
        }
        else if(row < ogrow && ogcol == col)
        {
            int count = 0;
            for(int i = ogrow-1; i >= row; i--)
            {
                if(board[i][col] == null || board[i][col].getColor() != Player.getCurrentPlayer().getColor())
                {
                    count++;
                }
            }
            if(count == ogrow-row)
            {
                return true;
            }
        }
        else if(ogcol < col && ogrow == row)
        {
            int count = 0;
            for(int i = ogcol+1; i <= col; i++)
            {
                if(board[row][i] == null || board[i][col].getColor() != Player.getCurrentPlayer().getColor())
                {
                    count++;
                }
            }
            if(count == col-ogcol)
            {
                return true;
            }
        }
        else if(col < ogcol && ogrow == row)
        {
            int count = 0;
            for(int i = ogcol-1; i >= col; i--)
            {
                if(board[row][i] == null || board[i][col].getColor() != Player.getCurrentPlayer().getColor())
                {
                    count++;
                }
            }
            if(count == ogcol-col)
            {
                return true;
            }
        }
        return false;
    }
    
    public void draw(Graphics2D g,ChessRoyale thisObj,int row,int column,int xdelta,int ydelta) {
        if(super.getColor() == Color.black)
            g.drawImage(rookBlackImage,column*xdelta+55,row*ydelta+72,xdelta-50,ydelta-5,thisObj);
        
        if(super.getColor() == Color.white)
            g.drawImage(rookWhiteImage,column*xdelta+55,row*ydelta+72,xdelta-50,ydelta-5,thisObj);
        
    }
    public void draw(Graphics2D g,ChessRoyale thisObj, int spot) {
 
        if(super.getColor() == Color.black && spot == 0)
            g.drawImage(rookBlackImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 1)
            g.drawImage(rookBlackImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 2)
            g.drawImage(rookBlackImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 3)
            g.drawImage(rookBlackImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        
        if(super.getColor() == Color.white && spot == 0)
            g.drawImage(rookWhiteImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 1)
            g.drawImage(rookWhiteImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 2)
            g.drawImage(rookWhiteImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 3)
            g.drawImage(rookWhiteImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
    }
    
}
