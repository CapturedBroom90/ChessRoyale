package chessroyale;
import java.awt.*;
public class Queen extends Piece
{
    private static Image queenBlackImage;
    private static Image queenWhiteImage;
    private static int NUM_ROWS = 8;
    private static int NUM_COLUMNS = 5;
    private static Piece board[][] = new Pawn[NUM_ROWS][NUM_COLUMNS];
    
    Queen(Color _color)
    {
        super(_color);
    }
    
    public static void Init()
    {
        queenBlackImage = Toolkit.getDefaultToolkit().getImage("./queenblack.GIF");
        queenWhiteImage = Toolkit.getDefaultToolkit().getImage("./queenwhite.GIF");
    }
    
    public String getType()
    {
        return("Queen");
    }
    
    public Color getColor()
    {
        return (super.getColor());
    }
    
    public void draw(Graphics2D g,ChessRoyale thisObj,int row,int column,int xdelta,int ydelta) {
 
        if(super.getColor() == Color.black)
            g.drawImage(queenBlackImage,column*xdelta+55,row*ydelta+72,xdelta-50,ydelta-5,thisObj);

        if(super.getColor() == Color.white)
            g.drawImage(queenWhiteImage,column*xdelta+55,row*ydelta+72,xdelta-50,ydelta-5,thisObj);
    }
    
    public void draw(Graphics2D g,ChessRoyale thisObj, int spot) {
 
        if(super.getColor() == Color.black && spot == 0)
            g.drawImage(queenBlackImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 1)
            g.drawImage(queenBlackImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 2)
            g.drawImage(queenBlackImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.black && spot == 3)
            g.drawImage(queenBlackImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        
        if(super.getColor() == Color.white && spot == 0)
            g.drawImage(queenWhiteImage,Window.getWidth2()/10,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 1)
            g.drawImage(queenWhiteImage,Window.getWidth2()/3,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 2)
            g.drawImage(queenWhiteImage,Window.getWidth2()*35/60,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
        else if(super.getColor() == Color.white && spot == 3)
            g.drawImage(queenWhiteImage,Window.getWidth2()*9/11,Window.WINDOW_HEIGHT*5/6,100,150,thisObj);
    }
    
        
}
