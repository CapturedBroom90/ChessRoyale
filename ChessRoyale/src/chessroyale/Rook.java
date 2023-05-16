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
