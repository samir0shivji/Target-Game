import java.util.*;
import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and Jcomponents
import javax.swing.event.*;

/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Target extends JFrame
{
    private JRadioButton button;
    
    public Target(Icon image)
    {
        button = new JRadioButton(image, true);
    }
    
    public JRadioButton getTarget()
    {
    	return button;
    }
    
}

