//Board.java=====================
package chessroyale;
import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 8;
    private final static int NUM_COLUMNS = 5;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private final static int NUM_WIN = 3;
    private static int scoreVal = 0;
    
    public static void Reset() 
    {
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
    
    public static int getNumRows()
    {
        return(NUM_ROWS);
    }
    
    public static int getNumCols()
    {
        return(NUM_COLUMNS);
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
       
        
        if(Deck.deck[slot].getType().equals("Queen") && board[row][col]==null && Player.getCurrentPlayer().getElixir() >= 9)
        {
            board[row][col] = new Queen(Player.getCurrentPlayer().getColor());  
            Player.getCurrentPlayer().subElixir(9);
        }
        else if(Deck.deck[slot].getType().equals("Bishop") && board[row][col]==null && Player.getCurrentPlayer().getElixir() >= 3)
        {
            board[row][col] = new Bishop(Player.getCurrentPlayer().getColor());  
            Player.getCurrentPlayer().subElixir(3);
        }
        else if(Deck.deck[slot].getType().equals("Rook") && board[row][col]==null && Player.getCurrentPlayer().getElixir() >= 5)
        {
            board[row][col] = new Rook(Player.getCurrentPlayer().getColor());  
            Player.getCurrentPlayer().subElixir(5);
        }
        else if(Deck.deck[slot].getType().equals("Knight") && board[row][col]==null && Player.getCurrentPlayer().getElixir() >= 3)
        {
            board[row][col] = new Knight(Player.getCurrentPlayer().getColor());  
            Player.getCurrentPlayer().subElixir(3);
        }
        else 
            return;
    }  
    public static void EndTurn() 
    {
        Player.switchCurrentPlayer();
        Player.getCurrentPlayer().addElixir();
    }
    public static boolean CheckSpot(int xpixel,int ypixel) 
    {
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int xpixelOffset = xpixel - Window.getX(0);
        int ypixelOffset = ypixel - Window.getY(0);
        
        if (xpixelOffset < 0 || xpixelOffset > Window.getWidth2() ||
        ypixelOffset < 0 || ypixelOffset > Window.getHeight2())
            return false;
        
        int row = ypixelOffset/ydelta;
        int col = xpixelOffset/xdelta;  
        if(board[row][col] == null || board[row][col].getColor() != Player.getCurrentPlayer().getColor())
            return false;
        else
            return true;
    }
    public static String pieceType(int xpixel,int ypixel) 
    {
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int xpixelOffset = xpixel - Window.getX(0);
        int ypixelOffset = ypixel - Window.getY(0);
        
        int row = ypixelOffset/ydelta;
        int col = xpixelOffset/xdelta; 
        return board[row][col].getType();
    }
    public static void move(int ogxpixel,int ogypixel, int xpixel,int ypixel) 
    {
        int ogydelta = Window.getHeight2()/NUM_ROWS;
        int ogxdelta = Window.getWidth2()/NUM_COLUMNS;
        int ogxpixelOffset = ogxpixel - Window.getX(0);
        int ogypixelOffset = ogypixel - Window.getY(0);
        
        int ogrow = ogypixelOffset/ogydelta;
        int ogcol = ogxpixelOffset/ogxdelta; 
         
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int xpixelOffset = xpixel - Window.getX(0);
        int ypixelOffset = ypixel - Window.getY(0);
        
        int row = ypixelOffset/ydelta;
        int col = xpixelOffset/xdelta; 
        
        if(board[ogrow][ogcol].isPossibleMove(ogrow, ogcol, row, col, board))
        {
            board[row][col] = board[ogrow][ogcol];
            board[ogrow][ogcol] = null;
            EndTurn();
            ChessRoyale.placePhase = true;
            ChessRoyale.movePhase = false;
        }
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
