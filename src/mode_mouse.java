import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class mode_mouse extends JPanel  implements mode {
	
	private int mode = Parameters.Button.mouse.ordinal();
	public Point start_p = null, draging_p = null, end_p = null;
	private canvas_panel canvas;
	Graphics g;
	
	public mode_mouse(canvas_panel canvas){
		this.canvas = canvas;
		System.out.println("mouseDragged");
	}
	
	public void mouseClicked(MouseEvent event) {};
	public void mouseExited(MouseEvent event){};
	public void mouseEntered(MouseEvent event){};	
	public void mousePressed(MouseEvent event){
		System.out.println("mousePressed");	
		this.start_p = event.getPoint();
		canvas_panel.unselect_all_obj();
	};
	public void mouseReleased(MouseEvent event){
		System.out.println("mouseReleased");		
		//this.start_p = null;
	};
	public void mouseDragged(MouseEvent event){
		//select_by_block();
		System.out.println("mouseDragged");
		this.end_p = event.getPoint();
	}; 
	public void mouseMoved(MouseEvent event){
		System.out.println("mouseMoved");
	}
	
	public int getMode(){
		return this.mode;
	}
	private void select_by_block(){
		//adjust_start_end_pointer();
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
		System.out.println("this.start_p:"+this.start_p);
		System.out.println("this.end_p:"+this.end_p);
		for(int index = 0; index < this.canvas.all_objs_in_canvas.size(); index++) {
			BasicObject tmp = this.canvas.all_objs_in_canvas.get(index);
			System.out.println("tmp.start:"+tmp.start);
			System.out.println("tmp.end:"+tmp.end);
			if(tmp.start.x >this.start_p.x&&
			   tmp.start.y >this.start_p.y&&
			   tmp.end.x <this.end_p.x&&
			   tmp.end.y <this.end_p.y) {
				this.canvas.chosen_objs.clear();
			    this.canvas.chosen_objs.add(tmp);
			    this.canvas.chosen_objs.get(index).main_label.select_this_object();
			}
		}
	}
}
