import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class mode_class implements mode {
	private int mode_type =  Parameters.Button.draw_class.ordinal();
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
		BasicObject tmp_obj = new DrawClass(arg0.getPoint());
		ObjectsContainer tmp_container = new ObjectsContainer(tmp_obj);
		
		canvas_panel.array_of_groups.add(tmp_container);
		int idx_in_array_of_groups = canvas_panel.array_of_groups.size() -Parameters.subtract_one_for_right_index;
		Set_group_index_for_the_obj(idx_in_array_of_groups);
		canvas_panel.all_objs_in_canvas.add(tmp_obj);
		
		this.canvas.add(tmp_obj.main_label);
		this.canvas.repaint();
	};
	public void Set_group_index_for_the_obj(int idx) {
		canvas_panel.array_of_groups.get(idx).current_objs.get(0).idx_in_array_of_groups = idx;
	}
	public void mouseReleased(MouseEvent arg0){};
	public void mouseDragged(MouseEvent e){}; 
	public void mouseMoved(MouseEvent e){}
	public int getMode()
	{
		return this.mode_type;
	}
}
