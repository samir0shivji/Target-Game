import java.awt.*;          // access to Container

import java.awt.event.*;
import javax.swing.*;
    // access to WindowAdapter, WindowEvent


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
        setContentPane(new JLabel(new ImageIcon("background.png")));
     
        label1 = new JLabel("Score");
       
       
        JPanel panel = new JPanel(new GridLayout());
        panel.add(label1);
       
        container.add(panel, BorderLayout.NORTH);
        

        addKeyListener( new KeyHandler());

        addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    System.exit(0);
                }
            });

        // initial location of fish
        //         fishX = 300; 
        //         fishY = 100;

       
        setSize(1240, 680);
        setVisible(true);

        // construction a Swing timer that goes off every 1000 msec (1 sec)
        timer = new javax.swing.Timer(1000, this);
        // timer starts here

    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawOval(50, 50, 100, 100);
        
    }
    public void act() 
    {
 //   	addObject(new Target(), Target.getRandomNumber(getWidth(), Target.getRandomNumber(getHeight()));
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

  
