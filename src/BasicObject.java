import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

class BasicObject extends JPanel{
	private static final long serialVersionUID = 1L;
	public Point start,end ,center;
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
		this.center = new Point();
		
		add_mouse_listener_to_main_label(this);
	}
	protected void add_mouse_listener_to_main_label (BasicObject obj) {
		this.main_label.addMouseListener(
		new MouseListener() {

			private Point m_start = new Point(0,0);
			private Point m_end = new Point(0,0);
			public void mouseClicked(MouseEvent event){}
			public void mouseExited(MouseEvent event){}
			public void mouseEntered(MouseEvent event){}
			public void mousePressed(MouseEvent event){
				
				m_start = get_real_location(event.getPoint());
				if(buttons.idx_which_is_chosen == Parameters.Button.mouse.ordinal())
				{
					canvas_panel.unselect_all_obj();
					System.out.println("this obj belong to " + idx_in_array_of_groups + "group.");
					select_the_entire_group();
                }
			}
			
			public void mouseReleased(MouseEvent event) {
				if(buttons.idx_which_is_chosen == Parameters.Button.mouse.ordinal()){
					m_end = get_real_location(event.getPoint());
					move_the_entire_chosen_group(m_start,m_end);
				}
			}
			private void up_date_obj_points(Point pressed_p, Point released_p, int g_index, int obj_index) {
				int move_x = released_p.x - pressed_p.x;
				int move_y = released_p.y - pressed_p.y;
				canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).start.x = canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).start.x + move_x;
				canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).start.y = canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).start.y + move_y;
				canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).center.x = canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).start.x + canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).size.height/2;
				canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).center.y = canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).start.y + canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).size.width/2;
			}
			private Point get_real_location(Point point_i) {
				point_i.x = BasicObject.this.start.x + point_i.x;
				point_i.y = BasicObject.this.start.y + point_i.y;
				return point_i;
			}
			private void move_the_entire_chosen_group(Point pressed_p, Point released_p) {
				for(int g_index =0; g_index < canvas_panel.chosen_groups.size(); g_index++) {
					for(int obj_index =0;obj_index <canvas_panel.chosen_groups.get(g_index).current_objs.size(); obj_index++) {
						up_date_obj_points(m_start,m_end,g_index,obj_index);
						canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).main_label.setLocation(canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).center.x,canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).center.y);
					}
				}
			}
		});
	}
	
	private void select_the_entire_group(){
		canvas_panel.chosen_groups.clear();
		canvas_panel.chosen_group_idx.clear();
		int selected_group = this.idx_in_array_of_groups;
		canvas_panel.chosen_groups.add(canvas_panel.array_of_groups.get(selected_group));
		canvas_panel.chosen_group_idx.add(selected_group);
		
		repainting_every_obj_in_the_container(selected_group);
	}
	private void repainting_every_obj_in_the_container(int selected_group) {
		for(int obj_idx = 0; obj_idx < canvas_panel.array_of_groups.get(selected_group).current_objs.size(); obj_idx++) {
			BasicObject tmp_obj = canvas_panel.array_of_groups.get(selected_group).current_objs.get(obj_idx);
			tmp_obj.main_label.select_this_object();
		}
	}
}