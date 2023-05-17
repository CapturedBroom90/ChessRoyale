package chessroyale;
import java.awt.*;
public class King extends Piece
{
    private static Image kingWhiteImage;
    private static Image kingBlackImage;
    
    King(Color _color)
    {
        super(_color);
    }
    
    public static void Init()
    {
        kingWhiteImage = Toolkit.getDefaultToolkit().getImage("./kingwhite.GIF");
        kingBlackImage = Toolkit.getDefaultToolkit().getImage("./kingblack.GIF");
    }
    
    public String getType()
    {
        return("King");
    }
    
    public Color getColor()
    {
        return (super.getColor());
    }
    
    public boolean isPossibleMove(int ogrow, int ogcol, int row, int col, Piece board[][])
    {
        return false;
    }
    
    public void draw(Graphics2D g,ChessRoyale thisObj,int row,int column,int xdelta,int ydelta) {

        if(super.getColor() == Color.black)
            g.drawImage(kingBlackImage,column*xdelta+55,row*ydelta+72,xdelta-50,ydelta-5,thisObj);
        
        if(super.getColor() == Color.white)
            g.drawImage(kingWhiteImage,column*xdelta+55,row*ydelta+72,xdelta-50,ydelta-5,thisObj);
    }
    
    public void draw(Graphics2D g,ChessRoyale thisObj, int spot)
    {
        
    }
}
