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
    
    public boolean isPossibleMove(int ogrow, int ogcol, int row, int col, Piece board[][])
    {
        int ymove = 0;
        int xmove = 0;
        boolean canMove = true;
        if(ogrow < row && ogcol < col)
        {
            for(int i = ogrow; i <= row; i++)
            {   
                ymove++;
            }
            for(int j = ogcol; j <= col; j++)
            {
                xmove++;
            }
            while(ogrow < row && ogcol < col)
            {
                ogrow++;
                ogcol++;
                if(board[ogrow][ogcol] != null && board[ogrow][ogcol] != board[row][col])
                {
                    canMove = false;
                }
            }
            if(xmove == ymove && canMove)
                return true;
        }
        
        else if(ogrow > row && ogcol < col)
        {
            for(int i = ogrow; i >= row; i--)
            {   
                ymove++;
            }
            for(int j = ogcol; j <= col; j++)
            {
                xmove++;
            }
            while(ogrow > row && ogcol < col)
            {
                ogrow--;
                ogcol++;
                if(board[ogrow][ogcol] != null && board[ogrow][ogcol] != board[row][col])
                {
                    canMove = false;
                }
            }
            if(xmove == ymove && canMove)
                return true;
        }
        
        else if(ogrow > row && ogcol > col)
        {
            for(int i = ogrow; i >= row; i--)
            {   
                ymove++;
            }
            for(int j = ogcol; j >= col; j--)
            {
                xmove++;
            }
            while(ogrow > row && ogcol > col)
            {
                ogrow--;
                ogcol--;
                if(board[ogrow][ogcol] != null && board[ogrow][ogcol] != board[row][col])
                {
                    canMove = false;
                }
            }
            if(xmove == ymove && canMove)
                return true;
        }
        
        else if(ogrow < row && ogcol > col)
        {
            for(int i = ogrow; i <= row; i++)
            {   
                ymove++;
            }
            for(int j = ogcol; j >= col; j--)
            {
                xmove++;
            }
            while(ogrow < row && ogcol > col)
            {
                ogrow++;
                ogcol--;
                if(board[ogrow][ogcol] != null && board[ogrow][ogcol] != board[row][col])
                {
                    canMove = false;
                }
            }
            if(xmove == ymove && canMove)
                return true;
        }
        
        else if(ogrow < row && ogcol == col)
        {
            int count = 0;
            for(int i = ogrow+1; i <= row; i++)
            {
                if(board[i][col] == null)
                {
                    count++;
                     
                }
                if(board[i][col] != null && i < row)
                {
                    canMove = false;
                }
                if(board[i][col] != null)
                {
                    if(board[i][col].getColor() != Player.getCurrentPlayer().getColor() && canMove)
                    {
                        return true;
                    }
                }
            }
            if(count == row-ogrow && canMove == true)
            {
                return true;
            }
        }
        
        
        
        else if(row < ogrow && ogcol == col)
        {
            int count = 0;
            for(int i = ogrow-1; i >= row; i--)
            {
                if(board[i][col] == null || board[i][col].getColor() != Player.getCurrentPlayer().getColor())
                {
                    count++;
                }
                
                if(board[i][col] != null && i > row)
                {
                    canMove = false;
                }
                if(board[i][col] != null)
                {
                    if(board[i][col].getColor() != Player.getCurrentPlayer().getColor() && canMove)
                    {
                        return true;
                    }
                }
            }
            if(count == ogrow-row  && canMove == true)
            {
                return true;
            }
        }
        
        
        
        else if(ogcol < col && ogrow == row)
        {
            int count = 0;
            for(int i = ogcol+1; i <= col; i++)
            {
                if(board[row][i] == null)
                {
                    count++;
                }
                
                if(board[row][i] != null && i < col)
                {
                    canMove = false;
                }
                if(board[row][i] != null)
                {
                    if(board[row][i].getColor() != Player.getCurrentPlayer().getColor() && canMove)
                    {
                        return true;
                    }
                }
            }
            if(count == col-ogcol && canMove == true)
            {
                
                return true;
            }
        }
        
        
        
        else if(col < ogcol && ogrow == row)
        {
            int count = 0;
            for(int i = ogcol-1; i >= col; i--)
            {
                if(board[row][i] == null)
                {
                    count++;
                }
                if(board[row][i] != null && i > col)
                {
                    canMove = false;
                }
                if(board[row][i] != null)
                {
                    if(board[row][i].getColor() != Player.getCurrentPlayer().getColor() && canMove)
                    {
                        return true;
                    }
                }
            }
            if(count == ogcol-col && canMove == true)
            {
                return true;
            }
        }
        return false;
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
