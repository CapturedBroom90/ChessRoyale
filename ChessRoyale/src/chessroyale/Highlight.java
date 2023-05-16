//Highlight.java
package chessroyale;
import java.awt.*;

public class Highlight 
{
    private final static int NUM_ROWS = 8;
    private final static int NUM_COLUMNS = 5;
    
    public Highlight()
    {
        
    }
    
    public void draw(Graphics2D g,int xpixel,int ypixel)
    {
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int xpixelOffset = xpixel - Window.getX(0);
        int ypixelOffset = ypixel - Window.getY(0);
        
        if (xpixelOffset < 0 || xpixelOffset > Window.getWidth2() ||
        ypixelOffset < 0 || ypixelOffset > Window.getHeight2())
            return;
        
        int row = ypixelOffset/ydelta;
        int col = xpixelOffset/xdelta;
        g.setColor(Color.green);
            g.fillRect(Window.getX(col*xdelta), Window.getY(row*ydelta), xdelta, ydelta);
    }        
}