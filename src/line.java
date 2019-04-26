import java.awt.Point;
import java.util.ArrayList;

public class line {
	public int s_obj_idx = Parameters.line_start_obj_idx;
	public int e_obj_idx = Parameters.line_end_obj_idx;
	public BasicObject start_obj, end_obj;
	public Point start_p, end_p;
	public int line_type;
	public int start_port_type, end_port_type;
	line(int line_t){
		this.line_type = line_t;
		load_start_and_end_obj();
	}
	public static void move(int obj_idx, Point new_start) {
		for(int lines_idx =0; lines_idx < canvas_panel.all_lines.size();lines_idx++) {
			if(canvas_panel.all_lines.get(lines_idx).s_obj_idx == obj_idx) {
			   canvas_panel.all_lines.get(lines_idx).start_obj.start =new_start;
			   canvas_panel.all_lines.get(lines_idx).calculate_which_port_to_use();
			}
			if(canvas_panel.all_lines.get(lines_idx).e_obj_idx == obj_idx) {
				canvas_panel.all_lines.get(lines_idx).end_obj.start =new_start;
				canvas_panel.all_lines.get(lines_idx).calculate_which_port_to_use();
			}
		}
	}
	
	private void load_start_and_end_obj() {
		this.start_obj = canvas_panel.all_objs_in_canvas.get(s_obj_idx);
		this.end_obj = canvas_panel.all_objs_in_canvas.get(e_obj_idx);
		calculate_which_port_to_use();
	}
	private void calculate_which_port_to_use() {
		ArrayList<Point> s_obj_ports = new ArrayList<Point>();
		ArrayList<Point> e_obj_ports = new ArrayList<Point>();
		
		//¤W
		s_obj_ports.add(new Point(this.start_obj.start.x +50, this.start_obj.start.y));
		//¥ª
		s_obj_ports.add(new Point(this.start_obj.start.x, this.start_obj.start.y +50));
		//¥k
		s_obj_ports.add(new Point(this.start_obj.start.x +100, this.start_obj.start.y +50));
		//¤U
		s_obj_ports.add(new Point(this.start_obj.start.x +50, this.start_obj.start.y+100));


		e_obj_ports.add(new Point(this.end_obj.start.x +50, this.end_obj.start.y));
		e_obj_ports.add(new Point(this.end_obj.start.x, this.end_obj.start.y +50));
		e_obj_ports.add(new Point(this.end_obj.start.x +100, this.end_obj.start.y +50));
		e_obj_ports.add(new Point(this.end_obj.start.x +50, this.end_obj.start.y+100));
		
		double min_distance = java.lang.Integer.MAX_VALUE;
		
		for(int s_index =0; s_index < s_obj_ports.size(); s_index++) {
			
			for(int e_index =0; e_index < e_obj_ports.size(); e_index++) {
				double tmp = compute_distance(s_obj_ports.get(s_index),e_obj_ports.get(e_index));
				
				if(tmp < min_distance) {
					min_distance = tmp;
					this.start_port_type = s_index;
					this.end_port_type = e_index;
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