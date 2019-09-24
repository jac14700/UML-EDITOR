package shapes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import panels.canvas_panel;
import utilities.Parameters;

public class BasicObject extends JPanel{
	private static final long serialVersionUID = 1L;
	public Point start,end ,center;
	public port up, down, left, right;
	protected int w_h_of_port = 12;
	
	public Main_Label main_label = new Main_Label();
	public JLabel message= new JLabel();
	protected Dimension size = new Dimension(100,100);
	public int idx_in_array_of_groups = Parameters.nonGroup;
	public int idx_in_current_objs = Parameters.nonGroup;
	public int idx_in_all_objs_in_canvas = Parameters.nonGroup;
	protected canvas_panel canvas;
	public Boolean selected = false;
	public String name = "TBNTB";
	BasicObject(){
		init();
	}
	BasicObject(Point start,canvas_panel canvas){
		init(start);
		this.canvas= canvas;
	}	
	
	private void init(){
		add_mouse_listener_to_main_label(this,this.getGraphics());
	}
	
	private void init(Point start){
		init_points(start);
		add_mouse_listener_to_main_label(this,this.getGraphics());
	}
	
	private void init_points(Point start) {
		this.start = start;
		this.center = new Point(this.start.x +this.size.width/2, this.start.y +this.size.height/2);
		this.end = new Point(this.start.x +this.size.width, this.start.y +this.size.height);
		
		this.up = new port(new Point(this.center.x,this.start.y),Parameters.up_port);
		this.down = new port(new Point(this.center.x,this.end.y),Parameters.down_port);
		this.left = new port(new Point(this.start.x,this.center.y),Parameters.left_port);
		this.right = new port(new Point(this.end.x,this.center.y),Parameters.right_port);
	}
	
	public void move(Point move_p) {
		this.start.x = this.start.x + move_p.x;
		this.start.y = this.start.y + move_p.y;
		this.center = new Point(this.start.x +this.size.width/2, this.start.y +this.size.height/2);
		this.end = new Point(this.start.x +this.size.width, this.start.y +this.size.height);
		this.up.point = new Point(this.center.x,this.start.y);;
		this.down.point = new Point(this.center.x,this.end.y);;
		this.left.point = new Point(this.start.x,this.center.y);;
		this.right.point =  new Point(this.end.x,this.center.y);;
		
		this.end.x = this.start.x +this.size.width;
		this.end.y = this.start.y +this.size.height;
		update_line_start_end_point(this.idx_in_all_objs_in_canvas,this.start);
	}
	
	private void update_line_start_end_point(int obj_idx, Point new_s) {
		line.move( obj_idx, new_s);	
	}
	
	protected void add_mouse_listener_to_main_label (BasicObject obj,Graphics g_canvas) {
		this.main_label.addMouseListener(
		new MouseListener() {

			private Point m_start = new Point(0,0);
			private Point m_end = new Point(0,0);
			public void mouseClicked(MouseEvent event){}
			
			public void mouseExited(MouseEvent event){
				canvas_panel.user_mode.ExitObjs();
			}
			
			public void mouseEntered(MouseEvent event){
				canvas_panel.user_mode.EnterObjs();
				buffering_line_end_obj();
			}

			public void mousePressed(MouseEvent event) {
				m_start = get_real_location(event.getPoint());
				canvas_panel.user_mode.PressObjs(BasicObject.this.idx_in_array_of_groups);
				buffering_line_start_obj();
			}
			
			public void mouseReleased(MouseEvent event) {
				if(canvas_panel.user_mode.is_mouse_mode()){
					canvas_panel.user_mode.ReleaseObjs();
					BasicObject.this.canvas.repaint();
					m_end = get_real_location(event.getPoint());
					move_the_entire_chosen_group(m_start,m_end);
					
				}
				else {
					canvas_panel.user_mode.ReleaseObjs();
					BasicObject.this.canvas.repaint();
				}
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
		});
	}
	public static void select_the_entire_group(int idx_in_array_of_groups){
		canvas_panel.chosen_groups.clear();
		canvas_panel.chosen_group_idx.clear();
		int current_selected_group = idx_in_array_of_groups;
		canvas_panel.chosen_groups.add(canvas_panel.array_of_groups.get(current_selected_group));
		canvas_panel.chosen_group_idx.add(current_selected_group);
		repainting_every_obj_in_the_container(current_selected_group);
	}
	private static void repainting_every_obj_in_the_container(int selected_group) {
		for(int obj_idx = 0; obj_idx < canvas_panel.array_of_groups.get(selected_group).current_objs.size(); obj_idx++) {
			canvas_panel.array_of_groups.get(selected_group).current_objs.get(obj_idx).select_this_object();
		}
	}
	public void unselected_this_obj(){
		this.selected = false;
	}
	//不是這個方式運作
	public void select_this_object(){
		this.selected = true;
	}
	public void draw(Graphics g) {
	    if(this.selected) {
	    	g.setColor(Color.RED);
		    g.fillOval(0 - w_h_of_port/2, 50 - w_h_of_port/2, w_h_of_port, w_h_of_port);
		    g.fillOval(50 - w_h_of_port/2, 0 - w_h_of_port/2, w_h_of_port, w_h_of_port);
		    g.fillOval(50 - w_h_of_port/2, 100 - w_h_of_port/2, w_h_of_port, w_h_of_port);
		    g.fillOval(100 - w_h_of_port/2, 50 - w_h_of_port/2, w_h_of_port, w_h_of_port);
	    }
	}
}