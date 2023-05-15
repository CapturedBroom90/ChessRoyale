package chessroyale;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

    public class ChessRoyale extends JFrame implements Runnable {
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    public boolean click = true;
    Highlight hi = null;
    int hix = 0;
    int hiy = 0;
    
    public static void main(String[] args) {
        ChessRoyale frame = new ChessRoyale();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public ChessRoyale() {
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton() && click == true) 
                {
                    click = false;
                    hi = new Highlight();
                    hix = e.getX();
                    hiy = e.getY();
                    
                    addKeyListener(new KeyAdapter(){
                        public void keyPressed(KeyEvent a) {

                                if (a.VK_1 == a.getKeyCode()) 
                                {
                                    Board.addPiece(e.getX(),e.getY(), 0);
                                    click = true;
                                    hi = null;
                                } 
                                else if (a.VK_2 == a.getKeyCode()) 
                                {
                                    Board.addPiece(e.getX(),e.getY(), 1);
                                    click = true;
                                    hi = null;
                                } 
                                else if (a.VK_3 == a.getKeyCode()) 
                                {
                                    Board.addPiece(e.getX(),e.getY(), 2);
                                    click = true;
                                    hi = null;
                                } 
                                else if (a.VK_4 == a.getKeyCode()) 
                                {
                                    Board.addPiece(e.getX(),e.getY(), 3);
                                    click = true;
                                    hi = null;
                                } 


                            
                            repaint();
                        }
                    });
                }
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {


                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                }  
                else if (e.VK_ENTER == e.getKeyCode())
                {
                    Board.skip();
                }else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }



                repaint();
            }
        });
        
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(Color.blue);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.black);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        
        Deck.draw(g, this);
        
        if(hi != null)
            hi.draw(g, hix, hiy);
        
        
        Board.Draw(g, this);
        

        if(Player.getCurrentPlayer().getColor() == Player.getPlayer1().getColor())
        {
            g.drawString("Player1 Turn", 250, 65);
        }
        else
            g.drawString("Player2 Turn", 250, 65);
        
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Board.Reset();
        Player.Reset();
        Deck.reset();
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            
            Pawn.Init();
            King.Init();
            Bishop.Init();
            Rook.Init();
            Knight.Init();
            Queen.Init();
            
            reset();
            
        }

        
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
}   
