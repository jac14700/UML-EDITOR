package panels;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import modes.*;
import shapes.BasicObject;
import shapes.ObjectsContainer;
import shapes.line;



public class canvas_panel extends JPanel_Listener_MotionListener_Mouse {

	private static final long serialVersionUID = 1L;
	private int panel_w;
	private int panel_h;
	public static ArrayList<ObjectsContainer> array_of_groups = new ArrayList<ObjectsContainer>();
	public static ArrayList<BasicObject> all_objs_in_canvas = new ArrayList<BasicObject>();
	public static ArrayList<ObjectsContainer> chosen_groups =  new ArrayList<ObjectsContainer>();
	public static ArrayList<Integer> chosen_group_idx = new ArrayList<Integer>();
	public static ArrayList<line> all_lines = new ArrayList<line>();
	public static mode user_mode = new mode();
	
	
	canvas_panel(int frame_w,int frame_h) {
		init_every_setting(frame_w,frame_h);
	}
	
	private void init_every_setting(int frame_w,int frame_h)
	{
		this.panel_w = frame_w - button_panel.panel_w;
		this.panel_h = frame_h;
		this.setBackground(Color.GREEN);
		this.setLocation(new Point(button_panel.panel_w,0));
		this.setSize(new Dimension(this.panel_w, this.panel_h));
		this.setLayout(null);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	 public void mousePressed(MouseEvent event) {
		 user_mode.mousePressed(event);
	 }
	 public void mouseEntered(MouseEvent event) {
		user_mode = user_mode.get_current_mode();
		repaint();		 
	 }
	 public void mouseReleased(MouseEvent event) {
		 user_mode.mouseReleased(event);
         repaint();
     }
	 public void mouseMoved(MouseEvent event) {
		user_mode.mouseMoved(event);
     }
	 public void mouseDragged(MouseEvent event) {
        user_mode.mouseDragged(event);
        repaint();
     }
	 
	 public void paint(Graphics g){
	     super.paint(g);
	     user_mode.drawMe(g);
	   }
}