import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class mode_use_case extends JPanel  implements mode {
	private static final long serialVersionUID = 1L;
	private int mode_type =  Parameters.Button.user_case.ordinal();
	private canvas_panel canvas;
	
	public mode_use_case(canvas_panel canvas ) {
		this.canvas = canvas;
	}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {
		BasicObject tmp_obj = new DrawUseCase(arg0.getPoint());
		canvas_panel.all_objs_in_canvas.add(tmp_obj);
		recording_idx_in_all_objs_in_canvas_of_this_obj();
		ObjectsContainer tmp_container = new ObjectsContainer(tmp_obj);
		
		canvas_panel.array_of_groups.add(tmp_container);
		int idx_in_array_of_groups = canvas_panel.array_of_groups.size() -Parameters.subtract_one_for_right_index;
		Set_group_index_for_the_obj(idx_in_array_of_groups);
		canvas_panel.all_objs_in_canvas.add(tmp_obj);
		
		this.canvas.add(tmp_obj.main_label);
		this.canvas.repaint();
	}
	
	private void recording_idx_in_all_objs_in_canvas_of_this_obj() {
		int new_input_idx = canvas_panel.all_objs_in_canvas.size()-Parameters.subtract_one_for_right_index;
		canvas_panel.all_objs_in_canvas.get(new_input_idx).idx_in_all_objs_in_canvas = new_input_idx;
	}
	public void Set_group_index_for_the_obj(int idx) {
		canvas_panel.array_of_groups.get(idx).current_objs.get(0).idx_in_array_of_groups = idx;
		canvas_panel.array_of_groups.get(idx).current_objs.get(0).idx_in_current_objs = 0;
	}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public int getMode() {
		return this.mode_type;
	}

}
