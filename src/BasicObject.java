import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

class BasicObject extends JPanel{
	private static final long serialVersionUID = 1L;
	public Point start,end ,center;
	public Point port_up, port_down, port_left, port_right;
	public Main_Label main_label = new Main_Label();
	protected JLabel message= new JLabel();
	protected Dimension size = new Dimension(100,100);
	protected int idx_in_array_of_groups = Parameters.nonGroup;
	protected int idx_in_current_objs = Parameters.nonGroup;
	protected int idx_in_all_objs_in_canvas = Parameters.nonGroup;
	
	BasicObject(){
		init();
	}
	BasicObject(Point start){
		init(start);
	}
	
	
	private void init(){
		add_mouse_listener_to_main_label(this);
	}
	private void init(Point start){
		init_points(start);
		add_mouse_listener_to_main_label(this);
	}
	private void init_points(Point start) {
		this.start = start;
		this.center = new Point(this.start.x +this.size.width/2, this.start.y +this.size.height/2);
		this.end = new Point(this.start.x +this.size.width, this.start.y +this.size.height);
		this.port_up = new Point(this.center.x,this.start.y);
		this.port_down = new Point(this.center.x,this.end.y);
		this.port_left = new Point(this.start.x,this.center.y);
		this.port_right = new Point(this.end.x,this.center.y);
	}
	
	public void move(Point move_p) {
		this.start.x = this.start.x + move_p.x;
		this.start.y = this.start.y + move_p.y;
		this.end.x = this.start.x +this.size.width;
		this.end.y = this.start.y +this.size.height;
		update_line_start_end_point(this.idx_in_all_objs_in_canvas,this.start);
	}
	
	private void update_line_start_end_point(int obj_idx, Point new_s) {
		line.move( obj_idx, new_s);	
	}
	
