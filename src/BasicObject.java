import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

class BasicObject extends JPanel{
	private static final long serialVersionUID = 1L;
	protected Point start,end;
	public Main_Label main_label = new Main_Label();
	protected JLabel message= new JLabel();
	protected Dimension size;
	protected int idx_in_array_of_groups = Parameters.nonGroup;
	
	BasicObject(){
	 init();
	}
	BasicObject(Point start){
		init(start);
	}
	protected void init()
	{
		add_mouse_listener_to_main_label(this);
	}
	protected void init(Point start)
	{
		this.start = start;
		add_mouse_listener_to_main_label(this);
	}
	protected void add_mouse_listener_to_main_label (BasicObject obj) {
		this.main_label.addMouseListener(
		new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
				
				if(buttons.idx_which_is_chosen == Parameters.Button.mouse.ordinal())
				{
					System.out.println();
					
					canvas_panel.unselect_all_obj();
					System.out.println("this obj belong to " + idx_in_array_of_groups + "group.");
					select_the_entire_group();
					
				}
			}
			public void mouseReleased(MouseEvent arg0) {
			}
		});
	}
	
	protected void select_the_entire_group(){
		canvas_panel.chosen_groups.clear();
		canvas_panel.chosen_group_idx.clear();
		
		int selected_group = this.idx_in_array_of_groups;
		System.out.println(this.idx_in_array_of_groups);
		System.out.println("array_of_groups size: " + canvas_panel.array_of_groups.size());
		ObjectsContainer tmp_container = canvas_panel.array_of_groups.get(selected_group);
		canvas_panel.chosen_groups.add(tmp_container);
		canvas_panel.chosen_group_idx.add(selected_group);
		
		repainting_every_obj_in_the_container(tmp_container);
	}
	private void repainting_every_obj_in_the_container(ObjectsContainer tmp_container) {
		for(int obj_idx = 0; obj_idx < tmp_container.current_objs.size(); obj_idx++) {
			BasicObject tmp_obj = tmp_container.current_objs.get(obj_idx);
			tmp_obj.main_label.select_this_object();
		}
	}
}