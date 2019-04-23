import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class mode_mouse extends JPanel  implements mode {
	private int mode = Parameters.Button.mouse.ordinal();
	private Point start_p = null
				, draging_p = null
				, end_p = null;
	private canvas_panel canvas;
	
	Graphics g;
	
	
	public mode_mouse(canvas_panel canvas)
	{
		this.canvas = canvas;
	}
	public void mouseClicked(MouseEvent event) {};
	public void mouseExited(MouseEvent event){};
	public void mouseEntered(MouseEvent event){
	};
	
	public void mousePressed(MouseEvent event){
		//Boolean tmp = check_if_in_any_class(event);
		this.canvas.unselect_all_obj();
	};
	public void mouseReleased(MouseEvent event){
		
	};
	public void mouseDragged(MouseEvent event){
	}; 
	public void mouseMoved(MouseEvent event){}
	
	public int getMode()
	{
		return this.mode;
	}
	
	private Boolean check_if_in_any_class(MouseEvent event)
	{
		for(int index = 0; index < this.canvas.all_objs_in_canvas.size(); index++){
			if(check_if_point_in_the_rect(event.getPoint(),
										  this.canvas.all_objs_in_canvas.get(index).start,
										  this.canvas.all_objs_in_canvas.get(index).end))
				{return true;}
			}
		return false;
	}
	private Boolean check_if_point_in_the_rect(Point mouse_p, Point start_p, Point end_p)
	{
		if( mouse_p.x > start_p.x && mouse_p.y > start_p.y&&
			mouse_p.x < end_p.x   && mouse_p.y < end_p.y)
			{return true;}
		
		return false;
	}
}
