import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class mode_mouse extends JPanel  implements mode {
	
	private int mode = Parameters.Button.mouse.ordinal();
	public Point start_p, tmp = new Point(0,0), end_p = new Point(0,0);
	private MouseEvent press;
	private canvas_panel canvas;
	Graphics g;
	
	public mode_mouse(canvas_panel canvas){
		start_p = new Point(0,0);
		end_p = new Point(0,0);
		this.canvas = canvas;
	}
	
	public void mouseClicked(MouseEvent event) {};
	public void mouseExited(MouseEvent event){};
	public void mouseEntered(MouseEvent event){};	
	public void mousePressed(MouseEvent event){
		this.press = event;
		System.out.println(event.getPoint());	
		this.start_p = new Point(event.getPoint());
		this.tmp = event.getPoint();
		canvas_panel.unselect_all_obj();
	};
	public void mouseReleased(MouseEvent event){
		
		this.end_p = event.getPoint();
		select_by_block();		
		//this.start_p = null;
		//this.end_p = null;
	};
	public void mouseDragged(MouseEvent event){
		this.end_p = event.getPoint();
	}; 
	public void mouseMoved(MouseEvent event){
		this.end_p = event.getPoint();
	}
	
	public int getMode(){
		return this.mode;
	}
	private void select_by_block(){
		adjust_start_end_pointer();
		selecting_obj_in_the_block();
	}
	private void adjust_start_end_pointer(){
		int left_x = Math.min(this.start_p.x,this.end_p.x);
		int top_y = Math.min(this.start_p.y,this.end_p.y);
		int right_x = Math.max(this.start_p.x,this.end_p.x);
		int button_x = Math.max(this.start_p.y,this.end_p.y);
		this.start_p = new Point(left_x,top_y);
		this.end_p= new Point(right_x,button_x);
	}
	private void selecting_obj_in_the_block(){
		

	    System.out.println(this.canvas.all_objs_in_canvas.size());
		this.canvas.chosen_objs.clear();
		for(int index = 0; index < this.canvas.all_objs_in_canvas.size(); index++) {
			BasicObject tmp = this.canvas.all_objs_in_canvas.get(index);
			if(tmp.start.x >this.start_p.x&&
			   tmp.start.y >this.start_p.y&&
			   tmp.end.x <this.end_p.x&&
			   tmp.end.y <this.end_p.y) {
			    this.canvas.chosen_objs.add(tmp);
			    System.out.println(index);
			    this.canvas.chosen_objs.get(index).main_label.select_this_object();
			}
		}
	}
}
