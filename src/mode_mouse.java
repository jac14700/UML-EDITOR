import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class mode_mouse extends JPanel  implements mode {
	private static final long serialVersionUID = 1L;
	private int mode = Parameters.Button.mouse.ordinal();
	public Point m_start, m_end = new Point(0,0);
	private canvas_panel canvas;
	Graphics g;
	
	public mode_mouse(canvas_panel canvas){
		m_start = new Point(0,0);
		m_end = new Point(0,0);
		this.canvas = canvas;
	}
	
	public void mouseClicked(MouseEvent event) {};
	public void mouseExited(MouseEvent event){};
	public void mouseEntered(MouseEvent event){};
	public void mousePressed(MouseEvent event){
		Parameters.temp_for_mode_mouse_m_start = event.getPoint();
		canvas_panel.unselect_all_obj();
	};

	public void mouseReleased(MouseEvent event){
		this.m_start = Parameters.temp_for_mode_mouse_m_start;
		this.m_end = event.getPoint();
		select_by_block();
	};
	private void select_by_block(){
		adjust_start_m_endointer();
		selecting_obj_in_the_block();
		chosen_group_repaint();
	}
	private void adjust_start_m_endointer(){
		int left_x = Math.min(this.m_start.x,this.m_end.x);
		int top_y = Math.min(this.m_start.y,this.m_end.y);
		int right_x = Math.max(this.m_start.x,this.m_end.x);
		int button_x = Math.max(this.m_start.y,this.m_end.y);
		this.m_start = new Point(left_x,top_y);
		this.m_end= new Point(right_x,button_x);
	}
	
	private void selecting_obj_in_the_block(){
		canvas_panel.chosen_groups.clear();
		canvas_panel.chosen_group_idx.clear();
	    for(int container_index =0;container_index  < canvas_panel.array_of_groups.size();container_index ++) {
		    	if(every_obj_of_tmp_container_in_the_block(container_index)){
		    		canvas_panel.chosen_groups.add(canvas_panel.array_of_groups.get(container_index));
		    		canvas_panel.chosen_group_idx.add(container_index);}
		    	else{continue;}
	    }	
	}
	private boolean every_obj_of_tmp_container_in_the_block(int container_index) {
		boolean true_or_false = true;
		for(int index = 0; index < canvas_panel.array_of_groups.get(container_index).current_objs.size(); index++) {
			BasicObject tmp_obj = canvas_panel.array_of_groups.get(container_index).current_objs.get(index);
			if(tmp_obj.start.x <this.m_start.x||
			   tmp_obj.start.y <this.m_start.y||
			   tmp_obj.end.x   >this.m_end.x  ||
			   tmp_obj.end.y   >this.m_end.y) {
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
	}; 
	public void mouseMoved(MouseEvent event){
	}
	public int getMode(){
		return this.mode;
	}	
}
