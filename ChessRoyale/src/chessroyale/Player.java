package chessroyale;
 
import java.awt.Color;
public class Player {
    private static int numPlayers = 2;
    private static Player players[] = new Player[numPlayers];
    private static Player currentPlayer;
    private Color color;  
    private int score = 0;
    private static int elixir = 10;
    
//Class methods.    
    public static void Reset() {
//If we have not created any instances yet, create the instances of the 2 players.
//Have the first player be the current player.
        elixir = 10;
    
        if (players[0] == null) {
          players[0] = new Player(Color.white);
          players[1] = new Player(Color.black);            
        }
        currentPlayer = players[0];
    }    
    public static Player getCurrentPlayer() 
    {
        return (currentPlayer);
    }
    public static void switchCurrentPlayer() {
        if (currentPlayer == players[0])
            currentPlayer = players[1];
        else
            currentPlayer = players[0];
        
        Deck.randomize();
    }
    public static Player getPlayer1() {
        return(players[0]);
    }
    public static Player getPlayer2() {
        return(players[1]);
    } 
    
    public Player(Color _color) {
        color = _color;
    }    
//accessor methods.    
    public Color getColor() {
        return(color);
    }
    public int getElixir()
    {
        return elixir;
    }
//mutator methods.    
    public void addElixir()
    {
        elixir += (int)(Math.random()*10)+1;
        if(elixir > 10)
            elixir = 10;
    }
    public void subElixir(int sub)
    {
        elixir -= sub;
    }
}
