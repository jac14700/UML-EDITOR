import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class mode_mouse extends JPanel  implements mode {
	private String mode = "mouse";
	private Point start_p = null
				, draging_p = null
				, end_p = null;
	private canvas_panel canvas;
	private  boolean mouseDragged;
	
	Graphics g;
	
	
	public mode_mouse(canvas_panel canvas)
	{
		this.canvas = canvas;
	}
	public void mouseClicked(MouseEvent arg0) {};
	public void mouseExited(MouseEvent arg0){};
	public void mouseEntered(MouseEvent arg0){};
	
	public void mousePressed(MouseEvent arg0){
		this.start_p = arg0.getPoint();
	};
	public void mouseReleased(MouseEvent arg0){
		
	};
	public void mouseDragged(MouseEvent arg0){
	}; 
	public void mouseMoved(MouseEvent arg0){}
	
	public String getMode()
	{
		return this.mode;
	}
	
}
