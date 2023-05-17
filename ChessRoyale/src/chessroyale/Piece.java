package chessroyale;

import java.awt.*;

public abstract class Piece 
{
    private Color color;
    Piece(Color _color)
    {
        color = _color;
    }
    public Color getColor()
    {
        return (color);
    }
    public String getType()
    {
        return(null);
    }
    
    public abstract boolean isPossibleMove(int ogrow, int ogcol, int row, int col, Piece board[][]);
    
    public abstract void draw(Graphics2D g, ChessRoyale thisObj, int row,int column,int xdelta,int ydelta);
    
    public abstract void draw(Graphics2D g,ChessRoyale thisObj, int spot);
}
