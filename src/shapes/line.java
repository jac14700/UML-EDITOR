package shapes;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

import panels.canvas_panel;
import utilities.Parameters;

public class line extends JPanel{
	public int s_obj_idx = Parameters.line_start_obj_idx;
	public int e_obj_idx = Parameters.line_end_obj_idx;
	public BasicObject start_obj, end_obj;
	public Point start_p, end_p;
	public port start_port = new port(new Point(0,0),-1),
				end_port = new port(new Point(0,0),-1);
	public int line_type;
	public int start_port_type, end_port_type;
	
	public line(){
		load_start_and_end_obj();
	}
	
	public static void move(int obj_idx, Point new_start) {
		
		for(int lines_idx =0; lines_idx < canvas_panel.all_lines.size();lines_idx++) {
			//從憲中找到起頭為obj_idx五件的向母去更改物件的起始點位子
			if(canvas_panel.all_lines.get(lines_idx).s_obj_idx == obj_idx) {
			    canvas_panel.all_lines.get(lines_idx).start_obj.start =new_start;
			    canvas_panel.all_lines.get(lines_idx).new_start_point();
			}
			if(canvas_panel.all_lines.get(lines_idx).e_obj_idx == obj_idx) {
			   canvas_panel.all_lines.get(lines_idx).end_obj.start =new_start;
			   canvas_panel.all_lines.get(lines_idx).new_end_point();
			}
		}
	}
	
	private void load_start_and_end_obj() {
		this.start_obj = canvas_panel.all_objs_in_canvas.get(s_obj_idx);
		this.end_obj = canvas_panel.all_objs_in_canvas.get(e_obj_idx);
		calculate_which_port_to_use();
	}
	
	//Won't change this switch
	private void new_end_point() {
		switch(this.end_port.port_type) {
		//top
		case Parameters.up_port:
			this.end_port.point = new Point (this.end_obj.start.x+50, this.end_obj.start.y);
			break;
		case Parameters.left_port:
			this.end_port.point = new Point (this.end_obj.start.x, this.end_obj.start.y+50);
			break;
		case Parameters.right_port:
			this.end_port.point = new Point (this.end_obj.start.x+100, this.end_obj.start.y+50);
			break;
		case Parameters.down_port:
			this.end_port.point = new Point (this.end_obj.start.x+50, this.end_obj.start.y+100);
			break;
		}
	}
	
	//Won't change this switch
	private void new_start_point() {
		switch(this.start_port.port_type) {
		//top
		case Parameters.up_port:
			this.start_port.point = new Point (this.start_obj.start.x+50, this.start_obj.start.y);
			break;
		case Parameters.left_port:
			this.start_port.point = new Point (this.start_obj.start.x, this.start_obj.start.y+50);
			break;
		case Parameters.right_port:
			this.start_port.point = new Point (this.start_obj.start.x+100, this.start_obj.start.y+50);
			break;
		case Parameters.down_port:
			this.start_port.point = new Point (this.start_obj.start.x+50, this.start_obj.start.y+100);
			break;
		}
	}
	
	private void calculate_which_port_to_use() {
		ArrayList<Point> s_obj_ports = new ArrayList<Point>();
		ArrayList<Point> e_obj_ports = new ArrayList<Point>();
		
		//上
		s_obj_ports.add(new Point(this.start_obj.start.x +50, this.start_obj.start.y));
		//左
		s_obj_ports.add(new Point(this.start_obj.start.x, this.start_obj.start.y +50));
		//右
		s_obj_ports.add(new Point(this.start_obj.start.x +100, this.start_obj.start.y +50));
		//下
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
		this.start_port.port_type = this.start_port_type;
		this.end_port.port_type = this.end_port_type; 
		this.start_port.point = this.start_p;
		this.end_port.point = this.end_p;
	}
	
	private double compute_distance(Point one, Point two) {
		double Y = Math.abs(two.y - one.y);
	    double X = Math.abs(two.x - one.x);
	    return Math.hypot(Y, X);
	}
	
	public void drawLine(Graphics g) {}
}