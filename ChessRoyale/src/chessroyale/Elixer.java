
package chessroyale;

public class Elixer 
{
    private static int elixer = 10;
    public Elixer()
    {
        
    }
    public static int addElixer()
    {
        elixer += ((int)Math.random()*10)+1;
        if(elixer > 10)
            elixer = 10;
        return(elixer);
    }
}
