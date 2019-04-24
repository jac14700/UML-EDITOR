import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class mode_mouse extends JPanel  implements mode {
	private static final long serialVersionUID = 1L;
	private int mode = Parameters.Button.mouse.ordinal();
	public Point start_p, end_p = new Point(0,0);
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
		System.out.println("array_of_groups size: " + canvas_panel.array_of_groups.size());
		Parameters.temp_for_mode_mouse_start_p = event.getPoint();
		canvas_panel.unselect_all_obj();
	};

	public void mouseReleased(MouseEvent event){
		//System.out.println("array_of_groups size: " + this.canvas.array_of_groups.size());
		this.start_p = Parameters.temp_for_mode_mouse_start_p;
		this.end_p = event.getPoint();
		select_by_block();
		//System.out.println("array_of_groups size: " + this.canvas.array_of_groups.size());
	};
	private void select_by_block(){
		adjust_start_end_pointer();
		selecting_obj_in_the_block();
		chosen_group_repaint();
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
		canvas_panel.chosen_groups.clear();
		canvas_panel.chosen_group_idx.clear();
	    for(int container_index =0;container_index  < canvas_panel.array_of_groups.size();container_index ++) {
		    	ObjectsContainer tmp_container = canvas_panel.array_of_groups.get(container_index);
		    	
		    	if(every_obj_of_tmp_container_in_the_block(tmp_container)){
		    		canvas_panel.chosen_groups.add(tmp_container);
		    		canvas_panel.chosen_group_idx.add(container_index);}
		    	else{continue;}
	    }	
	}
	private boolean every_obj_of_tmp_container_in_the_block(ObjectsContainer tmp_container) {
		boolean true_or_false = true;
		for(int index = 0; index < tmp_container.current_objs.size(); index++) {
			BasicObject tmp_obj = tmp_container.current_objs.get(index);
			if(tmp_obj.start.x <this.start_p.x||
			   tmp_obj.start.y <this.start_p.y||
			   tmp_obj.end.x   >this.end_p.x  ||
			   tmp_obj.end.y   >this.end_p.y) {
				true_or_false = false;
				break;
			}
		}
		return true_or_false;
	}
	private void chosen_group_repaint()
	{
		for(int g_index = 0; g_index < canvas_panel.chosen_groups.size(); g_index ++) {
			for(int obj_index = 0; obj_index < canvas_panel.chosen_groups.get(g_index).current_objs.size(); obj_index++) {
				canvas_panel.chosen_groups.get(g_index).current_objs.get(obj_index).main_label.select_this_object();
			}
		}
	}
	public void mouseDragged(MouseEvent event){
		//this.end_p = event.getPoint();
	}; 
	public void mouseMoved(MouseEvent event){
		//this.end_p = event.getPoint();
	}
	public int getMode(){
		return this.mode;
	}	
}
