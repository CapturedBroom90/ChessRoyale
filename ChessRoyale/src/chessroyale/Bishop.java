package chessroyale;
import java.awt.*;
public class Bishop extends Piece
{
    
    private static Image bishopBlackImage;
    private static Image bishopWhiteImage;
    private static int NUM_ROWS = 8;
    private static int NUM_COLUMNS = 5;
    
    Bishop(Color _color)
    {
        super(_color);
    }
    
    public static void Init()
    {
        bishopWhiteImage = Toolkit.getDefaultToolkit().getImage("./bishopwhite.GIF");
        bishopBlackImage = Toolkit.getDefaultToolkit().getImage("./bishopblack.GIF");
    }
    
    public String getType()
    {
        return("Bishop");
    }
    
    public Color getColor()
    {
        return (super.getColor());
    }
    
    public boolean isPossibleMove(int ogrow, int ogcol, int row, int col, Piece board[][])
    {
        int ymove = 0;
        int xmove = 0;
        boolean canMove = true;

            for(int i = ogrow+1; i <= row; i++)
            {   
                ymove++;
                for(int j = ogcol+1; j <= col; j++)
                {
                    xmove++;
//                if(board[i][col] != null)
//                {
//                    if(board[i][col].getColor() != Player.getCurrentPlayer().getColor())
//                    {
//                        return true;
//                    }
//                }
//                if(board[i][col] != null && i < row)
//                {
//                    canMove = false;
//                }
                }
            }
            if(Math.abs(ymove) == Math.abs(xmove))
            {
                return true;
            }
        
        
        return false;
    }
    
    public void draw(Graphics2D g,ChessRoyale thisObj,int row,int column,int xdelta,int ydelta) {
        
        if(super.getColor() == Color.black)
            g.drawImage(bishopBlackImage,column*xdelta+55,row*ydelta+72,xdelta-50,ydelta-5,thisObj);
        
        if(super.getColor() == Color.white)
            g.drawImage(bishopWhiteImage,column*xdelta+55,row*ydelta+72,xdelta-50,ydelta-5,thisObj);
        
        
    }
    public void draw(Graphics2D g,ChessRoyale thisObj, int spot) {
 
        if(super.getColor() == Color.black && spot == 0)
            g.drawImage(bishopBlackImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 1)
            g.drawImage(bishopBlackImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 2)
            g.drawImage(bishopBlackImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 3)
            g.drawImage(bishopBlackImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        
        if(super.getColor() == Color.white && spot == 0)
            g.drawImage(bishopWhiteImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 1)
            g.drawImage(bishopWhiteImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 2)
            g.drawImage(bishopWhiteImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 3)
            g.drawImage(bishopWhiteImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
    }
    
}
