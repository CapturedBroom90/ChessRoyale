package chessroyale;
import java.awt.*;
public class Pawn extends Piece
{
    private static Image pawnBlackImage;
    private static Image pawnWhiteImage;
    private static int NUM_ROWS = 8;
    private static int NUM_COLUMNS = 5;
    private static Piece board[][] = new Pawn[NUM_ROWS][NUM_COLUMNS];
    
    Pawn(Color _color)
    {
        super(_color);
    }
    
    public static void Init()
    {
        pawnBlackImage = Toolkit.getDefaultToolkit().getImage("./pawnblack.GIF");
        pawnWhiteImage = Toolkit.getDefaultToolkit().getImage("./pawnwhite.GIF");
    }
    
    public String getType()
    {
        return("Pawn");
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
            g.drawImage(pawnBlackImage,column*xdelta+55,row*ydelta+75,xdelta-50,ydelta-10,thisObj);

        if(super.getColor() == Color.white)
            g.drawImage(pawnWhiteImage,column*xdelta+55,row*ydelta+75,xdelta-50,ydelta-10,thisObj);
    }
    
    public void draw(Graphics2D g,ChessRoyale thisObj, int spot) {
 
        if(super.getColor() == Color.black && spot == 0)
            g.drawImage(pawnBlackImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 1)
            g.drawImage(pawnBlackImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 2)
            g.drawImage(pawnBlackImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 3)
            g.drawImage(pawnBlackImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        
        if(super.getColor() == Color.white && spot == 0)
            g.drawImage(pawnWhiteImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 1)
            g.drawImage(pawnWhiteImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 2)
            g.drawImage(pawnWhiteImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 3)
            g.drawImage(pawnWhiteImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
    }
        
}
