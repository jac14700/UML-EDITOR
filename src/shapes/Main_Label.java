package shapes;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import utilities.Parameters;

public class Main_Label extends JPanel  {
	private static final long serialVersionUID = 1L;
	public Boolean selected = false;
	private int w_h_of_port = 12;
	public int mode;
	
	public void paintComponent (Graphics g)
    { 
		super.paintComponent(g);
    }
}