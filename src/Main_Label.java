import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Main_Label extends JPanel  {
	private static final long serialVersionUID = 1L;
	public Boolean selected = false;
	private int w_h_of_port = 12;

	public void unselected_this_obj(){
		this.selected = false;
		this.setBorder(null);
	}
	//不是這個方式運作
	public void select_this_object(){
		this.selected = true;
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		this.setBorder(border);
	}
	public void paintComponent (Graphics g)
    { 
	    super.paintComponent(g);
	    if(this.selected) {
		    g.setColor(Color.RED);
		    g.fillOval(0 - w_h_of_port/2, 50 - w_h_of_port/2, w_h_of_port, w_h_of_port);
		    g.fillOval(50 - w_h_of_port/2, 0 - w_h_of_port/2, w_h_of_port, w_h_of_port);
		    g.fillOval(50 - w_h_of_port/2, 100 - w_h_of_port/2, w_h_of_port, w_h_of_port);
		    g.fillOval(100 - w_h_of_port/2, 50 - w_h_of_port/2, w_h_of_port, w_h_of_port);
	    }
} 
}
