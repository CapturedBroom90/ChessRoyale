//Board.java=====================
package chessroyale;
import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 8;
    private final static int NUM_COLUMNS = 5;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private final static int NUM_WIN = 3;
    private static int scoreVal = 0;
    
    public static void Reset() {
//clear the board.
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
                board[zrow][zcol] = null;  
        
//starting board
        board[NUM_ROWS-1][NUM_COLUMNS/2] = new King(Color.white);
        board[NUM_ROWS-1][NUM_COLUMNS/2+1] = new Pawn(Color.white);
        board[NUM_ROWS-1][NUM_COLUMNS/2-1] = new Pawn(Color.white);
        board[NUM_ROWS-2][NUM_COLUMNS/2] = new Pawn(Color.white);
        board[NUM_ROWS-2][NUM_COLUMNS/2+1] = new Pawn(Color.white);
        board[NUM_ROWS-2][NUM_COLUMNS/2-1] = new Pawn(Color.white);
        
        board[0][NUM_COLUMNS/2] = new King(Color.black);
        board[0][NUM_COLUMNS/2+1] = new Pawn(Color.black);
        board[0][NUM_COLUMNS/2-1] = new Pawn(Color.black);
        board[1][NUM_COLUMNS/2] = new Pawn(Color.black);
        board[1][NUM_COLUMNS/2+1] = new Pawn(Color.black);
        board[1][NUM_COLUMNS/2-1] = new Pawn(Color.black);
    }
    public static void addPiece(int xpixel,int ypixel, int slot) 
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
       
        
        if(Deck.deck[slot].getType().equals("Queen") && board[row][col]==null)
        {
            board[row][col] = new Queen(Player.getCurrentPlayer().getColor());  
            Elixer.addElixer();
            Player.switchCurrentPlayer();
        }
        else if(Deck.deck[slot].getType().equals("Bishop") && board[row][col]==null)
        {
            board[row][col] = new Bishop(Player.getCurrentPlayer().getColor());  
            Elixer.addElixer();
            Player.switchCurrentPlayer();
        }
        else if(Deck.deck[slot].getType().equals("Rook") && board[row][col]==null)
        {
            board[row][col] = new Rook(Player.getCurrentPlayer().getColor());  
            Elixer.addElixer();
            Player.switchCurrentPlayer();
        }
        else if(Deck.deck[slot].getType().equals("Knight") && board[row][col]==null)
        {
            board[row][col] = new Knight(Player.getCurrentPlayer().getColor());  
            Elixer.addElixer();
            Player.switchCurrentPlayer();
        }
        else 
            return;
    }  
    public static void skip() 
    {
        Player.switchCurrentPlayer();
        Elixer.addElixer();
    }
    public static void Draw(Graphics2D g, ChessRoyale thisObj) {
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)        
            {
                if (board[zrow][zcol] != null)
                    board[zrow][zcol].draw(g, thisObj, zrow, zcol,xdelta, ydelta);
            }
        }   
    }
}
