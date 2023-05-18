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
    
    int xpos = 0;
    int ypos = 0;
    
    int ogxpos = 0;
    int ogypos = 0;
    
    int newxpos = 0;
    int newypos = 0;
    
    public static boolean placePhase = true;
    public static boolean movePhase = false;
    
    public static void main(String[] args) {
        ChessRoyale frame = new ChessRoyale();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public ChessRoyale() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton() && click == true && placePhase) 
                {
                    int ydelta = Window.getHeight2()/Board.getNumRows();
                    int xdelta = Window.getWidth2()/Board.getNumCols();
                    int xpixelOffset = e.getX() - Window.getX(0);
                    int ypixelOffset = e.getY() - Window.getY(0);

                    if (xpixelOffset < 0 || xpixelOffset > Window.getWidth2() ||
                    ypixelOffset < 0 || ypixelOffset > Window.getHeight2())
                        return;
                    
                    click = false;
                    hi = new Highlight();
                    hix = e.getX();
                    hiy = e.getY();
                    xpos = e.getX();
                    ypos = e.getY();
                    addKeyListener(new KeyAdapter(){
                        public void keyPressed(KeyEvent a) {

                                if (a.VK_1 == a.getKeyCode()) 
                                {
                                    Board.addPiece(xpos,ypos, 0);
                                    click = true;
                                    hi = null;
                                } 
                                else if (a.VK_2 == a.getKeyCode()) 
                                {
                                    Board.addPiece(xpos,ypos, 1);
                                    click = true;
                                    hi = null;
                                } 
                                else if (a.VK_3 == a.getKeyCode()) 
                                {
                                    Board.addPiece(xpos,ypos, 2);
                                    click = true;
                                    hi = null;
                                } 
                                else if (a.VK_4 == a.getKeyCode()) 
                                {
                                    Board.addPiece(xpos,ypos, 3);
                                    click = true;
                                    hi = null;
                                } 
                            repaint();
                        }
                    });
                }
            }
        });
        
    addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            if (e.BUTTON1 == e.getButton() && movePhase)
            {
                if(Board.CheckSpot(e.getX(), e.getY()))
                { 

                    String type = Board.pieceType(e.getX(), e.getY());
                    ogxpos = e.getX();
                    ogypos = e.getY();
                    hi = new Highlight();
                    hix = e.getX();
                    hiy = e.getY();
                    addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent a) 
                        {
                            if (a.BUTTON1 == a.getButton())
                            {
                                if(!Board.CheckSpot(a.getX(), a.getY()))
                                {
                                    newxpos = a.getX();
                                    newypos = a.getY();
                                    Board.move(ogxpos, ogypos, newxpos, newypos);
                                    hi = null;
                                }
                            }

                        }
                    });
                }
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
                else if (e.VK_SPACE == e.getKeyCode())
                {
                    xpos = 0;
                    ypos = 0;
                    click = true;
                    hi = null;
                }
                else if (e.VK_ENTER == e.getKeyCode())
                {
                    if(placePhase)
                    { 
                        placePhase = false;
                        movePhase = true;
                    }
                    else 
                    {
                        Board.EndTurn();
                        placePhase = true;
                        movePhase = false;
                    }
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
        
        g.setColor(Color.black);
        g.setFont (new Font ("Times New Roman",Font.PLAIN, 20));
        if(Player.getCurrentPlayer().getColor() == Player.getPlayer1().getColor())
        {
            g.drawString("Player 1 Turn", 225, 65);
        }
        else
            g.drawString("Player 2 Turn", 225, 65);
        
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
