import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class mode_class implements mode {
	private String mode = "class";
				  
	private ObjectsContainer tmp_obj;
	private ArrayList<BasicObject> all_objs;
	private canvas_panel canvas;
	
	public mode_class(canvas_panel canvas ,ArrayList<BasicObject> all_objs)
	{
		this.canvas = canvas;
		this.all_objs = all_objs;
	}
	public void mouseClicked(MouseEvent arg0) {};
	public void mouseExited(MouseEvent arg0){};
	public void mouseEntered(MouseEvent arg0){};
	public void mousePressed(MouseEvent arg0){
		all_objs.add(new DrawClass(arg0.getPoint()));
		this.canvas.add(all_objs.get(all_objs.size()-1).label);
		this.canvas.repaint();
	};
	public void mouseReleased(MouseEvent arg0){};
	public void mouseDragged(MouseEvent e){}; 
	public void mouseMoved(MouseEvent e){}
	public String getMode()
	{
		return this.mode;
	}
}
