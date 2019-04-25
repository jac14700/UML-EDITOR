import java.awt.Point;
import java.util.ArrayList;

public class line {
	protected void draw() {};
	public BasicObject start_obj, end_obj;
	public Point start_p, end_p;
	
	line(){
		load_start_and_end_obj();
	}
	
	private void load_start_and_end_obj() {
		int s_group_idx = Parameters.line_start_group_idx;
		int s_obj_idx = Parameters.line_start_obj_idx;
		int e_group_idx = Parameters.line_end_group_idx;
		int e_obj_idx = Parameters.line_end_obj_idx;
		this.start_obj = canvas_panel.array_of_groups.get(s_group_idx).current_objs.get(s_obj_idx);
		this.end_obj = canvas_panel.array_of_groups.get(e_group_idx).current_objs.get(e_obj_idx);
		calculate_which_port_to_use();
	}
	private void calculate_which_port_to_use() {
		ArrayList<Point> s_obj_ports = new ArrayList<Point>();
		ArrayList<Point> e_obj_ports = new ArrayList<Point>();
		s_obj_ports.add(new Point(this.start_obj.start.x +50, this.start_obj.start.y));
		s_obj_ports.add(new Point(this.start_obj.start.x, this.start_obj.start.y +50));
		s_obj_ports.add(new Point(this.start_obj.start.x +100, this.start_obj.start.y +50));
		s_obj_ports.add(new Point(this.start_obj.start.x +50, this.start_obj.start.y+100));


		e_obj_ports.add(new Point(this.end_obj.start.x +50, this.end_obj.start.y));
		e_obj_ports.add(new Point(this.end_obj.start.x, this.end_obj.start.y +50));
		e_obj_ports.add(new Point(this.end_obj.start.x +100, this.end_obj.start.y +50));
		e_obj_ports.add(new Point(this.end_obj.start.x +50, this.end_obj.start.y+100));
		
		double min_distance = java.lang.Integer.MAX_VALUE;
		
		for(int s_index =0; s_index < s_obj_ports.size(); s_index++) {
			
			for(int e_index =0; e_index < e_obj_ports.size(); e_index++) {
				double tmp = compute_distance(s_obj_ports.get(s_index),e_obj_ports.get(e_index));
				//System.out.println(s_obj_ports.get(s_index));
				//System.out.println(e_obj_ports.get(e_index));
				
				if(tmp < min_distance) {
					min_distance = tmp;
					this.start_p = s_obj_ports.get(s_index);
					this.end_p = e_obj_ports.get(e_index);
				}
			}
		}
	}
	private double compute_distance(Point one, Point two) {
		double Y = Math.abs(two.y - one.y);
	    double X = Math.abs(two.x - one.x);
	    return Math.hypot(Y, X);
	}
}