package modes;
import java.awt.event.MouseEvent;

import panels.canvas_panel;
import shapes.BasicObject;
import shapes.DrawClass;
import shapes.ObjectsContainer;
import utilities.Parameters;

public class mode_class extends mode {
	private static final long serialVersionUID = 1L;
	private int mode_type =  Parameters.Button.draw_class.ordinal();
	private canvas_panel canvas;
	
	public mode_class(canvas_panel canvas) {
		this.canvas = canvas;
	}
	public void mousePressed(MouseEvent arg0) {
		BasicObject tmp_obj = new DrawClass(arg0.getPoint(),canvas);
		canvas_panel.all_objs_in_canvas.add(tmp_obj);
		recording_idx_in_all_objs_in_canvas_of_this_obj();
		ObjectsContainer tmp_container = new ObjectsContainer(tmp_obj);
		
		canvas_panel.array_of_groups.add(tmp_container);
		int idx_in_array_of_groups = canvas_panel.array_of_groups.size() -Parameters.subtract_one_for_right_index;
		Set_group_index_for_the_obj(idx_in_array_of_groups);
		canvas_panel.all_objs_in_canvas.add(tmp_obj);
		
		this.canvas.add(tmp_obj.main_label);
	};
	private void recording_idx_in_all_objs_in_canvas_of_this_obj() {
		int new_input_idx = canvas_panel.all_objs_in_canvas.size()-Parameters.subtract_one_for_right_index;
		canvas_panel.all_objs_in_canvas.get(new_input_idx).idx_in_all_objs_in_canvas = new_input_idx;
	}
	public void Set_group_index_for_the_obj(int idx) {
		canvas_panel.array_of_groups.get(idx).current_objs.get(0).idx_in_array_of_groups = idx;
		canvas_panel.array_of_groups.get(idx).current_objs.get(0).idx_in_current_objs = 0;
	}
	public int getMode()
	{
		return this.mode_type;
	}
	
}
