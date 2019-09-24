package modes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import buttons.buttons;
import panels.JPanel_Listener_MotionListener_Mouse;
import panels.canvas_panel;
import utilities.Parameters;

public class mode extends JPanel_Listener_MotionListener_Mouse {
	private static final long serialVersionUID = 1L;
	public static int start_g_idx_in_array_of_groups = Parameters.no_obj;
	public static int start_obj_idx_in_the_group  = Parameters.no_obj;
	public static mode_no_action m_no_action= new mode_no_action();
	
	
	public mode() {}
	public void mouseClicked(MouseEvent arg0) {};
	public void mouseExited(MouseEvent arg0) {};
	public void mouseEntered(MouseEvent arg0) {};
	public void mousePressed(MouseEvent arg0) {};
	public void mouseReleased(MouseEvent arg0){};
	public void mouseDragged(MouseEvent e) {}; 
	public void mouseMoved(MouseEvent e) {};
	public int getMode() {return -1;};
	
	public void ExitObjs() {}
	public void PressObjs(int idx) {}
	public void ReleaseObjs() {}
	public void EnterObjs() {}
	public boolean is_mouse_mode() {
		return buttons.idx_which_is_chosen == Parameters.Button.mouse.ordinal();
	}
	public mode get_current_mode() {
		if(buttons.idx_which_is_chosen ==-1)
		{
			return m_no_action;
		}
		else{
			return buttons.group[buttons.idx_which_is_chosen].mode_;
		}
	}

	 public void drawMe(Graphics g) {
		 if(canvas_panel.all_lines.size()!=0) { drawLine(g);}
		 
		 for(int idx =0; idx <canvas_panel.all_objs_in_canvas.size(); idx++) {
			 canvas_panel.all_objs_in_canvas.get(idx).draw(g);
		 }
	 }
	 public void drawLine(Graphics g) {
		 g.setColor(Color.BLACK);
		 for(int idx =0; idx <canvas_panel.all_lines.size(); idx++) {
			 canvas_panel.all_lines.get(idx).drawLine(g);
		 }
		 for(int idx =0; idx <canvas_panel.all_objs_in_canvas.size(); idx++) {
			 canvas_panel.all_objs_in_canvas.get(idx).draw(g);
		 }
	 }
}