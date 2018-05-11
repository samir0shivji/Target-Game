import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*; 
import java.awt.Font.*;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends JFrame implements ActionListener
{
    private JLabel label1, label2;
    private JButton button1;
    private int counter;
    private int fishX, fishY;
    private Timer timer;
    private Font font;
    private Color color;
    // instance variables - replace the example below with your own
    private int x;
    public static void main(String[] args)
    {
        Game game = new Game();
    }

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
     
        Container container = getContentPane();
        container.setLayout( new BorderLayout());
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("background.png"));
        container.add(background);
        ImageIcon icon = new ImageIcon("exit.jpg");
        button1 = new JButton(icon);
        button1.addActionListener(this);
        
        background.add(button1);
        button1.setBounds(1000, 530, 100, 100);
        addKeyListener( new KeyHandler());

        addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    System.exit(0);
                }
            });


       
        setSize(1240, 680);
        setVisible(true);

        // construction a Swing timer that goes off every 1000 msec (1 sec)
        timer = new javax.swing.Timer(1000, this);
        // timer starts here

    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Font font = new Font( "Comic Sans MS", Font.BOLD, 80 );
        g.setFont(font);
        g.setColor(color.WHITE);
        g.drawString("Score: ", 30, 632);
        g.drawString("Time: ", 500, 632);
    }
    public void actionPerformed(ActionEvent evt) 
    {
        if(evt.getSource()==button1)
        {
            requestFocusInWindow();

            timer.start();

        }
        else
        {
            if (fishX >= 540)
            {
                fishX = 0;
            }
            if(fishY >= 540)
            {
                fishY = 0;
            }
            fishY += 20;
            repaint();
            if(fishX >= 540)
            {
                fishX = 0;
            }
            if(fishX < 0)
            {
                fishX = 540;
            }
        }

        // move fish across and down screen
        // need to tell the Repaint Manager that the fish has moved:
        repaint();
        // counting the seconds 
        counter++;
        System.out.println("time is " + counter);
    }

    class BackgroundPanel extends Panel
    {
        Image img;
        public BackgroundPanel()
        {
            // Loads the background image and stores in img object.
            img = Toolkit.getDefaultToolkit().createImage("background.png");
        }

        public void paint (Graphics g )
        {
            // call superclass's paint method
            super.paint(g);
            g.drawImage(img, 0, 0, null);
            // location of fish changes each time the timer goes off
           
        }
    }

    private class KeyHandler implements KeyListener
    {
        public void keyPressed ( KeyEvent event )
        {

            // message shows up in text area; note that
            // method getKeyCode() gets a 'virtual key code' of the key
            // pressed - for a list of virtual key constants, see online
            // documentation for class KeyEvent in java.awt.event;
            // method getKeyText() converts that code to a String containing
            // the name of the key pressed

            if (event.getKeyCode() == KeyEvent.VK_RIGHT)
            // sample code to test for a particular
            // virtual key code
            {
                fishX += 20;
                repaint();
            }
            if (event.getKeyCode() == KeyEvent.VK_LEFT)
            // sample code to test for a particular
            // virtual key code
            {
                fishX -= 20;
                repaint();
            }

        }    

        public void keyReleased (KeyEvent event )
        {
            // called when key is released after a keyPressed or keyTyped event
        }

        public void keyTyped (KeyEvent event )
        {
            // only responds to pressing "non-action" keys; (action keys
            // include arrow key, Home, etc)
        }
    }
}

  