	protected void add_mouse_listener_to_main_label (BasicObject obj) {
		this.main_label.addMouseListener(
		new MouseListener() {

			private Point m_start = new Point(0,0);
			private Point m_end = new Point(0,0);
			public void mouseClicked(MouseEvent event){}
			public void mouseExited(MouseEvent event){
				if(canvas_panel.user_mode.getMode() == Parameters.Button.association_line.ordinal()){
					mode_association_line.entered_a_obj = false;
				}
				if(canvas_panel.user_mode.getMode() == Parameters.Button.gerneralization_line.ordinal()){
					mode_gerneralization_line.entered_a_obj = false;
				}
				if(buttons.idx_which_is_chosen == Parameters.Button.composition_line.ordinal()){
					mode_composition_line.entered_a_obj = false;
				}
			}
			public void mouseEntered(MouseEvent event){
				if(buttons.idx_which_is_chosen == Parameters.Button.association_line.ordinal()
					&&mode_association_line.dragged){
					mode_association_line.entered_a_obj = true;
					buffering_line_end_obj();
				}
				if(buttons.idx_which_is_chosen == Parameters.Button.gerneralization_line.ordinal()
					&&mode_gerneralization_line.dragged){
					mode_gerneralization_line.entered_a_obj = true;
					buffering_line_end_obj();
				}
				if(buttons.idx_which_is_chosen == Parameters.Button.composition_line.ordinal()
					&&mode_composition_line.dragged){
					mode_composition_line.entered_a_obj = true;
					buffering_line_end_obj();
				}
			}
			public void mouseDragged(MouseEvent event) {}
			public void mousePressed(MouseEvent event) {
				m_start = get_real_location(event.getPoint());
				
				if(buttons.idx_which_is_chosen == Parameters.Button.mouse.ordinal()){
					canvas_panel.unselect_all_obj();
					select_the_entire_group();
                }
				if(buttons.idx_which_is_chosen == Parameters.Button.association_line.ordinal()) {
					mode_association_line.dragged = true;
					buffering_line_start_obj();
				}
				if(buttons.idx_which_is_chosen == Parameters.Button.gerneralization_line.ordinal()) {
					mode_gerneralization_line.dragged = true;
					buffering_line_start_obj();
				}
				if(buttons.idx_which_is_chosen == Parameters.Button.composition_line.ordinal()) {
					mode_composition_line.dragged = true;
					buffering_line_start_obj();
				}
			}
			
			public void mouseReleased(MouseEvent event) {
				if(buttons.idx_which_is_chosen == Parameters.Button.mouse.ordinal()){
					m_end = get_real_location(event.getPoint());
					move_the_entire_chosen_group(m_start,m_end);
				}
				if(buttons.idx_which_is_chosen == Parameters.Button.association_line.ordinal()&&
				   mode_association_line.dragged&&
				   mode_association_line.entered_a_obj) {
				   canvas_panel.all_lines.add(new line(Parameters.association_line));
					repaint();
				}
				if(buttons.idx_which_is_chosen == Parameters.Button.gerneralization_line.ordinal()&&
  				   mode_gerneralization_line.dragged&&
  				   mode_gerneralization_line.entered_a_obj) {
				   canvas_panel.all_lines.add(new line(Parameters.gerneralization_line));
					repaint();
				}
				if(buttons.idx_which_is_chosen == Parameters.Button.composition_line.ordinal()&&
				   mode_composition_line.dragged&&
				   mode_composition_line.entered_a_obj) {
				   canvas_panel.all_lines.add(new line(Parameters.composition_line));
					repaint();
				}
				mode_association_line.dragged = false;
				mode_gerneralization_line.dragged = false;
				mode_composition_line.dragged = false;
			}
			
					private void buffering_line_start_obj() {
						Parameters.line_start_obj_idx = BasicObject.this.idx_in_all_objs_in_canvas;
					}
					private void buffering_line_end_obj() {
						Parameters.line_end_obj_idx = BasicObject.this.idx_in_all_objs_in_canvas;
					}
					private void up_date_obj_points(Point pressed_p, Point released_p, int chosen_g_idx_of_array_groups, int obj_index, int g_index) {
						Point move = new Point(released_p.x - pressed_p.x,released_p.y - pressed_p.y);
						Point obj_start = canvas_panel.array_of_groups.get(chosen_g_idx_of_array_groups).current_objs.get(obj_index).start;
						
						adjust_array_of_groups_points_stuffs(chosen_g_idx_of_array_groups, obj_index, move, obj_start);
					}
				
					private void adjust_array_of_groups_points_stuffs(int chosen_g_idx_of_array_groups, int obj_index, Point move, Point obj_start) {
						canvas_panel.array_of_groups.get(chosen_g_idx_of_array_groups).current_objs.get(obj_index).move(move);
					}
					private Point get_real_location(Point point_i) {
						point_i.x = BasicObject.this.start.x + point_i.x;
						point_i.y = BasicObject.this.start.y + point_i.y;
						return point_i;
					}
					private void move_the_entire_chosen_group(Point pressed_p, Point released_p) {
						adjusting_objs(pressed_p,released_p);
						adjusting_connected_line();
					}
					private void adjusting_objs(Point pressed_p, Point released_p) {
						for(int g_index =0; g_index < canvas_panel.chosen_group_idx.size(); g_index++) {
							int chosen_g_idx_of_array_groups = canvas_panel.chosen_group_idx.get(g_index);
							for(int obj_index =0;obj_index <canvas_panel.chosen_groups.get(g_index).current_objs.size(); obj_index++) {
								up_date_obj_points(m_start,m_end,chosen_g_idx_of_array_groups,obj_index,g_index);
								canvas_panel.array_of_groups.get(chosen_g_idx_of_array_groups).current_objs.get(obj_index).main_label.setLocation(canvas_panel.array_of_groups.get(chosen_g_idx_of_array_groups).current_objs.get(obj_index).start.x,
																																	canvas_panel.array_of_groups.get(chosen_g_idx_of_array_groups).current_objs.get(obj_index).start.y);
							}
						}
					}
					private void adjusting_connected_line() {
						
					}
		});
	}
	
	private void select_the_entire_group(){
		canvas_panel.chosen_groups.clear();
		canvas_panel.chosen_group_idx.clear();
		int current_selected_group = this.idx_in_array_of_groups;
		canvas_panel.chosen_groups.add(canvas_panel.array_of_groups.get(current_selected_group));
		canvas_panel.chosen_group_idx.add(current_selected_group);
		
		repainting_every_obj_in_the_container(current_selected_group);
	}
	private void repainting_every_obj_in_the_container(int selected_group) {
		for(int obj_idx = 0; obj_idx < canvas_panel.array_of_groups.get(selected_group).current_objs.size(); obj_idx++) {
			canvas_panel.array_of_groups.get(selected_group).current_objs.get(obj_idx).main_label.select_this_object();
		}
	}
}