//Board.java=====================
package chessroyale;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board {
    private final static int NUM_ROWS = 8;
    private final static int NUM_COLUMNS = 5;      
    private static Piece board[][] = new Piece[NUM_ROWS][NUM_COLUMNS];
    private final static int NUM_WIN = 3;
    
    private static boolean place1 = false;
    private static boolean place2 = false;
    private static boolean place3 = false;
    private static boolean place4 = false;
    
    private static sound pieceNoise = null;
    
    
    static int ecolumns = 10;
    static int erows = 1;
    
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
    
    public static boolean placeOnOwnSide(int xpixel,int ypixel) 
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
        
        if(Player.getCurrentPlayer() == Player.getPlayer1())
        {
            if(row >= 4)
                return true;
        }
        else
        {
            if(row < 4)
                return true;
        }
        return false;
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
                pieceNoise = new sound("woman.wav");
                Player.getCurrentPlayer().subElixir(9);
            }
            else if(Deck.deck[slot].getType().equals("Bishop") && board[row][col]==null && Player.getCurrentPlayer().getElixir() >= 3)
            {
                board[row][col] = new Bishop(Player.getCurrentPlayer().getColor());  
                pieceNoise = new sound("bishop.wav");
                Player.getCurrentPlayer().subElixir(3);
            }
            else if(Deck.deck[slot].getType().equals("Rook") && board[row][col]==null && Player.getCurrentPlayer().getElixir() >= 5)
            {
                board[row][col] = new Rook(Player.getCurrentPlayer().getColor());  
                pieceNoise = new sound("rook.wav");
                Player.getCurrentPlayer().subElixir(5);
            }
            else if(Deck.deck[slot].getType().equals("Knight") && board[row][col]==null && Player.getCurrentPlayer().getElixir() >= 3)
            {
                board[row][col] = new Knight(Player.getCurrentPlayer().getColor());  
                pieceNoise = new sound("knight.wav");
                Player.getCurrentPlayer().subElixir(3);
            }
            else 
                return;
    }  
    public static void EndTurn() 
    {
        Player.switchCurrentPlayer();
        Player.getCurrentPlayer().addElixir();
        ChessRoyale.placePhase = true;
        ChessRoyale.movePhase = false;
        ChessRoyale.pressed1 = false;
        ChessRoyale.pressed2 = false;
        ChessRoyale.pressed3 = false;
        ChessRoyale.pressed4 = false;
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
        
        if(board[ogrow][ogcol] != null)
        {
            if(board[ogrow][ogcol].isPossibleMove(ogrow, ogcol, row, col, board))
            {
                if(board[row][col] != null)
                {
                    if(board[row][col].getType().equals("King"))
                    {
                        if(Player.getCurrentPlayer() == Player.getPlayer1())
                        {
                            if(Player.getPlayer2().getLives() == 1)
                            {
                                board[row][col] = board[ogrow][ogcol];
                                board[ogrow][ogcol] = null;
                                pieceNoise = new sound("kinghit.wav");
                                pieceNoise = new sound("hornend.wav");
                                EndTurn();
                                Player.getCurrentPlayer().subLives();
                                return;
                            }
                        }
                        else if(Player.getCurrentPlayer() == Player.getPlayer2())
                        {
                            if(Player.getPlayer1().getLives() == 1)
                            {
                                board[row][col] = null;
                                pieceNoise = new sound("kinghit.wav");
                                pieceNoise = new sound("hornend.wav");
                                EndTurn();
                                Player.getCurrentPlayer().subLives();
                                return;
                            }
                        }
                        board[ogrow][ogcol] = null;
                        pieceNoise = new sound("kinghit.wav");
                        EndTurn();
                        Player.getCurrentPlayer().subLives();
                        return;
                    }
                    else if(board[row][col].getType().equals("King"))
                    {
                        
                    }
                }
                board[row][col] = board[ogrow][ogcol];
                board[ogrow][ogcol] = null;
                EndTurn();
            }
        }
        else
            return;
    }
    
    public static void Draw(Graphics2D g, ChessRoyale thisObj) 
    {
        
        Deck.draw(g, thisObj);
        
        
                
        
//draw grid
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        Color lilac = new Color(200, 162, 200, 125);
        g.setColor(lilac);
        for (int zrow=0;zrow<NUM_ROWS;zrow++)
        {
            for (int zcol=0;zcol<NUM_COLUMNS;zcol++)
            {
                if(zrow % 2 == 1 && zcol % 2 == 0 || zrow % 2 == 0 && zcol % 2 == 1 )
                g.fillRect(Window.getX(zcol*xdelta), Window.getY(zrow*ydelta), xdelta, ydelta);
            }
        }
                
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
        
        int _ydelta = Window.getHeight2()/erows;
        int _xdelta = Window.getWidth2()/ecolumns;
 
        
        
        g.setColor(Color.black);
        for (int zi = 1;zi<erows;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*_ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*_ydelta));
        }
        
        for (int zi = 1;zi<ecolumns;zi++)
        {
            g.drawLine(Window.getX(zi*_xdelta),Window.getY(Window.getHeight2()),
                    Window.getX(zi*_xdelta),Window.getY(780));
        }
        for (int zrow=0;zrow<erows;zrow++)
        {
            for (int zcol=0;zcol<1;zcol++)        
            {
                if (board[zrow][zcol] != null)
                    board[zrow][zcol].draw(g,thisObj, zrow, zcol,_xdelta, _ydelta);
            }
        }       
//        ecolumns -= Player.getCurrentPlayer().getElixir();
        for(int i = 0;i<ecolumns;i++)
        {
            g.setColor(Color.black);
            g.drawRect(Window.getX(i*50), Window.getY(761), _xdelta-1, 20);
            g.setColor(Color.white);
            g.fillRect(Window.getX(i*50), Window.getY(761), _xdelta-1, 20);
            
        }
        for(int j = 0;j<Player.getCurrentPlayer().getElixir();j++)
        {    
            g.setColor(Color.pink);
            g.fillRect(Window.getX(j*50), Window.getY(761), _xdelta-1, 20);
        }
    }
}
